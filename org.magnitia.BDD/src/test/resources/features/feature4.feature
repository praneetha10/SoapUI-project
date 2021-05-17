
Feature: Gmail Compose

  @realtest
  Scenario: Validate mail Compose
    Given launch site using "Chrome"
   	When enter userid as "magnitiait"
   	And click userid next button
   	And enter password as "magnitia05"
   	And click  password next button
   	And send mail and test by taking data from excel
   	When do logout
   	And quit site
 