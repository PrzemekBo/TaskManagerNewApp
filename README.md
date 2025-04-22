# 🗂️ Task Manager App

🎯 A complete REST API for managing tasks and users within a team.  
This project was created as part of a **recruitment task**.

Built with:
- **Spring Boot 3**
- **Jakarta Validation**
- **Lombok**
- **Spring Data JPA**
- **H2 database (in-memory)**

---

## 📋 Features

- ✅ Add, edit, delete tasks
- 🔁 Update task status via dedicated endpoint
- 👥 Assign multiple users to a task
- 🔍 Filter and sort tasks and users
- 🧾 Pageable API responses
- 📦 Clean DTO-based input/output
- ⚙️ H2 console enabled (`/h2-console`)

---

## 📂 Technologies

| Component        | Stack              |
|------------------|--------------------|
| Language         | Java 17 ☕         |
| Framework        | Spring Boot 3 🚀  |
| Database         | H2 (in-memory) 🗄️ |
| ORM              | Spring Data JPA 🔗 |
| Validation       | Jakarta Validation ✔️ |
| Lombok           | ✅ Yes             |
| Testing (optional) | JUnit 5, Mockito 🧪 |

---
### 👤 User Endpoints

| Method  | Endpoint           | Description                          |
|---------|--------------------|--------------------------------------|
| POST    | /api/users         | ➕ Create a new user                 |
| DELETE  | /api/users/{id}    | ❌ Delete user by ID                |
| GET     | /api/users         | 🔍 List users with filtering/sorting |

- firstName — filter by first name
- lastName — filter by last name
- page — pagination
- size — number of results per page
- sort — field and direction (e.g. `sort=lastName,asc`)

  GET /api/users?firstName=Anna&sort=lastName,asc&page=0&size=5

  ### 📌 Task Endpoints

| Method  | Endpoint                    | Description                               |
|---------|-----------------------------|-------------------------------------------|
| POST    | /api/tasks                 | ➕ Create a new task                       |
| PUT     | /api/tasks/{id}            | 📝 Update full task                       |
| PATCH   | /api/tasks/{id}/status     | 🔁 Update task status only                |
| DELETE  | /api/tasks/{id}            | ❌ Delete a task                           |
| GET     | /api/tasks                 | 🔍 List tasks with filtering/sorting      |

- title — filter by task title
- status — filter by task status (`TODO`, `IN_PROGRESS`, `DONE`)
- page — pagination
- size — number of results per page
- sort — field and direction (e.g. `sort=dueDate,desc`)

 GET /api/tasks?status=TODO&title=Projekt&sort=dueDate,desc&page=0&size=10
## 🚀 How to Run

```bash
./mvnw spring-boot:run


