mynotes on didn't know about these:

- [chapter 1](#chapter-1)
- [chapter 2](#chapter-2)
- [chapter 3](#chapter-3)
- [chapter 4](#chapter-4)
- [chapter 5](#chapter-5)
- [chapter 6](#chapter-6)
- [chapter 7](#chapter-7)

[top]: topOfThePage

---
### chapter 1 ###

pg 35

Java is an **object-oriented programming (OOP)** language.

Object-oriented programming has its own specialized terminology. 
The objects are called, appropriately enough, **objects**. 
The actions that an object can take are called **methods**. 
Objects of the same kind are said to have the same *type* or, 
more often, are said to be in the same **class**. 

### chapter 2 ###

pg 93

Different Approaches to Formatting Output

Three approaches to formatting numeric (and other) output. 
We will discuss the method `printf` and 
the two formatting classes `NumberFormat` and `DecimalFormat`.

`System.out.printf("$%6.2f for each %s.%n", price, name);`

`NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance();`

`DecimalFormat formattingObject = new DecimalFormat("#0.0##");`

pg 115

PITFALL: Dealing with the Line Terminator, `\n`

When combining different methods for reading from the keyboard, you sometimes 
have to include an extra invocation of nextLine to get rid of the end of a line 
(to get rid of a `\n`). 


[:top: Top](#top)
### chapter 3 ###
pg 145

The conditional operator (also called the **ternary operator** or **arithmetic if**).
```
    if (n1 > n2)
        max = n1;
    else
        max = n2;
```
can be expressed 
```
    max = (n1 > n2) ? n1 : n2;
```

pg 147

PITFALL: Using == with Strings

`if (s1.equals(s2))
        System.out.println("They are equal strings.");`

pg 156

short-circuit evaluation or lazy evaluation.

`if ( (kids != 0) && ((pieces/kids) >= 2) )
        System.out.println("Each child may have two pieces!");`
The expression `(kids != 0)` evaluates to `false`, so there would be no need to 
evaluate the second expression. 

pg 180

To **label** a loop statement, simply precede it with an Identifier and a colon. The
following is an outline of some sample code that uses a labeled break statement:
``` java
        outerLoop:
        do
        {
        ...
                 while (next >= 0)
                 {
                   next = keyboard.nextInt( );
                   if (next < -100)
                       break outerLoop;
                   ...
        }
        ...
                 answer = ...
            } while (answer.equalsIgnoreCase("yes"));
```

pg 188

An even better solution is to declare a `boolean` variable to control the `do-while` loop.
``` java
        boolean invalidKey;
        do
        {
            System.out.println("Enter 'A' for option A " +
              "or 'B' for option B.");
            s = keyboard.next( );
            s = s.toLowerCase( );
            c = s.charAt(0);
            if (c == 'a')
                invalidKey = false;
            else if (c == 'b')
                invalidKey = false;
            else
                invalidKey = true;
        }
        while (invalidKey);
```

pg 190

Assertion Checking

`assert (n == 0) && (sum == 0);`

`java -enableassertions YourProgram`


[:top: Top](#top)
### chapter 4 ###

pg 214

return in a void method

If you want to end a void method before it runs out of statements, you can use
a return statement without any expression, as follows: 

`       return; `

pg 216

Any method can be used as a void method

If you want the action, but do not need the returned value, you can invoke the 
method as if it were a void method and the returned value will simply be discarded.
``` java
Scanner keyboard = new Scanner(System.in);
...
String inputString = keyboard.nextLine();
... 
System.out.println("Press Enter to continue with program.");
keyboard.nextLine(); //Reads a line and discards it.
```

pg 219

A variable declared within a method definition is called a `local variable`. 

Thus far, have discuessed two kinds of variables: instance variables, whose
meaning is confined to an object of a class, and local variables, whose meaning
os confined to a method definition.
Java does not have global variables.

pg 230

The `this` Parameter

Within a method definition, you can use the keyword `this` as a name for the
calling object. If an instancee variable or another method in the class is used
without any calling object, then `this` is understood to be the calling object.

pg 234

The Methods `equals` and `toString`

pg 238

`Stubs`. These stubs will not necessarily perform the correct calculation, 
but will deliver values that suffice for testing, and they are simple enough
that you can have confidence in their performance.

Every method should be tested in a program in which every other method in the 
testing program has already been fully tested and debugged.

pg 240

It is considered good programming practice to make all instance variables private.
...
Any instance variable can be labeled either `public` or `private`. Any method
can be `public` or `private`. However, normal 
good programming practices require that *all* instance variables be private and 
that typically, most methods be public. Normally, a method is private only if
it is being used solely as a helping method in the definition of other methods.

pg 242

**Accessor methods** allow you to obtain the data. eg `getMonth`, `getDay`. ...
they must return the values or something equivalent to those values of instance
variable.

**Mutator metods** allow you to change the data in a class object. eg `set`. ...
eg. They all test for an illegal date and end the programm with an error message 
if there is an attempt to set the instance vaiables to any illegal values. ...
With mutator methods, you can control amd filter changes to the data.

pg 249
``` java
/**
Precondition: All instance variables of the calling object have values.
Postcondition: The data in the calling object has been written to the screen.
*/
public void writeOutput()
```
``` java
/**
Precondition: All instance variables of the calling object have values.
Returns a string describing the data in the calling object.
*/
public String toString()
```

pg 250

Overloading. Two or more methods *in the same class* can have the same method name.

pg 253

Signature. The signature if a method consists if the method name and the list
of types of parameters that are listed in the hading of the method name.

pg 264

Note that when you define a constructor, you do not give any return type for the
constructor; you do not even use `void` in place of a return type, Also notice
that constructor are normally public.

Constructor,

... Constructors use used to initiallize objects.
``` java
Date birthday = new Date("December", 16, 1970),
    theDate = new Date(2008);
```

pg 267

TIP: You Can invoke Another Method in a Constructor.

TIP: A Constructor Has a this Parameter

TIP: Include a No-Argument constructor
``` java
MyClass myObject = new MyClass();
```

pg 276
 
The `StringTokenizer` Class *
``` java
StringTokenizer wordFactory =
    new StringTokenizer("A single word can be critical.");
    while(wordFactory.hasMoreTokens())
    {
        System.out.println(wordFactory.nextToken());
    }
```
This will produce the following output:
``` console
    A
    single
    word
    can
    be
    critical.
```


[:top: Top](#top)
### chapter 5 ###

pg 295

A **static method** is one that can be used without a calling object. With a 
static method, you normally use the class name in place if a calling object.

You can invoke a nonstatic method within a static method: if you create an
object if the class and use that object as the calling object. eg main...

pf 304

A **static variable** belongs to the class as a whole. All objects of te class
can read and change the static variable. Static variables should normally be 
private.
``` java
    private static Type Variable_Name;
    public static final Type Variable Name = Constant_Value;
```

pg 310

The wrapper classes for the primitive types `byte`, `short`, `long`, `float`, `double`,
and `char` are `Byte`, `Short`, `Long`, `Float`, `Double`, and `Character`, respectively.

pg 312

Static Methods in Wrapper Classes

use the associated wrapper class to find the value of the largest and smallest 
values of any of the primitive number types. 

`Integer.MAX_VALUE` and `Integer.MIN_VALUE`

`Double.MAX_VALUE` and `Double.MIN_VALUE`

the static methods `Double.parseDouble`, `nteger.parseInt`, `Long.parseLong`, and 
`Float.parseFloat` convert from string representations to numbers of the 
corresponding primitive types `double`, `int`, `long`, and `float`, respectively.

`Double.parseDouble("199.98")`

`Double.parseDouble(theString.trim())`

Each of the numeric wrapper classes also has a static method called `toString`

 `Double.toString(123.99)`

pg 331

Anonymous Objects

``` java
 if (variable1.equals(new ToyClass("JOE", 42)))
     System.out.println("Equal");
else
     System.out.println("Not equal");
```
The expression `new ToyClass("JOE", 42)` (or more exactly, the object it 
creates) is an example of an anonymous object.

pg 334

TIP: Use Static importd *

`import static java.lang.Character.toUpperCase;`

This works for static methods only. This does not in any way apply to ordinary 
nonstatic methods.

pg 341

Class Invariant

A statement that is always true for every object of the class is called a 
**class invariant**. A class invariant can help to define a class in a 
consistent and organized way.

pg 345

Copy Constructor

A copy constructor is a constructor with one parameter of the same type as the 
class.
```  java
                Date date1 = new Date("January", 1, 2015);
                Date date2 = new Date(date1);
```
After this code is executed, both date1 and date2 represent the date January 1, 
2015, but they are two different objects. So, if we change one of these objects, 
it will not change the other. 

pg 352

immutable class
``` java
    String greeting = "Hello";
    String helloVariable = greeting;
    greeting = greeting + "friend.";
    System.out.println(helloVariable);
```
This produces the output "Hello".

A class that contains no methods (other than constructors) that change any of 
the data in an object of the class is called an **immutable class**, and objects 
of the class are called **immutable objects**. The class String is an immutable 
class.

A class that contains public mutator methods or other public methods, such as 
input methods, that can change the data in an object of the class is called a 
**mutable class**, and objects of the class are called **mutable objects**. The 
class Date is an example of a mutable class; many, perhaps most, of the classes 
you define will be mutable classes.

You should never write a method that returns a mutable object, but should 
instead use a copy constructor (or other means) to return a reference to a 
completely independent copy of the mutable object.

pg 363

Commenting Classes for `javadoc` *

The following are some of the @ tags allowed:
``` java
        @param Parameter_Name Parameter_Description 
        @return Description_Of_Value_Returned 
        @throws Exception_Type Explanation 
        @deprecated
        @see Package_Name.Class_Name 
        @author Author
        @version Version_Information
```

pg 364

Running `javadoc *`

To run javadoc on a package, all you need to do is give the following command:

`javadoc –d Documentation_Directory Package_Name`

``` console
antw@Mac-mini 2022java % javadoc -d doc BinaryGap.java
Loading source file BinaryGap.java...
Constructing Javadoc information...
Building index for all the packages and classes...
Standard Doclet version 17+35-LTS-2724
Building tree for all the packages and classes...
Generating doc/BinaryGap.html...
...
```


[:top: Top](#top)
### chapter 6 ###
pg 382

In Java, an array is considered to be an object, ...

Declaring and Creating an Array

``` java
 char[] line = new char[80];
 double[] reading = new double[300];
 Person[] specimen = new Person[100];
```
Person is a class.

square brackets `[]`

`double[] score;`

`score = new double[5]`


pg 385 

`int[] age = {2, 12, 1}`

pg 187

The class `String` has a constructor that has a single parameter of type `char[]`.
``` java
        char[] a = {'A', ' ', 'B', 'i', 'g', ' ', 'H', 'i', '!'};
        String s = new String(a); // Can obtain the String value
        System.out.println(a);     // A Big Hi!
        String s2 = new String(a, 2, 3);
        System.out.println(s2);    // Big
```

pg 390

Arrays with a Class Base Type
``` java
    Date[] holidayList = new Date[20];
    for (int i = 0; i < holidayList.length; i++)
        holidayList[i] = new Date( );
```

pg 392

Array types are reference types; that is, an array variable contains the memory 
address of the array it names. The assignment operator copies this memory address.
``` java
    double[] a = new double[10], b = new double[10];
    for (int i = 0; i < a.length; i++) 
        a[i] = i;
    b = a;
    System.out.println("a[2] = " + a[2] + " b[2] = " + b[2]); // a[2] = 2.0 b[2] = 2.0
    a[2] = 42; 
    System.out.println("a[2] = " + a[2] + " b[2] = " + b[2]); // a[2] = 42.0 b[2] = 42.0
```
The equality operator `==` does not test two arrays to see if they contain the 
same values. It tests two arrays to see if they are stored in the same location 
in the computer’s memory. 

pg 395

the array parameter specifies the base type of the array but not the length of the array.
``` java
 char[] c = new char[10]; int[] a = new int[10]; int[] b = new int[20];
// ...

 AClass.listChars(c);   AClass.zeroAll(a);      AClass.zeroAll(b);
```

pg 398

The Method main Has an Array Parameter
``` java
    public static void main(String[] args) {
```
The identifier args is a parameter for an array of base type `String`.

pg 411

For-Each Loop for Arrays

SYNTAX
``` java
    for (Array_Base_Type Variable : Array_Name)
        Statement
```
EXAMPLES
``` java
 for (double element : a)
     sum += element;
```
The array a has base type `double`. This for-each loop sets each element of the array `a` to `0.0`.
A good way to read the first line of the example is “For each element in `a`, do the following.”

pg 414

vararg specification

A parameter specification that specifies any number of parameters, such as `int... arg`, 
is called a **vararg specification**. The three dots in a vararg specification 
are called an **ellipsis**.

You can have only one variable parameter specification, such as `int... arg`, in a 
method definition. However, you may also have any number of ordinary parameters, 
in which case the vararg specification must be the last item on the parameter list. 

pg 416

Privacy Leaks with Array Instance Variables
``` java
public double[] getInsideArray( ) // Problematic version {
    return a; }
```
A safe definition of getInsideArray is the following:
``` java
public double[] getInsideArray( ) { // Good version 
    //Recall that maxNumberElements == a.length.
    double[] temp = new double[maxNumberElements];
    for (int i = 0; i < maxNumberElements; i++)
        temp[i] = a[i];
    return temp;
}
```

pg 420

selection sort

The details could be developed by using two arrays and copying the elements from 
one array to the other in sorted order, but using one array should be both 
adequate and economical.

pg 424

Enumerated Types *

An **enumerated type** is a type for which you give all the values of the type 
in a typically short list. A value of an enumerated type is a kind of named 
constant and so, by convention, is spelled with all uppercase letters.

A variable of an enumerated type can have a value that must be either one of the 
values listed in the definition of the type or else the special value `null`, ...

Example
* For enumerated types, `(Value1.equals(Value2))` is equivalent to `(Value1 == Value2).`
* `WorkDay.MONDAY.toString( )` returns "`MONDAY`".
* `WorkDay.MONDAY.ordinal( )` returns 0, `WorkDay.TUESDAY.ordinal( )` returns 1, and so forth.
* `WorkDay.TUESDAY.compareTo(WorkDay.THURSDAY)`returns a negative value.
* `WorkDay[] day = WorkDay.values();` ... `day[i]`
* `WorkDay.valueOf("THURSDAY")` returns `WorkDay.THURSDAY`.

pg 431

Multidimensional Array Basic
```
    char[][] page = new char[30][100];
```

pg 435

Ragged Arrays *



[:top: Top](#top)
### chapter 7 ###

pg 460

Inheritance is the process by which a new class — known as a *derived class* — 
is created from another class, called the *base class*. A derived class 
automatically has all the instance variables and all the methods that the base 
class has, and can have additional methods and/or additional instance variables.

A derived class is also called a **subclass**, in which case the base class is 
usually called a **superclass**.
``` java
        public class HourlyEmployee extends Employee
```
The class `HourlyEmployee` (or any other derived class) is said to **inherit** 
the instance variables and methods of the base class that it extends.

pg 467

the only members not inherited are private methods.

A derived class automatically has all the instance variables, all the static 
variables, and all the public methods of the base class. These members from the 
base class are said to be **inherited**. ... The one exception is, you can give 
a definition for an inherited method in the definition of the derived class; 
this will redefine the meaning of the method for the derived class.

pg 470

A base class is often called the **parent class**. A derived class is then called 
a **child class**.

the method may be redefined in the derived class. This is called **overriding** 
the method definition.

If you add the modifier `final` to the definition of a method, it indicates that 
the method may not be redefined in a derived class.

As a general rule, when overriding a method definition, you may *not* change the 
type returned by the method, ... The one exception to this rule is if the 
returned type is a class type, ... This sort of changed return type is known as 
a **covariant return type** ...
``` java
    public class BaseClass {
          ...
        public Employee getSomeone(int someKey)
          ...
```
In this case, the following details would be allowed in a derived class:
``` java
    public class DerivedClass extends BaseClass {
          ...
        public HourlyEmployee getSomeone(int someKey)
        ...
```
pg 472

Changing the Access Permission of an Overridden Method

You can change the access permission of an overridden method from `private` in 
the base class to `public` in the derived class (or in any other way that makes 
access permissions more permissive).
``` java
public class BaseClass {    private void doSomething()
```
can use the following heading when overriding the method definition in a 
derived class:
``` java
public class DerivedClass { public void doSomething()
```
but you cannot change `public` to `private`.


pg 476

Within the definition of a constructor for a class, you can use `super` as a name 
for a constructor of the base class. Any invocation of `super` must be the first 
action taken by the constructor.
``` java
    public HourlyEmployee() {
        super(); // If this line is omitted, Java will still invoke the 
        //          no-argument constructor for the base class.
        wageRate = 0;
        hours = 0;
    }
```
if you do not include a call to a base class constructor (using super), then the 
no-argument constructor of the base class is called automatically.

pg 483 **Encapsulation and Inheritance**

the information-hiding facilities of Java, primarily the `private` modifier, 
interact with inheritance. ...
An instance variable (or method) that is private in a base class is not 
accessible *by name* in the definition of a method in *any other class, not even 
in a method definition of a derived class*.

pg 487

The two classifications of instance variables and methods are *protected access*, 
which always gives access, and *package access*, which gives access if the derived 
class is in the same package as the base class. ... Many programming authorities 
discourage the use of the `protected` modifier. 

If you do not place any of the modifiers `public`, `private`, or `protected` before an 
instance variable or method definition, then the instance variable or method is 
said to have **package access**. Package access is also known as **default access** and 
as **friendly access**.

pg 489 Access Modifiers
public class A | public class B | public class C extends A | public class D extends A | public class E
--- | --- | --- | --- | ---
package same      | package same    | package **same** | default | default
**public int** v1;    | can access v1.  | can access v1. | can access v1. | can access v1.
**protected int** v2; | can access v2.  | can access v2.  | **can** access v2. | cannot access v2.
**int** v3.           | can acess v3.   | can acess v3.   | **cannot** acess v3. | cannot access v3.
**private int** v4;   | cannot access v4. | cannot access v4. | cannot access v4. | cannot access v4.

... all the classes in your current directory (that do not belong to some other 
package) belong to an unnamed package called the *default package*. 

pg 493

Tip: "is a" versus "has a"

an `HourlyEmployee` *is an* `Employee` and *has a* `Date`.

The expression `super.toString()` is an invocation of the method `toString()` using 
the definition of `toString()` given in the base class `Employee`.


pg 496

In Java, every class is a descendent of the class `Object`. So, every object of 
every class is of type `Object`, as well as being of the type of its class.

The class `Object` is in the package `java.lang`, which is always imported automatically.

The Right Way to Define `equals`
``` java
    public boolean equals(Object otherObject) {
        Employee otherEmployee = (Employee) otherObject;
        return (name.equals(otherEmployee.name)
                && hireDate.equals(otherEmployee.hireDate));
    }
```
Every object inherits the method `getClass()` from the class `Object`. ... For 
any object `o`, 
``` java
        o.getClass()
```
returns a representation of the class used to create `o`. 

The `instanceof` operator checks to see if an object is of the type given as its 
second argument. The syntax is
``` java
        Object instanceof Class_Name
```
which returns `true` if Object is of type `Class_Name`; otherwise it returns 
`false`.



[:top: Top](#top)

---
