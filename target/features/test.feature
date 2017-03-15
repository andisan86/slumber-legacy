Feature: testing

Scenario: Browser testing
  Given I open a browser
  When I go to this URL http://www.google.com
  Then I should see "Google Home Logo"