# 💰 ExpenseMate - Backend

ExpenseMate is a **personal finance tracking system** that helps users record, categorize, and analyze their expenses and income.  
This repository contains the **backend service**, built with **Spring Boot**, using **Hexagonal Architecture (Ports & Adapters)** and **Domain-Driven Design (DDD)** principles.

---

## ✨ Features
- 👤 User management (signup, login, authentication with JWT)
- 💸 Expense & income tracking
- 📊 Categorization of transactions
- 📂 Budget & cash flow insights (future roadmap)
- 🧩 Clean architecture (Hexagonal + DDD)

---

## 🏗️ Tech Stack
- **Java 21 / Kotlin**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **PostgreSQL 17.6**
- **Flyway 11.7.2**
- **Spring Security (JWT)**
- **Gradle (Kotlin DSL, JAR packaging)**

---

## 📂 Project Structure

```
expensemate-backend/
├── core/                 # Domain layer (Entities, Value Objects, Services)
│   ├── model/
│   ├── service/
│   └── exception/
│
├── ports/                # Ports (Interfaces)
│   ├── inbound/          # Input ports (use cases)
│   └── outbound/         # Output ports (repositories, external systems)
│
├── infra/                # Infrastructure (Adapters)
│   ├── inbound/          # REST Controllers, DTOs
│   └── outbound/         # Persistence (JPA), Security, Config
│
└── util/                 # Shared utilities, constants, helpers
```

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Raja-shekaran/expensemate-backend.git
cd expensemate-backend
```

### 2️⃣ Configure Database
Update **`application.yml`** with your PostgreSQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/expensemate
    username: your_db_user
    password: your_db_password
  jpa:
    hibernate:
      ddl-auto: none
```

### 3️⃣ Run the Application
Using Gradle:
```bash
./gradlew bootRun
```

Or build and run the JAR:
```bash
./gradlew clean build
java -jar build/libs/expensemate-0.0.1-SNAPSHOT.jar
```

### 4️⃣ API Endpoints (to be added)
- `POST /api/v1/auth/register` → Register user
- `POST /api/v1/auth/login` → Authenticate & get JWT
- `POST /api/v1/transactions` → Add transaction
- `GET /api/v1/transactions/{userId}` → Get user’s transactions

---

## 🧪 Testing
Run unit and integration tests:
```bash
./gradlew test
```

---

## 👨‍💻 Author
**Rajashekaran S**
- GitHub: [@Raja-shekaran](https://github.com/Raja-shekaran)
- LinkedIn: [Rajashekaran S](https://www.linkedin.com/in/rajashekaran-s-b85754307/)
