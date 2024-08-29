# Rewards Points

## Overview

The **Rewards Service** is a Spring Boot application designed to calculate and manage reward points for customers based on their transactions. This application provides APIs to:

- Retrieve reward points for a specific customer.
- Calculate reward points for all customers within a specific date range.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Building and Running](#building-and-running)
- [API Endpoints](#api-endpoints)
- [Example Usage](#example-usage)
- [Contributing](#contributing)
- [License](#license)

## Technologies Used

- Java 11+
- Spring Boot 2.7.x
- Spring Data JPA
- H2 Database (for development and testing)
- Maven

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher.
- Maven (version 3.6+ recommended).
- An IDE (e.g., IntelliJ IDEA, Eclipse) or text editor of your choice.
- Git for version control.

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/rohithmmm/assessment.git
   cd rewards-service

## API Endpoints

1. **Get Reward Points for a Customer**
Endpoint: GET /rewards/{customerId}
Description: Retrieves the reward points for a specific customer.
Parameters:
customerId: The ID of the customer.
2. **Get Reward Points for All Customers Within a Date Range**
Endpoint: GET /transactions/rewards/all
Description: Calculates and retrieves the total reward points for all customers within a specified date range.
Parameters:
startDate: Start date for the calculation (format: YYYY-MM-DD).
endDate: End date for the calculation (format: YYYY-MM-DD).
3. **Get Reward Points for a Customer Within a Date Range**
Endpoint: GET /monthly/{customerId}/{startDate}/{endDate}
Description: Calculates and retrieves the total reward points for a specific customer within a specified date range.
4. **Get total Reward Points for a Customer**
Endpoint: GET /total/{customerId}
Description: Calculates and retrieves the total reward points for a specific customer
