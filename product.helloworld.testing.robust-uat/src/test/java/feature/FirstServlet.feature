Feature: TestFirstServlet
  In this feature, we test whether the FirstServlet of our hello world web based application works fine.

  Scenario: Test the first servlet feature
    Given empty browser is opened
    And navigate to the FirstServlet URL
    Then test whether Hi there content is there in the web page
    And close the first servlet web page
