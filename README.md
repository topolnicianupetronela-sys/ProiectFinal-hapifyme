ProiectFinal-hapifyme

Repository-ul GitHub conține un framework de testare automatizată dezvoltat pentru aplicația https://test.hapifyme.com

Framework-ul este bazat pe: 
Maven / Gradle pentru managementul dependențelor și rularea testelor
RestAssured pentru testarea API-urilor
Selenide pentru testarea interfeței web

Proiectul include integrare Continuous Integration (CI) prin GitHub Actions, configurată în fișierul:
.github/workflows/test.yml

Workflow-ul rulează automat testele la:
push
pull request

Pipeline-ul:
instalează mediul necesar (Java + Maven/Gradle)
rulează testele automat

Pentru a rula testele local, este necesar:
Java instalat
Maven (sau Gradle, în funcție de configurație)

Comanda de rulare:
mvn test


<img width="1880" height="833" alt="Screenshot 2026-01-18 184457" src="https://github.com/user-attachments/assets/0c0b82f4-5704-4115-8ffe-6e0c362f76fd" />


Bug API: Update Profile trunchiază ultimul caracter din first_name la actualizarea profilului 
Rezultat așteptat: Câmpul first_name returnat de endpoint-ul get_profile.php trebuie să fie identic cu valoarea trimisă la actualizare
"first_name": "Updated_Georgeanna Gutmann"

Rezultat actual: Valoarea first_name este modificată de backend
"first_name": "Updated_Georgeanna Gutman"

La urmatoarea rulare testul a trecut

<img width="1233" height="702" alt="Screenshot 2026-01-17 204711" src="https://github.com/user-attachments/assets/e3908e95-0a89-4d57-b50b-71ee270c3d8c" />


