Feature: Înregistrare Utilizator

  Scenario: Înregistrare cu succes
    Given utilizatorul deschide pagina de login "https://test.hapifyme.com/login_register.php"
    # Formularul de înregistrare este ascuns implicit. Trebuie să facem click pe link-ul "Need an account?".
    And utilizatorul accesează formularul de înregistrare
    When completează formularul de înregistrare:
      | First Name  | Last Name | Email                     | Confirm Email             | Password   | Confirm Password |
      | Utilizator9 | User      | test.utilizator9@test.com | test.utilizator9@test.com | Passw1234! | Passw1234!       |
      | Utilizator10 | User      | test.utilizator10@test.com | test.utilizator10@test.com | Passw@4321 | Passw@4321       |

    Then You're all set! Go ahead and login!