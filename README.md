# Whitewine

Whitewine is a Scala application developped in an academic context at HES-SO, it is used for exploring and manipulating data. 

It was made by Emilie Teodoro and Benjamin Biollaz. 

# Structure
*In order to help you during the correction, you will find below where to look for the project requirements.* 

*The numerotation is the same as in the assignment.*

<h2>2. You can find classes modeling in the package "classes"</h2> 

  Here are the use of trait and inheritance :

![image](https://user-images.githubusercontent.com/100126834/209102287-bfb248ee-face-46bb-94cb-67b61fca9da4.png)

Case class / class composition (/classes/Wine.scala) : 

![image](https://user-images.githubusercontent.com/100126834/209102950-601b0092-1578-42f2-9da5-29f2baa61664.png)


<h2>3. Read the content of the dataset and load it into Scala collections (/dal/WineDB.scala line 94)</h2>

![image](https://user-images.githubusercontent.com/100126834/209101355-2eaf9015-177d-4809-a028-ee09875aac6a.png)

<h2>4. Data exploration (/dal/WineDB.scala) :</h2>
  
*All following methods use the method getCSVIterator (line 64) to returns an iterator of array of strings,
each entry being a csv line. This method use .map array method and .split string method.*


  <b>aggregate :</b>
  
  getTotalPriceWineryWines line 127 => use filter and foldLeft
  
  getAvgRatingCountry line 136 => use filter and foldLeft
  
  getNbWineByRegion line 150 => use filter
  
  
*Notice that when creating a Wine from csv fields the conversion is made with regards to the exception that could occur (e.g. converting a string into a int).
To do so it use the class /manipulation/SafeConversion.scala*

  
  <b>filter :</b>
  
  getWineByYear line 88 => use filter
  
  getAllWines line 97
  
 
 <b> query :</b> 
  
  getWineByName line 109 => use filter
  
<h2> 5. Data manipulation : </h2>

*The business logic is inside /manipulation/WineManager.scala and the display logic is inside /display/DataExploration.scala and /display/DataManipulation.scala*

Here are 5 operations/processing services from /manipulation/WineManager.scala : 

rateWine line 16 => use immutability and composability with .copy method from case class

getARandomDiscountedPrice line 39 => use immutability with .copy method from case class

addWine line 51 => use constructor from Wine class and composability 

modifyWinePrice line 59 use immutability with .copy method from case class

modifyWineName line 68 use immutability with .copy method from case class

<br></br>
On the display method you can find : 

<b>recursion</b> in /display/DataExploration in the getInformationFromCSV method line 40. 

<b>match case</b> in /display/DataExploration in the getInformationFromCSV method line 31.

<b>exception handling</b> in /manipulation/SafeConversion in the stringToInt method line 10.


# Usage 
You run the code and you choose what you want to do in the console :

![image](https://user-images.githubusercontent.com/100126834/209097759-8b68b8f9-5866-42f5-8db9-d2bc68d2b587.png)

There's a menu for data exploration : 

![image](https://user-images.githubusercontent.com/100126834/209097973-0147f92b-884f-45f2-9e05-cab5bb4f7513.png)

And another one for data manipulation : 

![image](https://user-images.githubusercontent.com/100126834/209098087-9ae60fb1-b3a1-4a81-8d12-b3531bec1854.png)

The rest of the app works the same way, you choose in the console what you want to do and what you want to display,
here's an example of data manipulation :

![image](https://user-images.githubusercontent.com/100126834/209099658-c459c34e-b2e1-4c60-b65a-7717076c4cae.png)

