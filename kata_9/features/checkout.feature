Feature: Supermarket checkout

    As a cashier
    I want to get accurate pricing
    So my cash drawer balances

    Scenario Outline: checkouts
        Given the following prices are defined:
            | item | price | special_qty | special_price |
            | A    | 50    | 3           | 130           |
            | B    | 30    | 2           | 45            |
            | C    | 20    |             |               |
            | D    | 15    |             |               |

        When I scan "<items>"
        Then The total should be "<total>"

    Scenarios:
        | items       | total |
        | AA          | 100   |
        | AAA         | 130   |
        | AAB         | 130   |
        | AAAB        | 160   |
        | AAABB       | 175   |
        | ABCDABCDA   | 245   |
        | ABCDABCDAAB | 325   |
