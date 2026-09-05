# Profile Environment REST API

A Spring Boot application demonstrating dynamic environment configuration management using **Spring Profiles** (`dev`, `qa`, `uat`, `prod`). The application dynamically loads profile-specific properties, database configurations, and service implementations based on the active runtime environment.

---

## 🚀 Environments Overview

The project supports four isolated execution environments:

| Environment | Profile Key | Default Port | Primary Purpose |
| :--- | :--- | :--- | :--- |
| **Development** | `dev` | `6161` | Local development and fast feature iteration |
| **QA** | `qa` | `6162` | Automated testing, QA verification, regression |
| **UAT** | `uat` | `6163` | User Acceptance Testing and staging builds |
| **Production** | `prod` | `8080` | Live customer traffic and production workloads |

---

## 🛠️ Project Configuration & Property Hierarchy

Configuration files are located under `src/main/resources/`:

* **`application.properties`**: Base properties and fallback default (`spring.profiles.active=dev`).
* **`application-dev.properties`**: Dev-specific configurations.
* **`application-qa.properties`**: QA testing configurations.
* **`application-uat.properties`**: UAT staging configurations.
* **`application-prod.properties`**: Production live configurations.
  
## In Code it is used same server port
### Sample Configuration Structure

```properties
# application-dev.properties
app.name=ProfileEnvironment [DEV]
app.version=1.0.0-DEV
server.port=6161
app.activated.server=dev

🏃 How to Run the Application
1. Maven Plugin (Recommended for Local Dev)
Run with the DEV profile:

mvn spring-boot:run -Dspring-boot.run.profiles=dev

Run with the QA profile:

mvn spring-boot:run -Dspring-boot.run.profiles=qa

Run with the PROD profile:

mvn spring-boot:run -Dspring-boot.run.profiles=prod

Execute JAR with profile parameter:

# Using JVM argument
java -Dspring.profiles.active=prod -jar target/ProfileEnvironment-1.0.0.jar

# Using Command-line argument
java -jar target/ProfileEnvironment-1.0.0.jar --spring.profiles.active=qa
