# Project: Label Modification Dashboard

## Goal
Create a web application that automatically generates task tickets from Outlook emails with subject:
"Modificar Etiqueta"

## Main Flow
1. Email arrives with subject "Modificar Etiqueta"
2. System creates a ticket
3. Ticket appears in dashboard (orange = pending)
4. Operator uploads image and completes task
5. Ticket turns green
6. System sends confirmation email with image attached

## UI
- Dashboard with cards
- Orange = pending
- Green = completed

## Tech Stack
- Backend: Java + Spring Boot
- Frontend: React
- Database: PostgreSQL
- Email: Microsoft Graph

## Requirements
- No hardcoded values
- Use environment variables
- Must run locally
- Must be migratable to VM
