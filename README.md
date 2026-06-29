# Purchase Service

## Overview

The **Purchase Service** manages course enrollments and purchase operations within the E-Learn Microservices Platform. It ensures that learners can securely purchase courses, prevents duplicate enrollments, maintains purchase history, and serves as the source of truth for course ownership.

This service plays a critical role in determining learner access to purchased courses and enables future integrations with payment, analytics, and notification services.

---

## Responsibilities

* Course Purchase
* Purchase Validation
* Duplicate Purchase Prevention
* Purchase History
* Purchased Courses Retrieval
* Course Access Verification
* Purchase Event Publishing (Future)
* Payment Integration (Future)

---

## Technology Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* Spring Cloud Eureka Client
* Spring Cloud OpenFeign
* H2 Database (Current)
* MySQL (Future)
* Apache Kafka
* Spring Boot Actuator
* OpenAPI / Swagger

---

## Features

### Purchase Management

* Purchase Course
* View Purchased Courses
* Purchase History
* Duplicate Purchase Validation
* Purchase Verification

---

### Business Rules

* One purchase per course per user
* Prevent duplicate enrollments
* Validate course existence
* Validate user existence
* Maintain purchase records

---

## Architecture

```text
                Angular Frontend
                        │
                        ▼
                  API Gateway
                        │
                        ▼
                 Purchase Service
                        │
          ┌─────────────┼──────────────┐
          ▼             ▼              ▼
     User Service   Course Service   Database
          │             │
          └───────Purchase Validation───────┘
```

---

## REST APIs

### Purchase Management

| Method | Endpoint                          | Description           |
| ------ | --------------------------------- | --------------------- |
| POST   | `/api/purchases`                  | Purchase a Course     |
| GET    | `/api/purchases/user/{userId}`    | Get User Purchases    |
| GET    | `/api/purchases/history/{userId}` | Purchase History      |
| GET    | `/api/purchases/check`            | Check Purchase Status |

---

## Database

Current Database

* H2 Database

Future Migration

* MySQL

Future Improvements

* Flyway Migration
* Purchase Audit
* Payment Reference
* Transaction History

---

## Service Communication

The Purchase Service communicates with other microservices using Spring Cloud OpenFeign.

Current integrations include:

* User Service
* Course Service

Future integrations:

* Notification Service
* Payment Service
* Analytics Service

---

## Eureka Integration

The service automatically registers with Eureka Server.

Service Name:

```text
PURCHASE-SERVICE
```

No hardcoded service URLs are used.

---

## Monitoring

Spring Boot Actuator endpoints are enabled.

Available endpoints:

* `/actuator/health`
* `/actuator/info`
* `/actuator/prometheus`
* `/actuator/metrics`

---

## Future Enhancements

* Online Payments (Razorpay)
* Stripe Integration
* Coupon Management
* Discount Engine
* Refund Management
* Invoice Generation
* Purchase Analytics
* Redis Cache
* Kafka Event Publishing
* Certificate Generation
* Subscription Plans

---

## Future Event Flow

```text
Purchase Course
       │
       ▼
Purchase Service
       │
       ▼
Kafka Event
       │
       ├──────────────► Notification Service
       │                     │
       │                     ▼
       │              Purchase Confirmation Email
       │
       ├──────────────► Analytics Service
       │                     │
       │                     ▼
       │              Revenue Dashboard
       │
       └──────────────► Course Service
                             │
                             ▼
                    Enrollment Statistics
```

---

## Future Architecture

```text
                   API Gateway
                        │
                        ▼
                 Purchase Service
                        │
      ┌─────────────────┼──────────────────┐
      ▼                 ▼                  ▼
   MySQL            Redis Cache         Kafka
      │                                    │
      ▼                                    ▼
Purchase Records        Analytics & Notifications
------------------------------------------------------------------------
Purchase Service
        │
        ├── Purchase Management
        ├── Enrollment
        └── Ownership

Payment Service
        │
        ├── Razorpay
        ├── Stripe
        ├── Refunds
        └── Transactions
---------------------------------------------------------------------------
```

---

## Project Structure

```text
purchase-service
│
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
├── config
├── util
├── constant
├── resources
└── PurchaseServiceApplication.java
```

---

## Role in E-Learn Platform

The Purchase Service is responsible for managing course enrollments and purchase transactions across the E-Learn platform. It guarantees that users cannot purchase the same course multiple times, maintains complete purchase history, and acts as the authorization source for accessing premium learning content.

---

## Author

**Anil Mondi**
