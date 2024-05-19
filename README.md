# Spring Boot OpenNLP Demo

This is a Spring Boot application that demonstrates the usage of Apache OpenNLP for natural language processing (NLP) tasks such as language detection, sentence detection, and tokenization. The service processes HTML text, converts it to plain text, detects the language, tokenizes the text, and maps tokens to their types and IDs using database data.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Configuration](#configuration)
- [Contributing](#contributing)


## Features

- Convert HTML text to plain text
- Detect the language of the text
- Detect sentences in the text
- Tokenize the text into individual tokens
- Map tokens to their types and IDs using data from a database

## Getting Started

### Prerequisites

To build and run this project, you will need:

- Java 11 or higher
- Maven
- A database (configured in `application.properties`)
- Configure your database connection in src/main/resources/application.yml:
    ```
    database:
      url: your_database_url
      user: your_database_username
      password: your_database_password
    ```
### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Oussemasahbeni/spring-boot-openNLP.git
   cd spring-boot-opennlp-demo
   ```
2. Build the project using Maven:
 ```bash
   mvn clean install
   ```

### Configuration
Ensure you have the necessary model files for OpenNLP:

- langdetect-183.bin
- Sentence and tokenizer model files for the languages you want to support: 
  - opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin
  -  opennlp-en-ud-ewt-tokens-1.0-1.9.3.bin.

### Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.
