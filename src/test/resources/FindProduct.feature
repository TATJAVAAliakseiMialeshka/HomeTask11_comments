Feature: 4FRAG product search

  Background:
    Given I opened 4FRAG home page

   Scenario Outline: Searching product in 4FRAG
      When I search <item>
      And I add <item> to the wish list page
      Then <item> is on the wish list page


       Examples:
      | item |
      | Logitech Brio |
      | A4Tech Bloody A60 |
