# GroceryStore Admin Panel — Selenium Automation Framework

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

## How to Run

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

## Design Decisions

- **Page Object Model with PageFactory** — separates element locators from test logic, so a UI change means editing one page class rather than hunting through every test that touches that element.
- **Centralized `Constants` class** — every expected value (text, color, URL, alert message) lives in one place instead of being duplicated as string literals across 11+ test classes, so an expected-value change is a one-line edit, not a find-and-replace across the codebase.
- **WebDriverManager over manually managed driver binaries** — resolves the correct driver automatically per machine/OS, removing the need to check `.exe` files into source control or hardcode driver paths.
- **ExtentReports with screenshots embedded on failure** — the reporting listener hooks into TestNG's lifecycle so a screenshot is captured and attached to the failing test entry automatically, with no per-test-class reporting code required.
- **Multiple purpose-built suite XMLs rather than one** — smoke/sanity/regression suites mirror the same test-classification approach used in manual QA test planning, while the mechanism-focused suites (cross-browser, parallel, retry, include/exclude) each isolate one TestNG capability for review independent of the others.
- **Headless is command-line overridable, browser is not — a deliberate asymmetry, not an oversight** — Surefire forks one JVM per run, so a bridged system property applies globally across every <test> block in that run. testng-crossbrowser.xml intentionally uses different Browser values across its three blocks in a single run, so a global -Dbrowser override would silently collapse all three to one browser — ruled out. No suite here varies Headless within a single run, so -Dheadless has no such conflict and is safely overridable.

## About This Project

Built independently while working as a QA Analyst (1.5 years, manual and functional testing) to develop automation skills beyond manual testing — applying real QA judgment (smoke/sanity/regression/negative test classification, edge-case thinking) to an automated framework rather than treating automation as a separate skill from manual QA process.
