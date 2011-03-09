Feature: Calculate transitive dependencies

    So that I can tell how overly coupled my code is
    As a programmer
    I want to see its transitive dependencies

    Scenario Outline: testing dependencies
        Given the following dependencies are defined:
        | set |
        | ABC |
        | BCE |
        | CG |
        | DAF |
        | EF |
        | FH |
        
        When I test the dependencies for "<dependency>"
        Then I should get "<results>"

        Scenarios:
        | dependency | results |
        | A | BCEFGH |
        | B | CEFGH |
        | C | G |
        | D | ABCEFGH |
        | E | FH |
        | F | H |
