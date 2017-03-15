# slumber
Tool to automate Web actions using Cucumber/Gherkin features

Slumber (Selenium + Cucumber) is a tool that attempts to automate Web actions using Cucumber/Gherkin steps. For example, given this feature:

```gherkin
Feature: testing

Scenario: Browser testing
  Given I open a browser
  When I go to this URL http://www.google.com
  Then I should see "Google Home Logo"
```
And following parameters:
- Browser = Firefox
- Browser driver location = drivers/chromedriver
- Glue location = <leave blank by default>
- Feature location = features/

Then one can run Slumber by creating a JAR and passing below command:
```java
java -jar -Dbrowser=FIREFOX -DdriverLocation=drivers/geckodriver -DcucumberGlueLocation= -DcucumberFeatureLocation=features slumber-1.0.jar
```
Give it a try!
