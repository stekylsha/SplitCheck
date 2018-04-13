# Split The Check

## Problem Details

### Overview

Implement an program that allows a group of people to split the check of a restaurant, allowing each one to pay only for the items they consumed.


### Input

This program should take a list of entries in the following format:

`VALUE = PERSON1, PERSON2, PERSON3, ...`

Indicating that the provided `VALUE` should be split by all individuals in the `PERSON1, PERSON2, PERSON3, ...` list.

For instance, the entry

`15 = Alice, Bob, Charlie`

indicates that Alice, Bob and Charlie shared a meal that costs $15. So, each should pay $5 to cover for the cost of this item.


### Output

The program should produce a list with the value each person should pay.

### Example

For the following input:

```
2 = Alice
8 = Bob, Charlie
15 = Alice, Bob, Charlie
1 = Charlie
```

The program should produce this output:


```
Alice = 7
Bob = 9
Charlie = 10
```

## Evaluation Criteria

### Assumptions and Requirements

- Assume the value of an item is an integer and divisible by the number of individuals that consumed it. The objective of this restriction is to avoid having to deal with rounding in the code. Optionally, you may choose to support indivisible values. If you decide to do so, please clearly indicate that option when submitting your solution.
- The order for which each name should appear in the output is not defined. In other words, it's not necessary to sort the output by name, value or any other criterion.
- The value of an item can be zero, or negative. This type of item can be use to represent a discount in the check.
- The program output should not return the names of individuals that don't have to pay anything in the specified check.
- A single test case is provided, to illustrate the example in the previous section. You're encouraged to evolve this test or add more test cases, as you deem appropriate.

### Relevant Aspects

The following aspects of the solution will be considering when evaluating a submission:

- The correctness of the implementation
- If the solution accounts for all requirements
- Solution design an application of object-oriented principles
- Readability of the source code
- Performance of the algorithm


## Building the Project

This project includes a [Gradle](https://gradle.org) build script that can be used to compile the code and run the tests. You will need a Java Development Kit 8 or newer installed and a `JAVA_HOME` variable pointing to this installation. 

It's *not* necessary to install Gradle to build this project. The [gradlew](./gradlew) (for Mac and Linux) and [gradlew.bat](./gradlew.bat) (for Windows) scripts can be be used to run the builds without a pre-existing local installation.

This project requires a connection to the Internet to download build dependencies.