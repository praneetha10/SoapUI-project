
Feature: Gmail login
  I want to use this template for my feature file
 Background:
					Given launch site using "chrome"

  @smoketest
  Scenario: Validate Gmail homepage title
    Then title should be "Gmail"
    When close site

  @smoketest
  Scenario Outline: Validate userid in homepage
    When enter userid as <uid> 
    And click userid next button
    Then Validate outcome related to given useridcrteria like <uidcriteria>
    When close site

    Examples: 
      | uid          | uidcriteria |
      | magnitiait   |    valid| 
      | magnitianonit|   invalid| 
      |              |blank|
