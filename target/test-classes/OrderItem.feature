@tag
Feature: order an item in a ecomers site
Background:
Given Go to ecommers site
@tag2
Scenario Outline:
Given login using "<username>" and "<password>"
When  add product "<ProductName>" to card	
And checkout "<ProductName>" and submit order
 

Examples:
|username		  |password |ProductName|
|goutham@gmail.com|Goutham@6|ZARA COAT 3|

