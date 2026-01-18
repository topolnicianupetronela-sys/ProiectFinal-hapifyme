Feature: Autentificare în HapifyMe

  Background:
    Given utilizatorul deschide pagina de login "https://test.hapifyme.com/login_register.php"

  @valid
  Scenario: Login cu succes folosind credențiale valide
    When utilizatorul introduce emailul "topolnicianu.petronela@gmail.com"
    And utilizatorul introduce parola "Test!123"
    And utilizatorul apasă butonul de login
    Then utilizatorul ar trebui să fie redirecționat către homepage

  @negative
  Scenario Outline: Login eșuat cu date invalide
    When utilizatorul introduce emailul "<email>"
    And utilizatorul introduce parola "<password>"
    And utilizatorul apasă butonul de login
    Then utilizatorul ar trebui să vadă un mesaj de eroare "<error_message>"

    Examples:
      | email                            | password    | error_message                   |
      | user.test@test.com               | test12345   | Email or password was incorrect |
      | petronela.topolnicianu@gmail.com | password123 | Email or password was incorrect |
