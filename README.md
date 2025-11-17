# Spring Data JPA – Muscle Memory Repository

This repository is a **comprehensive, task-driven implementation** of all core and advanced concepts in the **Spring Data JPA module** of the *Spring Boot Mastery Learning Plan*.

It focuses on **building true hands-on muscle memory** through incremental coding tasks, ensuring practical mastery of JPA repositories, queries, entity relationships, lifecycle events, and advanced features like projections and specifications.

**All tasks were assigned by ChatGPT**, and **each implementation was fully coded by the author (Chandra Sekhar)** based on the structured Spring Data JPA learning plan.

**This repository is solely a record of learning and implementation work; it holds no other functional purpose.**

---

## 📘 Project Overview

**Repository Name:** `spring-data-jpa-muscle-memory`

**Language:** Java 21
**Framework:** Spring Boot 3.x
**Build Tool:** Maven
**IDE Used:** IntelliJ IDEA
**Author:** Chandra Sekhar

This repository covers **6 major topics** from the official `SPRING DATA JPA.txt` learning plan, each broken down into structured, incremental hands-on tasks.

---

## 🧩 Topics & Coverage

| Topic No. | Topic Name                          | Description                                                                                                         |
| --------- | ----------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| **1**     | Repository Abstractions             | Implemented CRUD operations, paging, and sorting using built-in Spring Data JPA features.                           |
| **2**     | Query Methods & Custom Queries      | Demonstrated derived queries, JPQL, native queries, named queries, and modifying operations.                        |
| **3**     | Entity Relationships & Associations | Built one-to-one, one-to-many, many-to-one, and many-to-many mappings (both unidirectional and bidirectional).      |
| **4**     | Entity Lifecycle & Callbacks        | Implemented JPA lifecycle callbacks, entity listeners, auditing, and persistence state transitions.                 |
| **5**     | Advanced JPA Concepts               | Implemented DTO projections, interface projections, open projections, and JPA Specifications for dynamic filtering. |
| **6**     | Performance & Optimization Basics   | Practiced entity fetching strategies, lazy loading awareness, and optimizing repository queries.                    |

---

## 🧠 Learning Objective

The goal of this repository is to **develop instinctive fluency in Spring Data JPA** by mastering:

* Repository abstractions and CRUD operations
* JPQL, native, and named queries
* Entity mapping and relationship modeling
* Entity lifecycle events and auditing
* Projections (DTO, Interface, Open)
* JPA Specifications for dynamic queries
* Persistence context behavior and entity states

Each task is **self-contained** and runnable independently for focused practice.

---

## 🧮 Project Structure

```
spring-data-jpa-muscle-memory/
 ├── src/
 │   ├── main/
 │   │   ├── java/
 │   │   │   ├── topic1_repository/
 │   │   │   ├── topic2_queries/
 │   │   │   ├── topic3_customqueries/
 │   │   │   ├── topic4_relationships/
 │   │   │   ├── topic5_entitylifecycle/
 │   │   │   └── topic6_advanced/
 │   │   └── resources/
 │   │       └── application.properties
 ├── pom.xml
 └── .gitignore
```

Each topic folder contains multiple task packages (e.g., `task1`, `task2`, etc.), each with its own entity, repository, and runner class.

---

## ▶️ Running Individual Tasks

Each task includes its own `AppRunner` class.

### Run from IntelliJ IDEA

1. Open the project.
2. Navigate to the desired task (e.g. `topic3_customqueries/task2/AppRunner.java`).
3. Right-click → **Run ‘AppRunner.main()’**.

---

## 🧩 Git Commit Convention

Each commit follows the standard convention:

```
feat: implement <topic>-<task> – <short description>
```

**Examples:**

```
feat: implement task3.2 – demonstrate JPQL custom query
feat: implement task4.5 – establish bidirectional one-to-many mapping
feat: implement task5.3 – demonstrate entity lifecycle callbacks
```

---

## ⚙️ Prerequisites

* Java 21+
* Maven 3.9+
* IntelliJ IDEA or VS Code
* Spring Boot 3.x dependencies (managed via Maven)

---

## 🧠 Key Learnings & Takeaways

* Mastery of **Spring Data JPA repositories** and CRUD operations.
* Ability to write custom JPQL and native queries.
* Strong understanding of **entity relationships and mapping strategies**.
* Confidence in handling **entity lifecycle callbacks and auditing**.
* Knowledge of **projection and specification patterns** for optimized queries.
* Clean, maintainable repository layer design for real-world applications.

---

## 🖯 Next Phase

→ Proceed to the **Spring MVC Module** following the same task-driven structure.
Each new module continues to build on this foundation.

---

**Author:** *Chandra Sekhar*
**Learning Journey:** *Spring Boot Mastery Plan*
**Mentorship & Tasks Provided By:** *ChatGPT (OpenAI)*
