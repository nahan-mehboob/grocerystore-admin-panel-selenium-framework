# GroceryStore Admin Panel — Selenium Automation Framework

## Overview

A self-initiated Selenium WebDriver + TestNG automation framework built to develop hands-on test automation skills alongside manual QA experience. This project automates functional and UI regression testing for a grocery store admin panel, applying Page Object Model design, data-driven testing, and multi-browser/parallel execution patterns.

## Application Under Test

**7rmart Supermarket — Admin Panel** ([groceryapp.uniqassosiates.com/admin/login](https://groceryapp.uniqassosiates.com/admin/login))

A web-based admin dashboard for managing a grocery delivery platform. Modules covered by this framework:

- Login
- Home
- Admin Users
- Manage Orders
- Manage Products
- Manage Location
- Manage Expense
- Manage Delivery Boy
- Mobile Slider
- Push Notifications
- Settings

## Tech Stack

- Java 8
- Selenium WebDriver 4.13.0
- TestNG 7.5.0
- Maven 3.x
- WebDriverManager 6.3.4 
- ExtentReports 5.0.9
- Apache POI 5.2.2
- JavaFaker | 1.0.2

Design pattern: **Page Object Model** with `PageFactory` for element initialization.

## Project Structure

```text
grocerystore-admin-panel-selenium-framework/

├── pom.xml
├── testng.xml                     (full suite)
├── testng-smoke.xml
├── testng-sanity.xml
├── testng-regression.xml
├── testng-crossbrowser.xml
├── testng-parallel.xml
├── testng-retry.xml
├── testng-include-exclude.xml
├── .gitignore
├── README.md
└── src
    ├── main
    │   └── java
    │       └── com/groceryadmin/automation
    │           ├── pages/          (Page Objects — one class per module)
    │           └── utils/          (Framework utilities: GeneralUtilities,
    │                                 Synchronisation, ExcelUtils,
    │                                 ScreenshotCapture, RandomDataGenerationUtility)
    └── test
        ├── java
        │   └── com/groceryadmin/automation
        │       ├── base/           (BaseTest — driver setup/teardown)
        │       ├── constants/      (Constants — expected values)
        │       ├── listeners/      (AnnotationTransformer, RetryAnalyzer,
        │       │                     ExtentReportManager)
        │       └── tests/          (Test classes — one per module)
        └── resources
            ├── Config.properties
            └── testdata/           (Excel test data + upload image)
```

## Running the Tests

**Full suite (default):**

```bash
mvn clean test
```

Runs `testng.xml`, which covers all modules using the browser/headless values set in that file's `<parameter>` tags.

**A specific purpose-scoped suite:**

```bash
mvn clean test -Dsurefire.suiteXmlFiles=testng-smoke.xml
```

Swap in `testng-sanity.xml`, `testng-regression.xml`, `testng-negative.xml`, `testng-crossbrowser.xml`, `testng-parallel.xml`, `testng-retry.xml`, or `testng-include-exclude.xml` as needed.

**Headless override:**

```bash
mvn clean test -Dheadless=true
```
Overrides the `Headless` value in whichever suite is running, regardless of what its XML sets. Applies globally to the run.

## What Each Suite Demonstrates

| Suite | Purpose |
|---|---|
| `testng.xml` | Full regression run across all 11 test classes |
| `testng-smoke.xml` | Fast, shallow pass — page loads, titles, key element visibility |
| `testng-sanity.xml` | Core functional checks per module |
| `testng-regression.xml` | Full regression scope, including data-driven and edge cases |
| `testng-crossbrowser.xml` | Same test logic executed across Chrome, Firefox, and Edge |
| `testng-parallel.xml` | Parallel method execution (`thread-count="2"`) |
| `testng-retry.xml` | Automatic retry of failed tests via `IAnnotationTransformer` |
| `testng-include-exclude.xml` | Selective method inclusion within a single test class |

## Test Reports

Each test run generates a timestamped HTML report via ExtentReports, with screenshots automatically embedded on any test failure. After running any suite, open the most recent file in:

```text
ExtentReport/ExtentReport_<ddMMyyyy_hhmmss>.html
```

Each run creates a new, separately timestamped file rather than overwriting the previous one — a full run history is preserved in this folder across multiple executions.

## Framework Design

- **Page Object Model + PageFactory.** Locators live in the page classes, not scattered across 11 test classes — one place to update when the UI changes.
- **Centralized `Constants` class** for expected text/colors/URLs/alerts instead of string literals repeated everywhere.
- **WebDriverManager** instead of checked-in driver `.exe` files. One less thing to break when someone clones this on a different machine.
- **ExtentReports + screenshot-on-failure**, wired through the TestNG listener so it's automatic — no per-test reporting code.
- **Separate suite XMLs instead of one monolith.** Smoke/sanity/regression map to how manual QA usually buckets test coverage; cross-browser, parallel, and retry each get their own suite so each mechanism can be run and reviewed on its own.
- **Headless is overridable via `-Dheadless`, browser is not.** Surefire runs everything in one JVM per suite, so a system property applies suite-wide. That's fine for headless since no suite mixes headless/non-headless in one run — but `testng-crossbrowser.xml` deliberately runs Chrome/Firefox/Edge in the same run, so a global browser override would collapse all three into one. Left that one hardcoded on purpose.