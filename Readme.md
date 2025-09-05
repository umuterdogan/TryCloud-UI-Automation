# TryCloud-UI-Automation (Selenium · Cucumber · JUnit · Maven · Jenkins)

This repository presents a UI Test Automation project with cross-browser coverage, parallel execution, rich reporting, and CI/CD integration. It is built to highlight real-world SDET practices and serve as a portfolio example.

## This repo demonstrates:
- Cross‑browser validation (Chrome, Firefox, Edge, Safari, headless modes)
- Feature/class‑level parallel execution for faster feedback
- Deterministic, tag-driven suites for @smoke pipelines and @wip tests
- Portable reporting (Cucumber HTML, JSON, Timeline) suitable for sharing in CI
- A clean Page Object Model with driver lifecycle isolation and robust hooks
- CI/CD with Jenkins (parameterized, matrix‑ready jobs, HTML Publisher)

## Tech stack
- Java 11, Maven
- Selenium 4, Cucumber JVM 7, JUnit 4
- IntelliJ IDEA
- Jenkins (Freestyle/Matrix), HTML Publisher
- Reporting: Cucumber HTML/JSON + Timeline
- Design: Page Object Model, utilities for driver/config/hooks

## Repository structure (high‑level)
- `src/test/resources/features/` — Gherkin feature files (business‑readable specs)
- `src/test/java/net/trycloud/pages/` — Page Object Model (UI mapping, behaviors)
- `src/test/java/net/trycloud/step_defintions/` — Step definitions (glue)
- `src/test/java/net/trycloud/runners/` — Cucumber runners (`CukesRunner`, `FailedTestRunner`)
- `src/test/java/net/trycloud/utilities/` — `Driver`, `ConfigurationReader`, `BrowserUtils`
- `pom.xml` — Dependency and build lifecycle config (Surefire parallelism, reporting)

## Key capabilities
- Cross-browser execution via `-Dbrowser` (chrome, firefox, edge, safari, headless-chrome, headless-firefox)
- Parallel execution using Maven Surefire (feature/class granularity with JUnit)
- Tag-driven test selection (`@smoke`, `@wip`)
- Robust reporting:
    - Cucumber Pretty HTML: `target/cucumber/cucumber-html-reports/overview-features.html`
    - Cucumber JSON: `target/cucumber-reports/cucumber.json`
    - Timeline: `target/timeline/index.html`
    - **Extent Reports (HTML/PDF):** customizable rich reports configured via `extent.properties` and `extent-pdf-config.yaml`
        - HTML: `target/extent-reports/extent-report.html`
        - PDF: `target/extent-reports/extent-report.pdf`
- Reruns: failing scenarios collected into `target/rerun.txt` for selective retry

## Design choices
- Page Object Model keeps locators and UI actions close to the page they represent.
- `Driver` uses Selenium Manager (Selenium 4.6+) so no manual driver binaries required.
- `InheritableThreadLocal<WebDriver>` provides thread‑safe driver instances under parallel runs.
- `ConfigurationReader` centralizes environment and browser configuration.
- Hooks (`@Before`/`@After`) ensure driver/session isolation and clean teardown.

## Running locally
- Run tests with Maven:
    - `mvn clean test -Dbrowser=chrome -Dcucumber.filter.tags=@smoke`
- Reports generated:
    - HTML: `target/cucumber/cucumber-html-reports/overview-features.html`
    - Timeline: `target/timeline/index.html`
    - Extent Reports (HTML/PDF): `target/extent-reports/`

## Running with Maven (locally or CI)
- Smoke suite: `mvn clean test -Dtest=CukesRunner -Dbrowser=headless-chrome -Dcucumber.filter.tags=@smoke`
- Full suite: `mvn clean test -Dtest=CukesRunner`
- Parallel execution enabled via Surefire (feature/class level with JUnit).

## CI/CD (Jenkins)
- Integrated with Jenkins for automated builds and test execution.
- Supports parameterized jobs for browser selection (`BROWSER`) and tag filtering (`TAGS`).
- Generates and publishes Cucumber HTML, Timeline, and JUnit XML reports as Jenkins artifacts.
- Matrix jobs can be configured to run tests across multiple browsers in parallel.

## Test strategy & tagging
- Business-readable scenarios live under `features/` (focused, small, deterministic).
- Tag policy:
    - `@smoke` — login, navigation, and other top-critical journeys
    - `@wip` — work-in-progress scenarios; excluded by default in CI
- Flaky tests: unstable scenarios are isolated from `@smoke` until stabilized.

## Configuration and secrets
- `config.properties` contains non-sensitive defaults (e.g., `browser`, base URL).
- Credentials are **not** committed; they are passed via CI parameters/secrets instead.
- **For security reasons**, credentials in this portfolio project have been modified and do not represent real accounts.
- Portfolio note: when sharing public reports, sanitize screenshots and messages to avoid exposing private data.

## Screenshots (examples)
- Cucumber Report (overview)
- Timeline (parallel run visualization)
- Jenkins job result (pass/fail summary)

## How to read the code
- Start from runner `net.trycloud.runners.CukesRunner`
- Open `net.trycloud.utilities.Driver` for driver lifecycle and browser selection
- Explore pages in `net.trycloud.pages.*`
- Tie behavior to steps in `net.trycloud.step_defintions.*`
- See `pom.xml` for parallelism/reporting configuration

---

This repo is designed to reflect real-world SDET practices: readable specifications, maintainable structure, fast feedback cycles, and shareable reporting.

