Feature: Crearea postare pe feed

  Background:
    # Acesta este pasul de legătură.
    # Nu repetăm pașii de "Introduce user", "Apasa buton".
    Given utilizatorul este logat în aplicație

  Scenario: Creare postare
    When utilizatorul creează o postare cu mesajul "Hello!  test generated2"
    Then postarea ar trebui să fie afișată cu textul "Hello!  test generated2"
