[![Build Status](https://travis-ci.com/digid0c/decathlon-app.svg?branch=master)](https://travis-ci.com/github/digid0c/decathlon-app)
[![codecov](https://codecov.io/gh/digid0c/decathlon-app/branch/master/graph/badge.svg)](https://codecov.io/gh/digid0c/decathlon-app)

# Decathlon demo application

* [Requirements](#requirements)
* [Build](#build)
* [Usage](#usage)

# Requirements
* Java 11 or higher
* Maven 3.6 or higher (optional, there is a Maven wrapper provided along with the app)
* Docker (optional, you can run the app using Maven)

# Build

* [Maven](#maven)
* [Docker](#docker)
* [Maven wrapper](#maven-wrapper)

## Maven
Use the following commands to build and run the app via Maven Spring Boot plugin:
* `mvn clean package`
* `mvn spring-boot:run`

## Docker
Alternatively, you can run the app via Docker by using following commands:
* `mvn clean package`
* `docker build -t <imagename> .`
* `docker run -p 8080:8080 <imagename>`

You are free to use any additional flags, image name and/or change port mappings.

## Maven wrapper
In case you do not have Maven installed, you can use Maven wrapper provided along with the app.
In order to do that, just replace all `mvn` commands with `mvnw`.

# Usage

When app is up, go to http://localhost:8080/swagger-ui.html and start exploring the API.