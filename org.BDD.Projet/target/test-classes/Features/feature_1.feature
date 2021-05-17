Feature: WebTable in cricinfo
 	@Smoketest
  Scenario: WebTable in cricinfo
    Given Launch site using"chrome"
    When scroll into element
    Then getRow size
    And getcolumn size <r>
    And getCellValue
    Then Copy to exel
  
