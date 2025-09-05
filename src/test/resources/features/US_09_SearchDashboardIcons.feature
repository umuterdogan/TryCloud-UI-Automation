Feature: Search Functionalities Dashboard Icons

  Background:
      Given the user is logged in

    Scenario:User can search file typing its name through the magnifying glass icon and
             see the details side page of the file when clicked on it.

      When User can click the magnifying glass icon
      And  User can write "testAvatar" into the text box
      And  User can click on the file name
      Then User can see the details side page of the "testAvatar"


  Scenario:User can search contacts by clicking on the contacts icon and typing its name

    When User can click contacts icon
    And  User can write "Mike" into the contact text box
    Then User can see the contact name related to keyword "Mike"


  Scenario:User can see only the images files with the extension of .jpeg/.jpg under the Photos module
           when uploaded them

    When the user click "Photos" module
    And  User should be on the "/index.php/apps/photos/"
    Then User can see only the images files with the extension of "jpeg" or "jpg"


  Scenario:User can navigate to files page as home page whenever clicking the seamlessly icon on Dashboard

    When the user click "Photos" module
    And User can click seamlessly icon on dashboard
    Then User should be on the files page as home page "/index.php/apps/files/?dir=/&fileid"



