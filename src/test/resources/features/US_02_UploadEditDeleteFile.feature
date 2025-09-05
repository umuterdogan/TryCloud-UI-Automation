Feature: Upload Edit Delete File Functionality

  Background:
    Given the user is logged in
    And the user navigate to "files"

  Scenario Outline: User can upload a file
    When the user upload <file>
    Then the user should see total number of files and folders
    Then the user should see <file> on page
    And the user delete any selected <file>
    Then the user should see <file> in deleted files

    Examples:
    |file|
    |"testTXTFile.txt"|
  #upload and delete should be handled together so that we can re-run these tests wıthout changing files


  Scenario Outline: User can create a new folder
    When the user create new folder <folder>
 #   Then the user should see total number of files and folders
    Then the user should see <folder> on page

    Examples:
    |folder|
    |"TestFolder3"|
    |"TestFolder4"|

  Scenario Outline: User can move any item to any folder
    When the user create new folder <folder>
    And the user upload <item>
    And the user move the <item> to <folder>
    Then the user should see moved <item> in <folder>
    And the user navigate to "files"
    And the user delete any selected <item>
    And the user delete any selected <folder>

    Examples:
    |item | folder |
    |"moveFileTest.txt"|"TestFolderForMoveAction"|

  # we create a new file and folder, then move file to that folder to verify,
  # then to be able re-run this test again we need to delete test file and folder

  Scenario Outline: User can copy any item to any folder
    When the user create new folder <folder>
    And the user upload <item>
    When the user copy the <item> to <folder>
    Then the user should see copied <item> in <folder> and FileList
    And the user navigate to "files"
    And the user delete any selected <item>
    And the user delete any selected <folder>


    Examples:
      |item | folder |
      |"CopyFileTest.txt"|"FolderToCopyTest"|
  # we create a new file and folder, then copy file to that folder to verify,
  # then to be able re-run this test again we need to delete test file and folder

  Scenario: User can see the total number of files and folders under the files list table
    Then the user should see total number of files and folders

  # we are also verifying this step in other scenarios

