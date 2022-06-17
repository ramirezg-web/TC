<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Introduction to Objects Using Strings - Lecture Notes
###### (05/14/2018)

## [**Overview of Session**](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html)

Until now we've primarily worked with the primitive data types. These data types are simple because they only hold a single literal value and require a fixed amount of memory. But what if we want to model something more complex than that? What if, instead of holding a single character in a variable, we want to hold a name, or an address or an unknown number of characters all together?

This week we will begin learning about objects and how we can use this new concept to create more complex, and more useful, programs.

## **Session Objectives:**
* Students should be able to explain the concept of an object as a programming construct
* Students should be able to describe the difference between objects and classes and how those two concepts are related
* Students should be able to instantiate and use objects
* Students should understand the terms Declare, Instantiate and Initialize
* Students should understand how objects are stored in RAM
* Students should be able to explain how the Stack and Heap are used with objects and primitives
* Students should understand and be able to define the terms Value-type and Reference-type
* Students should be able to describe the String class, its purpose and use
* Students should be able to call methods on an object and understand that they return values
* Students should understand immutability and what that means for handling certain objects
* Students should be able to explain object equality and the difference between `==` and `equals()`

## **Classroom Preparation**

1. Write various string methods on board

    | method      | use    |
    |-------------|--------|
    | length()    | Returns how many characters are in the string |
    | substring() | Returns a certain part of the string |
    | indexOf()   | Returns the index of a search string |
    | charAt()    | Returns the `char` from a specified index |
    | contains()  | Returns `true` of the string contains the search string |
    | | And many more... |

2. This is a heavy theory day. For lecture code, if you want, it might make more sense to write examples of each topic yourself instead of stepping through the existing lecture code as is.

## **Agenda and Timing for Session**

* [Objects](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#what-is-an-object) & [Classes](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#what-is-a-class) (0:45)
* Heap & Stack / Reference & Value Types (0:20)
* Break (0:10)
* Immutability (0:20)
* [String Equality](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#object-equality) (0:10)
* [String Methods](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#strings) (0:30)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### [What is an Object](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#what-is-an-object)

- Be sure to describe in terms of Objects and not in terms of Classes

<div class="definition note">
An <span>object</span> is an in-memory data structure that combines state and behavior into a usable and useful abstraction.
</div>

- An object lives in memory and each object is different and separate from every other object in our program.

### [What is a Class](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#what-is-a-class)

- We don't technically write objects in our code. Objects only exist when our code is running because an object is an in-memory data structure. In order to make objects, we have to write classes.

<div class="definition note">
A <span>class</span> is a grouping of variables and methods in a source code file that we can generate objects out of.
</div>

- A class is to an object like a blueprint is to a house. A class defines what an object will be like once the object is created.
- We can even create our own classes, but we'll talk more about that later in the week.

### [Creating Objects](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#creating-objects)

- `House houseAt443WinstonSt = new House(3, 2.5, "Cornflower Blue");`
- First we **Declare** the variable that will hold the object, then **Instantiate** a new object from a class while we **Initialize** the variables inside the object with some initial values.

### [Objects in Memory](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#objects-in-memory)

- Reference vs. Value Types

    - All of the simple/primitive types that we have worked with are considered primitive types.

        <div class="definition note">A <strong>value type</strong> references a single static space in memory to hold the value. This memory is allocated on the <em>stack</em></div>

        <div class="definition note">The stack is a region of computer memory that manages temporary variables created by each function.</div>

        <div class="definition note">A <strong>reference type</strong> is a data type whose value is a pointer to a memory location that holds the data. This memory location is on the <em>heap</em>. Multiple variables can point to the same memory location and thus modify the underlying object.</div>

        <div class="definition note">The heap is a free-floating region of memory managed by the computer and referenced by pointers.</div>

        <div class="analogy note">Sending an attachment via email is an example of a value type. Sending a link to an attachment hosted on Dropbox/Google Drive would be an example of a reference type.</div>

   - Immutability

     <div class="caution note">While strings are reference types, they are also <strong>immutable</strong>. They are unable to be changed or altered and thus performing any operation on a string creates a new string.

     That new string *must* be saved to a variable if you want to keep it. If you want to change a string to all upper case, you can't just call:

       ``` java
       first_name.toUpperCase();
       ```

       That doesn't change `first_name`. It creates a new object and then throws it away. If you want `first_name` to hold the now upper cased string, you have to write this:

       ``` java
       first_name = first_name.toUpperCase();
       ```

     </div>

- Initializing an Object

    - All objects need to be initialized or *instantiated*.
    - We won't cover this flow today because strings are a special form of object and support the ability to type in the *literal* value.
    - `String name = "Josh";`
    - Objects can be declared and the value can be left as `null`.
    - `String name;`

### [Object Equality](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#object-equality)

- You can't use `==` with Strings or any objects because `==` compares values on the Stack. `==` asks "Are these two variables pointing to the same object on the Heap?" Which is typically not what we want.
- All objects have a `equals()` method that we can use instead that asks "Are these two objects equal to each other?"

> Warning: If you try to demo this, the `==` will appear to return the same value as `.equals()` because Java automatically interns string literals to save space. All string literals with the same content point to the same object so `==` will appear to work the same as `.equals()`. Construct your second string by concatenating created Strings instead of using literals if you want to demo this behavior.
>
> ``` Java
> "equality" == "equality"; // this will be true due to interning making the reference the same
>
> "equality" == "equal" + "ity"; // this is true due to compiler optimizations knowing that two concatenated String literals should be treated as a single literal
>
> String ending = "ity";
> "equality" == "equal" + ending; // this will be false and what you want to demo
> ```

### [Strings](https://book.techelevator.com/jpmc/content/introduction-to-objects-ool.html#strings)
- The `String` class
- String methods
    - `length()`
    - `substring()`
    - `contains()`
    - `startsWith()` and `endsWith()`
    - `indexOf()`
    - `replace()`
    - `toLower()` and `toUpper()`
    - `equals()` and `equalsIgnoreCase()`
    - `split()`
    - `String.join()`



## Instructor Led Exercises

- [Java Lecture Code](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/lecture/introduction-to-objects-lecture/)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/introduction-to-objects-exercises/)

