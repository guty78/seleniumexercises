# Selenium Google Search Automation

This project demonstrates the use of Selenium WebDriver for automating a simple search task using JUnit. The test navigates to Google, performs a search, and verifies the results by clicking a Wikipedia link and checking for a specific year in the content. The test also takes a screenshot of the result page.

## Project Structure

- `src/test/java/com/SeleniumExercises/test/GoogleSearchAutomationWikipediaTest.java`  
  Contains the main test code that performs the automation tasks.

- `src/test/resources/chromedriver/chromedriver.exe`  
  The ChromeDriver executable used for controlling the Chrome browser.

## Prerequisites

1. **Java Development Kit (JDK):** Ensure that Java is installed on your machine. You can download it from [Oracle's JDK page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use [OpenJDK](https://openjdk.java.net/).

2. **Maven:** This project uses Maven for dependency management. Install Maven from [Apache Maven's website](https://maven.apache.org/download.cgi).

3. **ChromeDriver:** Download the appropriate version of ChromeDriver from [ChromeDriver download page](https://sites.google.com/chromium.org/driver/downloads) and place it in the `src/test/resources/chromedriver/` directory.

## Setup

1. **Clone the Repository:**

```bash
git clone https://github.com/guty78/seleniumexercises.git
cd seleniumexercises
```

2. **Build the Project:** Use Maven to build the project and download dependencies:

```bash
mvn clean install
```

## Running the test

To run the test, execute the following Maven command:

```bash
mvn test
```

This command compiles the test code and executes it using JUnit. Ensure that ChromeDriver is correctly placed in **`src/test/resources/chromedriver/`** before running the tests.

## Test Details

##### Test Class: **`GoogleSearchAutomationWikipediaTest`**

**Setup Method:** @setUp()

- **Purpose:** Initializes the WebDriver and WebDriverWait objects.
- **Details:**
    - Sets the path to the **`chromedriver.exe`** executable.
    - Creates a new instance of **`ChromeDriver`** for controlling the Chrome browser.
    - Initializes **`WebDriverWait`** with a timeout of 10 seconds.
	
**Test Method:** @testGooglePage()

- **Purpose:** Automates the process of searching on Google and verifying the results.
- **Details:**
    - Maximizes the browser window.
    - Navigates to the [Google homepage](https://www.google.com/).
    - Clicks the "Reject all" button on the cookies popup (handles consent).
    - Waits until the search box is clickable, then enters the search term "automation" and submits the search.
    - Waits for search results to be visible.
    - Finds and clicks the Wikipedia link in the search results.
    - Waits until the Wikipedia logo is visible to confirm successful navigation.
    - Verifies that the Wikipedia page contains the year "1745".
    - Takes a screenshot of the Wikipedia page and saves it as **`wikipedia_screenshot.png`**.

**Teardown Method:** @tearDown()

- **Purpose:** Cleans up resources after the test has been executed.
- **Details:**
    - Closes the browser and quits the WebDriver session.

## Troubleshooting

- **WebDriver Error:** If you encounter issues with WebDriver, ensure that chromedriver.exe is compatible with your installed version of Google Chrome. Make sure that the path to the chromedriver.exe is correctly set in the test code.
- **Dependencies Issue:** Make sure all Maven dependencies are correctly resolved by running mvn clean install before executing the tests. If Maven fails to download dependencies, check your internet connection and Maven configuration.
- **Browser Compatibility:** Ensure that the version of ChromeDriver matches the version of Google Chrome installed on your machine. Update ChromeDriver or Chrome as needed.
- **Screenshot Issues:** If the screenshot is not being saved, ensure that the directory where the screenshot is being saved has appropriate write permissions. Also, verify that there are no typos in the file path or file name.