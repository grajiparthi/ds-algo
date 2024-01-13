
  Feature: Test DS-Algo Array data structure page

  Background: 
   Given The User has already logged in to the application
   |username|password|
   |winterchamps|Testwinter1!| 
   
   
   Scenario Outline: Testing Arrays in Python Page in Arrays 
   		Given The User is in the Array Page
   		When The User clicks "<ButtonName>" button
   		Then The User should be redirected to "<PageName>" page
   		And The User clicks "Try Here" button in "<PageName>" page
   		Then The User should be redirected to a page having a tryEditor with a Run button to test
   		And The User fills the tryEditor from given sheetname "<SheetName>" and rownumber <RowNumber>
   		And The User clicks on Run button
   		Then The output should be displayed below the Run button
   		And If there is an error in the program
   		Then The error message should be captured
   		
   Examples: 
   | ButtonName                    | PageName                    | SheetName | RowNumber |
   | "Arrays in Python"            | "Arrays in Python"          | "Sheet1"   | 0         |
   | "Arrays Using List"           | "Arrays Using List"         | "Sheet1"   | 1         |
   | "Basic Operations in Lists"   | "Basic Operations in Lists" | "Sheet1"   | 2         |
   | "Applications of Array"       | "Applications of Array"     | "Sheet1"   | 3         |		


	 Scenario Outline: Testing Practice Questions in Array
			 Given The User is in the Arrrays in Page under Arrays 
			 When The User clicks on "Practice Questions" link 
			 Then The User should be redirected to practice page
			 And The User clicks on "<LinkName>" link 
			 Then The User should be redirected to a page having a textarea with a Submit button to test
			 And The User fills the tryEditor from the given "<SheetName>" and rownumber <RowNumber> 
			 And The User clicks on Submit button
			 And  If there is an error in the program
			 Then The error message should be captured
			 
			 
	 Examples: 		 
   | LinkName                                 | SheetName | 	RowNumber |
   | "Search the array"                       | "Sheet1"  | 4           |
   | "Max Consecutive Ones"                   | "Sheet1"  | 5           |
   | "Find Numbers with Even Number of Digits"| "Sheet1"  | 6           |
   | "Squares of a Sorted Array"              | "Sheet1"  | 7           |
 		