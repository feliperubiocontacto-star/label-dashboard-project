# MVP Architecture

## Overview
The project is split into:
- `backend/`: Java 21 + Spring Boot API using clean architecture folder boundaries.
- `frontend/`: React + Vite dashboard UI.
- `docker/`: Containerization for backend, frontend, and PostgreSQL.
- `docs/`: Supporting architecture and operational notes.

## Backend Clean Architecture Boundaries
- `domain/`: Core entities and business rules (framework-independent).
- `application/`: Use cases and orchestration.
- `infrastructure/`: Persistence, integrations (e.g., Graph API adapters).
- `interfaces/rest/`: REST controllers and DTO mapping.

## Data Model
The MVP creates three tables:
- `tickets`
- `attachments`
- `status_history`

Defined in Flyway migration: `backend/src/main/resources/db/migration/V1__create_ticketing_schema.sql`.
