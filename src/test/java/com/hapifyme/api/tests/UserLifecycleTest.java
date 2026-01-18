package com.hapifyme.api.tests;

import com.hapifyme.api.models.*;
import com.hapifyme.api.utils.ApiPoller;
import com.hapifyme.api.utils.DataGenerator;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserLifecycleTest {

    private static final String BASE_URI = "https://test.hapifyme.com/api";

    private String email;
    private String firstName;
    private String lastName;
    private final String password = "Pass1234567!";
    private String apiKey;
    private String userId;
    private String bearerToken;
    private String username;

    @BeforeClass
    void setup() {
        RestAssured.baseURI = BASE_URI;
        email = DataGenerator.randomEmail();
        firstName = DataGenerator.randomName();
        lastName = DataGenerator.randomName();
    }

    // Înregistrare Utilizator (Obținem API Key și User ID)
    @Test
    public void testFullUserLifecycle() {

        RegisterRequest registerRequest =
                new RegisterRequest(firstName, lastName, email, password);

        System.out.println("Se încearcă înregistrarea userului: " + email);

        RegisterResponse registerResponse =
                given()
                        .baseUri(BASE_URI)
                        .contentType(ContentType.JSON)
                        .body(registerRequest)
                        .log().all()        // Vedem requestul in consolă
                        .when()
                        .post("/user/register.php")
                        .then()
                        .log().all()        // Vedem răspunsul în consolă
                        .statusCode(201)
                        .extract()
                        .as(RegisterResponse.class);

        assertThat(registerResponse.getStatus(), is("success"));
        assertThat(registerResponse.getUserId(), not(emptyString()));
        assertThat(registerResponse.getApiKey(), not(isEmptyOrNullString()));

        // Salvare date
        userId = registerResponse.getUserId();
        apiKey = registerResponse.getApiKey();
        username = registerResponse.getUsername();

        System.out.println("User creat cu ID: " + registerResponse.getUserId() +
                " | API Key: " + registerResponse.getApiKey());

        // Async Check: Folosește Awaitility (ApiPoller) pentru a aștepta generarea confirmation_token pe endpoint-ul /user/retrieve_token.php
        String statusUrl = "https://test.hapifyme.com/api/user/retrieve_token.php?username_or_email=" + email;
        ApiPoller.pollForStatus(statusUrl, "success", apiKey);

        String confirmationToken =
                given()
                        .baseUri(BASE_URI)
                        .header("Authorization", apiKey)
                        .when()
                        .get(statusUrl)
                        .then()
                        .extract()
                        .path("confirmation_token");

        // Activare Cont: Email Confirmation
        given()
                .baseUri(BASE_URI)
                .log().all()
                .queryParam("token", confirmationToken)
                .when()
                .get("/user/confirm_email.php")
                .then()
                .statusCode(200);

        // Login user (extragem token (Bearer Token))
        LoginRequest loginRequest =
                new LoginRequest(username, password);

        LoginResponse loginResponse =
                given()
                        .baseUri(BASE_URI)
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body(loginRequest)
                        .when()
                        .post("/user/login.php")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(LoginResponse.class);

        bearerToken = loginResponse.getToken();
        System.out.println("Login Done. Bearer Token: " + bearerToken);

        // Validări (Type Safe)
        Assert.assertEquals(loginResponse.getStatus(), "success", "Statusul nu este cel așteptat!");
        Assert.assertNotNull(loginResponse.getToken(), "Token-ul lipsește!");
        Assert.assertTrue(loginResponse.getToken().length() > 20, "Token-ul pare prea scurt/invalid!");

        // Verificare profil: verifică dacă datele (email, nume) corespund cu cele de la înregistrare
        ProfileResponse profile =
                given()
                        .baseUri(BASE_URI)
                        .log().all()
                        .header("Authorization", apiKey)
                        .queryParam("user_id", userId)
                        .when()
                        .get("/user/get_profile.php")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(ProfileResponse.class);

        assertThat(profile.getUser().getEmail(), equalTo(email));
        assertThat(profile.getUser().getFirstName(), equalTo(firstName));
        assertThat(profile.getUser().getLastName(), equalTo(lastName));

        // Modificare profil
        String updatedFirstName = "Updated_" + firstName;
        UserProfileRequest updateRequest = new UserProfileRequest();
        updateRequest.setUserId(userId);
        updateRequest.setFirstName(updatedFirstName);
        updateRequest.setLastName(lastName);
        updateRequest.setEmail(email);

        given()
                .baseUri(BASE_URI)
                .log().all()
                .header("Authorization", apiKey)
                .contentType(ContentType.JSON)
                .body(updateRequest)
                .when()
                .put("/user/update_profile.php")
                .then()
                .log().all()
                .statusCode(200);

        // Verificăm modificare profil
        ProfileResponse updatedProfile =
                given()
                        .baseUri(BASE_URI)
                        .log().all()
                        .header("Authorization", apiKey)
                        .queryParam("user_id", userId)
                        .when()
                        .get("/user/get_profile.php")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(ProfileResponse.class);

        assertThat(updatedProfile.getUser().getFirstName(), equalTo(updatedFirstName));

        // Stergere profil
        given()
                .baseUri(BASE_URI)
                .log().all()
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .delete("/user/delete_profile.php")
                .then()
                .log().all()
                .statusCode(200);

        // Scenariu negativ (utilizatorul nu mai există)
        given()
                .baseUri(BASE_URI)
                .header("Authorization", "Bearer " + bearerToken)
                .queryParam("user_id", userId)
                .when()
                .get("/user/get_profile.php")
                .then()
                .log().ifValidationFails()
                .statusCode(anyOf(is(401), is(404)));
    }
}