
 Feature: Test DS-Algo Graph data structure page

 
   Background: 
   Given The User has already logged in to the application
   |username|password|
   |winterchamps|Testwinter1!| 
   
   
   Scenario Outline: Testing Graph Page
   		Given The User is in the Graph Page
   		When The User clicks "<ButtonName>" button
   		Then The User should be redirected to "<PageName>" page
   		And The User clicks "Try Here" button in "<PageName>" page
   		Then The User should be redirected to an Editor page
   		And The User fills the tryEditor from given sheetname "<SheetName>" and rownumber <RowNumber>
   		And The User clicks on Run button under Graph Page
   		Then The output should be displayed below the Run button under the Graph Page
   	
   		
   		
   Examples: 
   | ButtonName                    | PageName                    | SheetName     | RowNumber |
   | "Graph"                       | "Graph"                     | "Graphdata"   | 0         |
   | "Graph Representations"       | "Graph Representations"     | "Graphdata"   | 1         |
        