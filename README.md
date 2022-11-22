# Cover Google Translate app

> Automation tests for Google Translate app on physical or virtual devices.

## Table of Contents

* [General Info](#general-info)
* [Build Specification](#build-specification)
* [Setup](#setup)

## General Info

Project was created in order to test Google Translate application.

## Build Specification

- [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven](https://maven.apache.org/docs/3.6.3/release-notes.html)
- [IntellijIdea](https://www.jetbrains.com/idea/download/#section=windows) Community edition
- [Selenium 4](https://www.selenium.dev/downloads/)
- [TestNG](https://testng.org/doc/download.html)
- [AllureReports](https://docs.qameta.io/allure-report/)
- [Appium](https://github.com/appium/appium-desktop/releases/latest)

## Links

> Link to [_bitbucket_](https://bitbucket.org/pot-training/testing-framework/src/mobileAusra/).

## Setup

Preconditions:

- Google Translate app installed
- Internet connection available
- Appium server launched

To run tests in Maven:

- Run test on virtual device: <code>mvn clean test -Dvirtual="true"</code>
- Run test on physical device: <code>mvn clean test -Dvirtual="false"</code>
- Open allure report: <code>mvn allure:serve</code>