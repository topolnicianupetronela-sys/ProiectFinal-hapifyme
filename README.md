ProiectFinal – HapifyMe

Descriere

Acest repository GitHub conține un framework de testare automatizată dezvoltat pentru aplicația web HapifyMe, disponibilă la:
https://test.hapifyme.com

Framework-ul este conceput pentru testarea atât a API-urilor, cât și a interfeței web, având ca obiectiv validarea funcționalităților principale ale aplicației și identificarea rapidă a defectelor.

Tehnologii utilizate

Proiectul este construit folosind următoarele tehnologii și tool-uri:

Maven / Gradle – managementul dependențelor și rularea testelor

RestAssured – testarea serviciilor REST (API)

Selenide – testarea interfeței web (UI)

Java – limbajul principal de implementare

Continuous Integration (CI)

Proiectul include integrare Continuous Integration (CI) prin GitHub Actions, configurată în fișierul:

.github/workflows/test.yml

Workflow CI

Workflow-ul este declanșat automat la:

push

pull request

Pipeline-ul CI:

Instalează mediul necesar (Java + Maven/Gradle)

Rulează automat suitele de teste

Rulare locală

Pentru a rula testele local, sunt necesare următoarele:

Java instalat

Maven sau Gradle (în funcție de configurația proiectului)

Comandă de rulare
mvn test


<img width="1880" height="833" alt="Screenshot 2026-01-18 184457" src="https://github.com/user-attachments/assets/0c0b82f4-5704-4115-8ffe-6e0c362f76fd" />


Bug identificat – API Update Profile

Descriere: Endpoint-ul de actualizare a profilului trunchiază ultimul caracter din câmpul first_name.

Rezultat așteptat:

Câmpul first_name returnat de endpoint-ul get_profile.php trebuie să fie identic cu valoarea trimisă la actualizare: "first_name": "Updated_Georgeanna Gutmann"


Rezultat actual:

Valoarea first_name este modificată de backend: "first_name": "Updated_Georgeanna Gutman"


<img width="1233" height="702" alt="Screenshot 2026-01-17 204711" src="https://github.com/user-attachments/assets/e3908e95-0a89-4d57-b50b-71ee270c3d8c" />


