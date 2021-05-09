Feature: Testing petStore
@register
  Scenario: User does some actions on the API
    Given All the available pets
    When Add a new pet named "Sasha"
      And Change the pet status to "sold"
    Then Delete the pet
