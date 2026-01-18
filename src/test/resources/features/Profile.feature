Feature: Căutarea unui utilizator și accesarea profilului său

  Background:
    # Acesta este pasul de legătură.
    # Nu repetăm pașii de "Introduce user", "Apasa buton".
    Given utilizatorul este logat în aplicație

  Scenario: Caută un utilizator și accesează profilul
    When utilizatorul caută "Petronela" în bara de navigare
    Then ar trebui să vadă o listă de rezultate care conține "Petronela"
