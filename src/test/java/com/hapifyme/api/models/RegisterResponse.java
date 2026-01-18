package com.hapifyme.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("api_key")
    private String apiKey;

    @JsonProperty("confirmation_token")
    private String confirmationToken;

    @JsonProperty("username")
    private String username;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public String getUsername() {
        return username;
    }
}