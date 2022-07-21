Absolute Java  Chapter5 Programming Projects. 
### Sample dialogue
``` console 
``` 

Disp0502	RoundStuff.java
``` console 
Enter radius:
2
A circle of radius 2.0 inches
has an area of 12.56636 square inches.
A sphere of radius2.0 inches
has an volume of 33.51029333333333 cubic inches.
``` 
Disp0503	Temperature.java
``` console 
Enter degrees Fahrenheit:
212
Equivalent Celsius temperature is 100.0 C
``` 
Disp0504	TurnTaker.java
``` console 
Turn = 1
Love from Romeo
Turn = 2
Turn = 3
Love from Juliet
Turn = 4
``` 
Disp0505	InvocationCounter.java
``` console
Number of invocations so far = 6
Number of invocations so far = 8
Number of invocations so far = 10
Number of invocations so far = 12
Number of invocations so far = 14
Number of invocations so far = 16
Totalnumber of invocations = 17
``` 
Proj0501	BookStore.java
``` console
Corresponding to Book ID: 1, quantity available: 8
Total number of books sold by the store: 2
Corresponding to Book ID: 2, quantity available: 4
Total number of books sold by the store: 3
Corresponding to Book ID: 3, quantity available: 27
Total number of books sold by the store: 6
``` 
Proj0502	Fraction.java
``` console
40/60 = 2/3
To create a fraction
Enter the numerator:
1
Enter the denominator:
3
You enter fraction: 1/3
The target fraction:
Enter the numerator:
20
Enter the denominator:
61
You enter fraction: 20/61
1/3 is NOT identical to 20/61
To continue: 'Y'?
y
The target fraction:
Enter the numerator:
20
Enter the denominator:
60
You enter fraction: 20/60
1/3 is identical to 20/60
To continue: 'Y'?
n
``` 
Proj0503	Container.java
``` console
Tank 1.01 kiloliters
Bin Quantity:
123.00 milliliters
Leftover: 79.877
Target leftover not enough to fill required qty.
0.00 milliliters
80.00 liters
Tank Quantity: 929.877
``` 
Proj0504	Team.java Competition.java
``` console
copied:
	null, null, null & null,
	competition1: null, winningTeam: null, runnerUp: null in year 0.,
	competition2: null, winningTeam: null, runnerUp: null in year 0.
The origin :
	Rick Stoner, Nick Fury, Timothy Dugan & G. W. Bridge,
	competition1: Summer, winningTeam: null, runnerUp: null in year 0.,
	competition2: Spring, winningTeam: null, runnerUp: null in year 0.
After deep copied... and changed new Competitions info.
The origin :
	Rick Stoner, Nick Fury, Timothy Dugan & G. W. Bridge,
	competition1: Summer, winningTeam: The First, runnerUp: The Second in year 2020.,
	competition2: Spring, winningTeam: The Winner, runnerUp: The First in year 2021.
The copy   :
	Rick Stoner, Nick Fury, Timothy Dugan & G. W. Bridge,
	competition1: Summer, winningTeam: null, runnerUp: null in year 2022.,
	competition2: Spring, winningTeam: null, runnerUp: null in year 2023.
``` 
Proj0505	Money.java
``` console
m1: 12 dollars & 85 cents  m2: 12 dollars & 35 cents
m1 + m2: 25 dollars & 20 cents
m1 - m2: 0 dollars & 50 cents
m1 + m2: 25 dollars & 20 cents
m1 - m2: 0 dollars & 50 cents
m1 is $12.85: true
m1: 0 dollars & 50 cents  m2: 12 dollars & 35 cents
``` 
Proj0506	Rational.java
``` console
n1: -64/2  n2: 1/2 n4: -1/2  n5: 3/4
add(n1,n2)  : -63/2
n1.add(n2)  : -63/2
minus(n1,n2): -65/2
n1.minus(n2): -65/2
multiply(n4, n5): -3/8
n4.multiply(n5) : -3/8
divide(n4, n5   : -2/3
n4.divide(n5)   : -2/3
n4.divideThisBy(n5): -2/3
-2/3 equal -4/6 : true
``` 
Proj0507	NationalCall.java InternationalCall.java
``` console
Billing for National Call/ International Call
SourceNum       DestineNum        Duration      Price
6543210         6543211                 60       0.20
6543210         6543211                120       0.29
6543210         6512311                180       0.28
Total                                  360       0.76
Billing for National Call/ International Call
SourceNum       DestineNum        Duration      Price
+65 6543210     001 12 12345            60       0.60
+65 6543210     001 12 12345           120       0.74
+65 6543210     123 54321              180       0.54
Total                                  360       1.88
Source phone number: +65 6543210
Destination phone number: 123 54321
Total duration of current call in seconds: 180
Total duration of all call: 360
Current call price: $0.54
Total price of all calls: $1.88
``` 
Proj0508	PizzaOrder.java
``` console
Order1 pizza1: large pizza, 1 cheese, 0 pepperoni, 1 ham,  cost $18.00 .
Order1 pizza2: medium pizza, 2 cheese, 2 pepperoni, 0 ham,  cost $20.00 .
Order1 pizza3: null
Order1 Total: 38.0
Order2 pizza1: large pizza, 3 cheese, 0 pepperoni, 1 ham,  cost $22.00 .
Order2 pizza2: medium pizza, 2 cheese, 2 pepperoni, 0 ham,  cost $20.00 .
Order2 Total: 42.0
Order1 OrigTotal: 38.0
``` 
Proj0509	Person.java
``` console
A Short List of Composers:
Johann Sebastian Bach, March 21, 1685-July 28, 1750
Igor Stravinsky, June 17, 1882-April 6, 1971
John Adams, February 15, 1947-
Comparing bach and bachTwin:
Distinct copies.
Same data.
``` 
Proj0510	BoxOfProduce.java
``` console
BoxOfProduce randomly selected, which contains
3 bundles of 1:Kale, 2:Broccoli, 3:Tomato.
To substitute any one of the five possible fruits.
	0. skip
	1. Kale
	2. Broccoli
	3. Tomato
	9. to end.
	Selection: 9
---
``` 
Proj0511	Proj0511
``` console
ntw@Mac-mini chapter5 % pwd
/Users/antw/absoluteJ/chapter5/chapter5
antw@Mac-mini chapter5 %
antw@Mac-mini chapter5 % javaC -d build/classes src/Finance/Money.java
antw@Mac-mini chapter5 % javaC -d build/classes src/MyMath/Rational.java
antw@Mac-mini chapter5 % java -cp build/classes src/Proj0511/main.java
<<< package Finance.Money >>>
...
antw@Mac-mini chapter5 % javaC -d build/classes -cp build/classes src/Proj0511/main.java
antw@Mac-mini chapter5 % cd build/classes
antw@Mac-mini classes % java Proj0511/main
<<< package Finance.Money >>>
m1: 12 dollars & 85 cents  m2: 12 dollars & 35 cents
m1 + m2: 25 dollars & 20 cents
m1: 12 dollars & 85 cents  m2: 12 dollars & 35 cents
<<< package MyMath.Rational >>>
n1: -64/2  n2: 1/2 n4: -1/2  n5: 3/4
divide(n4, n5)   : -2/3
antw@Mac-mini classes % cd ../..
antw@Mac-mini chapter5 % pwd
/Users/antw/absoluteJ/chapter5/chapter5
antw@Mac-mini chapter5 %
``` 
