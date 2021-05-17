
Feature: Gmail login
	@realtest
  Scenario Outline: Validate password in login page
    Given launch site using"<bn>"
    When enter userid as "magnitiaait"
    And click userid next button
    And enter password as<pwd>
    Then validate outcome related to given password criteria like"<pwd criteria>"
    When close site
      Examples: 
      | pwd  | pwdcritetia |bn|
      |magnitia@05 |     valid | chorme |
      |magnitia@05|     valid | firefox |
			|magnitia@05|     valid | opera|
			|magnitia@05|     valid |edge|
			|magnitia257 |    invalid | chorme |
      |magnitia257|     invalid | firefox |
			|magnitia585|     invalid | opera|
			|magniti65|    invalid |edge|
			||blank|chrome|
			||blank|firefox|
			||blank|opera|
			||blank|edge|