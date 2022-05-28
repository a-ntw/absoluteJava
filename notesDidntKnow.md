mynotes on didn't know about these:

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


### chapter 3 ###

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