
Feature: Gmail Compose
  @smokeTest
  Scenario: Validate mail compose
    Given launch site using "chrome"
    
    When enter userid as "magnitiaait"
    And click userid next button
    And enter password as "magnitia45"
    And click password next button
    And send mail and test
    |to                |subject|body|attachment|
    |apj@abdulkalam.com|wishes|hi sir|E:\pictures\ladies_maha_shiva.jpg|
    |praneetha.mullapudi@gmail.com|wishes|hi sir|E:\pictures\ladies_maha_shiva.jpg|
   When do logout
   And quit site