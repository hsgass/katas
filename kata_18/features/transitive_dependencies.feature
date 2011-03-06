Feature: Calculate transitive dependencies

    So that I can tell how overly coupled my code is
    As a programmer
    I want to see its transitive dependencies

    Scenario: View the most popular interests in the requestor's network
        Given I am logged in
        When I go to "popular interests"
        Then I should see the most popular interests of my friends

    Scenario: Add an interest
        Given I am logged in
        And I go to "popular interests"
        When I click "thumbs up" on "an interest"
        Then it should be added to my interests
        And it should be "selected"

    Scenario: Requestor has an existing interest in common with the most popular interests
        Given I am logged in
        And I have "an interest" that is common to the most popular interests of my friends
        When I go to "popular interests"
        Then "my interest" should be "selected"

    Scenario: Requestor has no existing interests in common with the most popular interests
        Given I am logged in
        And I do not have any existing interests that are common to the most popular interests of my friends
        And I go to "popular interests"
        Then no interests should be "selected"

