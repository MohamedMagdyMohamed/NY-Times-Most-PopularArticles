# NY-Times-Most-PopularArticles
Simple app that hit the NY Times Most Popular Articles API and show a list of articles, that shows details when items on the list are tapped (a typical master/detail app).

## Installation
Clone this repository and import into **Android Studio**
```bash
git clone https://github.com/MohamedMagdyMohamed/NY-Times-Most-PopularArticles.git
```

## Import and Running the App
1. [Import project](https://developer.android.com/studio/intro/migrate.html#import_as_a_project) in Android Studio
2. [Debug and run app](https://developer.android.com/studio/run)

**NOTE** for each command you will run on Terminal you have to be in the project directory 
```bash
$ cd Path/To/NY-Times-Most-PopularArticles
```

## Run Static Code Analysis
### lint
```bash
$ ./gradlew clean lint
```
The result will be generated on path "app/build/reports/lint-results.html"

### Detekt
```bash
$ ./gradlew clean ktlintCheck
```
The result will be generated on path "app/build/reports/ktlint/\*/\*.html"

\* {ktlintAndroidTestSourceSetCheck, ktlintMainSourceSetCheck, ktlintTestSourceSetCheck}

### Detekt
```bash
$ ./gradlew clean detekt
```
The result will be generated on path "app/build/reports/detekt/detekt.html"


## Run Unit Tests
```bash
$ ./gradlew clean test
```

## Run Android Tests
```bash
$ ./gradlew clean connectedAndroidTest
```
**Note:** To run androidTest you have to be connected to a real device or emulator

## Run Code Coverage Reports
```bash
$ ./gradlew clean jacocoTestReport
```
**Note:** You have to be connected to a real device or emulator to run androidTest
The result will be generated on path "app/build/reports/jacoco/jacocoTestReport/html/index.html"

## Run SonarQube
### Setup
1. Download sonarqube from [here](https://www.sonarqube.org/downloads/)
1. The downloaded version will come in Zip, just unzip it
1. Goto /sonarcube/bin/\<platform-folder\>
    1. For Windows -> it StartSonar.bat to start running SonarQube on server
    1. For Linux/MacOs -> in the terminal run
    ```bash
    $ ./sonar.sh start
    ```
1. Now open [http://localhost:9000](http://localhost:9000) to see admin panel of SonarQube
1. Login to user panel using “admin” for username and password

**Note:** if the server require you to change the password change it and used it below
### Run
```bash
$ ./gradlew sonarqube -Dsonar.login=admin -Dsonar.password=admin
```
Now go to [SonarQube server](http://localhost:9000/dashboard?id=com.example.nytimesmostpopulararticles)
## To Run Test with Jacoco reports and SonarQube
```bash
$ ./gradlew clean connectedAndroidTest test createDebugCoverageReport jacocoTestReport sonarqube -Dsonar.login=admin -Dsonar.password=admin
```
Now go to [SonarQube server](http://localhost:9000/dashboard?id=com.example.nytimesmostpopulararticles)
