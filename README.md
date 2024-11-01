# Gym Management System (Desktop)

A desktop application for managing a gym, built in Java. This system allows various types of users (Director, Manager, Receptionist) to perform their respective tasks. It includes features for user authentication, client management, and statistical data display.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Overview

The Gym Management System provides a comprehensive platform to manage gym operations, including client registration, session scheduling, and membership management. Each user type has specific roles and views tailored to their responsibilities.

## Features

- **User Authentication**: Login functionality for various user types (Director, Manager, Receptionist).
- **Client Management**: Register new clients, update client information, manage subscriptions.
- **Role-Specific Views**: Different interfaces for directors, managers, and receptionists.
- **Statistical Analysis**: Pie charts for visualizing client and session statistics.
- **Database Connection**: Data persistence using a MySQL database.

## Project Structure

```plaintext
GymManagementSystem_Desktop/
├── src/
│   ├── controller/            # Controllers for handling UI logic
│   │   ├── DirecteurController.java
│   │   ├── GerantController.java
│   │   ├── LoginController.java
│   │   └── ReceptionnisteController.java
│   ├── dao/                   # Data Access Objects for database interactions
│   │   ├── DatabaseConnection.java
│   │   ├── IClientRepository.java
│   │   ├── IRepository.java
│   │   ├── IUserRepository.java
│   │   ├── MySQLClientRepository.java
│   │   └── MySQLUserRepository.java
│   ├── exception/             # Custom exceptions for error handling
│   │   ├── ActivatedUserException.java
│   │   ├── CrudOperationException.java
│   │   ├── DesactivatedClientException.java
│   │   └── RepositoryException.java
│   ├── model/                 # Data models for application entities
│   │   ├── Abonnement.java
│   │   ├── Client.java
│   │   ├── ModelPieChart.java
│   │   ├── User.java
│   │   └── (other model files)
│   ├── runtime/
│   │   └── Main.java           # Main entry point of the application
│   └── view/                  # User interface views
│       ├── DirecteurView.java
│       ├── GerantView.java
│       ├── LoginView.java
│       └── ReceptionnisteView.java
├── bin/                       # Compiled binaries
├── target/                    # Target files for building
└── pom.xml                    # Project Object Model file for Maven
