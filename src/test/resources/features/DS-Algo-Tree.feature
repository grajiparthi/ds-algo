Feature: Test DS-Algo Tree data structure page

 
   Background: 
   Given The User has already logged in to the application
   |username|password|
   |winterchamps|Testwinter1!| 
   
   
   Scenario Outline: Testing Tree Page
   		Given The User is in the Tree Page
   		When The User clicks "<LinkName>" button
   		Then The User should be redirected to "<PageName>" page
   		And The User clicks "Try Here" button in "<PageName>" page
   		Then The User should land in a Try Editor page
   		And The User fills the tryEditor from given sheetname "<SheetName>" and rownumber <RowNumber>
   		And The User clicks on Run button under Tree Page
   		Then The output should be displayed below the Run button under the Tree Page
   	
   		
   		
   Examples: 
   | LinkName                      | PageName                    | SheetName     | RowNumber |
   | "Binary Trees"                | "Binary Trees"              | "Treedata"    | 0         |
   | "Types of Binary Trees"       | "Types of Binary Trees"     | "Treedata"    | 1         |
   | "Implementation in Python"    | "Implementation in Python"  | "Treedata"    | 2         |
   | "Binary Tree Traversals"      | "Binary Tree Traversals"    | "Treedata"    | 3         |