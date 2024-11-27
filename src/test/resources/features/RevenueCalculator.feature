Feature: Revenue Calculator

  
  Scenario: Calculate Total Recurring Reimbursement for all Patients Per Month
   
    Given user navigates to the Fitpeo home page
    When user navigate to the 'Revenue Calculator' tab
    Then user adjust the eligible patients slider to <slidervalue>
    And the eligible patients text field value is updated to <slidervalue>
    Then user enters <patientsTextFieldValue> in the eligible patients text field
    And user should see the eligible patients slider value updated to <patientsTextFieldValue>
    Then user selects checkboxes based on the following CPT codes:
    | CPT-99091 |
    | CPT-99453 |
    | CPT-99454 |
    | CPT-99474 |
    Then user should see the 'Total Recurring Reimbursement for all Patients Per Month' value is <totalRecurringReimbursement> at body level
    And user should see the 'Total Recurring Reimbursement for all Patients Per Month' value is  <totalRecurringReimbursement> at header






    
    Examples:
    
    | slidervalue | patientsTextFieldValue |  totalRecurringReimbursement |
    | 820         | 560                    |   $75600                     |             
    
    