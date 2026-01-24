Proiect Final HapifyMe 
 
 

This repository is part of my QA Automation portfolio and showcases my skills in: 

🔹 designing and implementing an automated testing framework 

🔹 API and UI test automation 

🔹 integrating automated tests into a CI pipeline 


The application under test is HapifyMe, available in the test environment at: 
🔗 https://test.hapifyme.com 

 

Project Purpose 

The main goal of this project is to demonstrate: 

🔹 solid understanding of end-to-end automated testing concepts 

🔹 practical usage of modern QA Automation tools 

🔹 ability to identify, reproduce, and document real defects 

🔹 automated test execution within a Continuous Integration (CI) setup 

 

Test Coverage 

The framework covers the following types of testing: 

🔹 API Testing 
Validation of REST endpoints using RestAssured 

🔹 UI Testing 
Automation of web interface tests using Selenide 

 

 Technologies & Tools 

Java – primary programming language 

Maven  – dependency management and test execution 

RestAssured – REST API testing 

Selenide – UI test automation 

GitHub Actions – Continuous Integration (CI) 

 

Continuous Integration (CI) 

The project includes an automated CI pipeline configured with GitHub Actions. 

📁 Workflow configuration: 

.github/workflows/test.yml 
 

Pipeline triggers: 

🔹 push 

🔹 pull request 

Pipeline steps: 

🔹 sets up the required environment (Java + Maven) 

🔹 executes all automated test suites 

🔹 validates application stability 

 

Running Tests Locally 

Prerequisites: 

Java installed 

Maven or Gradle (depending on project configuration) 

Run command: 

mvn test 
 

<img width="1880" height="833" alt="Screenshot 2026-01-18 184457" src="https://github.com/user-attachments/assets/0c0b82f4-5704-4115-8ffe-6e0c362f76fd" />
 

Example of Identified Bug (API Testing) 

Description 

During automated API testing, a defect was identified in the Update Profile endpoint, where the last character of the first_name field is truncated. 

 

Expected Result 

The get_profile.php endpoint should return the exact value sent during the update request: 

"first_name": "Updated_Georgeanna Gutmann" 
 


Actual Result 

The backend modifies the first_name value: 

"first_name": "Updated_Georgeanna Gutman" 

 

<img width="1233" height="702" alt="Screenshot 2026-01-17 204711" src="https://github.com/user-attachments/assets/e3908e95-0a89-4d57-b50b-71ee270c3d8c" />


