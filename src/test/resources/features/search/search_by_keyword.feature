Feature: Search by keyword

  Scenario Outline: A person is searching for a term
    Given is researching things on the internet
    When looks up <keywords>
    Then should see information about
    Examples:
    |keywords|
    |Hello Build|
    |QA Engineer |

