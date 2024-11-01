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
 ```
## Installation

1. Clone this repository:
   ```bash
   git clone git@github.com:sats0264/Projet_JAVA_FINAL.git
   ```
   ```bash
   git clone https://github.com/sats0264/Projet_JAVA_FINAL.git
   ```
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).

3. Make sure you have a MySQL database set up and update DatabaseConnection.java with the appropriate database credentials.

4. Build the project using Maven:
   ```bash
   mvn clean install
   ```
## Usage
- Run `Main.java` to start the application.
- Login using the credentials assigned to your user type (Director, Manager, Receptionist).
- Use the appropriate views to manage clients, view statistics, and perform gym management tasks.

## Technologies Used
- **Java**: Core language for development.
- **MySQL**: Database for data storage.
- **JavaFX/Swing**: For building the desktop application's UI.
- **Maven**: Build and dependency management.
- **JDBC**: For database connectivity.

## Contributing
Contributions are welcome! To contribute:

1. **Fork the repository** by clicking on the “Fork” button at the top right corner of this page.
2. **Clone the forked** repository to your local machine:
bash
```bash
git clone https://github.com/yourusername/GymManagementSystem_Desktop.git
```
3. **Create a new branch** for your feature or bug fix:
```bash
git checkout -b feature/NewFeature
```
4. **Make your changes** and commit them with descriptive messages:
```bash
git commit -m "Add new feature or fix"
```
5. **Push the changes** to your forked repository:
```bash
git push origin feature/NewFeature
```
6. **Submit a pull request** on the original repository.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

```vbnet
This version focuses on key details like features, installation, usage, and contribution guidelines, keeping the `README.md` clear and concise.
```
