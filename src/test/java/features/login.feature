Feature: Login Functionality
  Scenario Outline: Login Successful
    Given I am in login of ParaBank application
    When I entre a valid <username> and <password> with <userFullName>
    Then I should be taken in Overview page

    Examples:
    |username|password|userFullName|
    |"tautester"|"password"|"Rookie Ether"|
    |"autotester"|"password"|"Auto Tester"|