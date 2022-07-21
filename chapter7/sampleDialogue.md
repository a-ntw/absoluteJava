run:
Absolute Java  Chapter7 Programming Projects. 
### Sample dialogue
``` java 
``` 

Disp0703	HourlyEmployee.java
``` java 
joe's longer name is Joe Worker
Changing joe's name to Josephine.
joe's record is as follows:
Josephine January 1, 2015
$50.5 per hour for 160.0 hours
``` 

Disp0705	SalariedEmployee.java
``` java 
joe's longer name is Josephine
showEmployee(joe) invoked:
Josephine
January 1, 2015
showEmployee(sam) invoked:
Sam
February 1, 2015
``` 

Disp0707	EnhancedStringTokenizer.java
``` java 
Enter a sentence:
I    love     you,    madly.
Your sentence with extra blanks deleted:
I love you, madly. 
Sentence with each word on a separate line:
I
love
you,
madly.
``` 

Proj0701	Person.java Student.java Teacher.java
``` java 
Anne 
John Ang
id: 19, course: Information, teacher: Tan
Wendy Tan
id: 39, course: UI Design, teacher: Ong
Mary Tan
subject: Internet, salary: 3000.0
June Ong
subject: Programming, salary: 2000.0

anne is equal to annie
Anne Tai is the same as Anne Tai
``` 

Proj0702	Message.java SMS.java Email.java
``` java 
SMS contain 123: true
Email contain hello: true
Java: Uijt!jt!Kbwb
``` 

Proj0703	Alien.java AlienPack.java AlienSnake.java AlienOgre.java AlienMarshmallow.java
``` java 
class AlienSnake
Alien name: Sss, Heath: 50, Damage: 10
class AlienOgre
Alien name: Ooo, Heath: 30, Damage: 6
class AlienMarshmallow
Alien name: Mmm, Heath: 20, Damage: 1
Damage: 17
``` 

Proj0704	Administrator.java
``` java 
joe is equal to josephine!
Josephine January 1, 2015
$10000.0 per year
title: Director; responsible: Personnel; supervisor: Sam

Josephine
January 1, 2015
Choose
 1. Name
 2. Salary & Hire Date
 3. Title & Responsibility
 4. Supervisor
 5. Quit
Choice: 1
Name: Josephine
Choice: 2
Salary: $20000.0 per year; Hire Date: January 1, 2015
Choice: 3
Title: Director; Responsibility: Personnel
Choice: 4
Supervisor: Sam
Choice: 5

``` 

Proj0705	Doctor.java
``` java 
sam is equal to samuel
Samuel February 1, 2015
$5000.0 per year
Specialty: Obstetrician; Office visit fee: $250.0

Samuel
February 1, 2015
``` 

Proj0706	Vehicle.java Truck.java
``` java 
Some Where Co., 6 cyl.
Capacity: 1000.0, Tow capacity3000
Anne Tai is equal Anne
* * * * *
Manufacturer: Some Where Co.
Cylinder: 6
Owner: Anne Tai
Truck capacity: 1000.0 kg; tow capacity: 3000 kg
``` 

Proj0707	Patient.java Billing.java
``` java 
Patient methods testing: ok . ok .. ok ... 
Billing methods testing: ok . ok .. ok ...
Patient Mary attended by Dr. Samuel      $250.00 
Patient Anne attended by Dr. Nick        $330.00 
Total income from the records            $580.00 
``` 

Proj0708	Pet.java Dog.java Cat.java
``` java 
My records on your pet are incomplete.
Here is what they currently say:
Name: Jane Dow Age: 0 years. Weight: 0.0 pounds.
Please enter the pet's name:
Fang Junior
Please enter the pet's age:
5
Please enter the pet's weight:
87.5
Please enter the pet's type 'dog'/'cat': 
dog
My records now say:
Name: Fang Junior Age: 5 years. Weight: 87.5 pounds.
Dosage on Acepromazine for Fang Junior will be 0.119 ml.
Dosage on Carprofen for Fang Junior will be 1.66 ml.
Meow is 2yrs old at 3.5 pounds.
Dosage on Acepromazine for Meow will be 0.000 ml.
Dosage on Carprofen for Meow will be 0.03 ml.
``` 

Proj0709	BoxOfProduce.java Produce.java Fruit.java Vegetable.java
``` java 
Methods testing:  . ok  .. ok 
Ramdonly selected
There are 2 nos of fruits, & 1 nos of vegetable.
contains
3 bundles, consist of 1:Broccoli, 2:Kiwi, 3:Tomatillo.
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add, or anykey to done.
+
4 bundles, consist of 1:Broccoli, 2:Kiwi, 3:Tomatillo, 4:Broccoli.
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add, or anykey to done.
1
Input fruit name:
kiwi
4 bundles, consist of 1:Kiwi, 2:Kiwi, 3:Tomatillo, 4:Broccoli.
Select number to substitute any one of the five possible
 fruits or vegetables. `+` to add, or anykey to done.
x
BUILD SUCCESSFUL (total time: 1 minute 39 seconds)
```
---
main.java
```java
public class main {

    public static void main(String[] args) {
        String s1 = "``` %n%n", s2 = "%n``` java %n";

        System.out.printf("Absolute Java  Chapter7 Programming Projects. %n"
                + "### Sample dialogue%n``` java %n");

        System.out.printf(s1 + "Disp0703	HourlyEmployee.java" + s2);
        HourlyEmployee.main(args);

        System.out.printf(s1 + "Disp0705	SalariedEmployee.java" + s2);
        SalariedEmployee.main(args);

        System.out.printf(s1  + "Disp0707	EnhancedStringTokenizer.java" + s2);
        EnhancedStringTokenizer.main(args);

        System.out.printf(s1 + "Proj0701	Person.java Student.java Teacher.java" + s2);
        Person.main(args);

        System.out.printf(s1 + "Proj0702	Message.java SMS.java Email.java" + s2);
        Message.main(args);

        System.out.printf(s1 + "Proj0703	Alien.java AlienPack.java AlienSnake.java AlienOgre.java AlienMarshmallow.java" + s2);
        AlienPack.main(args);

        System.out.printf(s1 + "Proj0704	Administrator.java" + s2);
        Administrator.main(args);

        System.out.printf(s1 + "Proj0705	Doctor.java" + s2);
        Doctor.main(args);

        System.out.printf(s1 + "Proj0706	Vehicle.java Truck.java" + s2);
        Truck.main(args);

        System.out.printf(s1 + "Proj0707	Patient.java Billing.java" + s2);
        Patient.main(args);

        System.out.printf(s1 + "Proj0708	Pet.java Dog.java Cat.java" + s2);
        Pet.main(args);

        System.out.printf(s1 + "Proj0709	BoxOfProduce.java Produce.java Fruit.java Vegetable.java" + s2);
        BoxOfProduce.main(args);

        System.out.printf(s1 + "main.java" + s2);
        System.out.println(main.class.getName().toString());

        System.out.println("\n```");
    }
}
```
