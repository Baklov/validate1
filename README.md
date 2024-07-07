# Power Partner Solutions
 
Assignment
 
Basic Task: Implement a REST service that receives a string representing an arithmetic expression and validates if the expression is a valid one or not (e.g., “11+1.2*3”).
Requirements
    • Operands are positive real numbers (e.g., 1, 3.14, 1234). 
    • Supported operations are “+”, “-”, “*” and “/”.
    • Space characters are allowed only between an operand and operation
    • The actual validation logic should be done by the application itself, not by using some library
 
Extended Task: The program should also support validating expressions containing parentheses.
Additional Requirements
    • Opening and closing parentheses are allowed - “(“ and “)”.
    • Nesting of parenthesis is allowed
 
 
 
# Examples:
    • Basic Task
        ◦ Valid expressions:
            ▪ 1
            ▪ 1.2 + 3
            ▪ 1234.56 – 543 * 2 + 11.99
        ◦ Invalid expressions:
            ▪ Any expression containing invalid characters
            ▪ 1+
            ▪ 23.
            ▪ 1 2+3 – (there’s an interval between “1” and “2”)
    • Extended Task
        ◦ Valid expressions
            ▪ All expressions that are valid for the basic task, are also valid for the extended one.
            ▪ (1)
            ▪ (1 + 2)
            ▪  ((1 - 2) * (1 + 2) - 3) / 4
        ◦ Invalid expressions
            ▪ ()
            ▪ (1 + 2 
            ▪ 1 (2 - 3)
    • The list of valid and invalid examples is not exhaustive, i.e., follow the common mathematical rules to determine if a given expression is valid or not.
 
  
# Solution Rating
 
The rating of the solution given would be done by these prioritized requirements:
    1. Functional correctness
    2. Automated tests correctness/completeness
    3. Clean code
    4. Performance
 
Notes
    • А fully working/tested/clean/performant solution of the Basic Task is considered higher rated, than a partial one of the Extended Task.
    • Implement your solution without using regular expressions.
    • Use maven/gradle for build/dependencies management.
    • Implement the task(s) with a quality as if they were on the job ones 
        ◦ Follow the REST APIs best practices you know (HTTP methods, request/response types, status codes, etc.)
        ◦ Do all the tests needed to ensure solution quality (unit, component, integration tests, whatever you believe is needed)
        ◦ Follow all the SOLID/Clean code/Clean design principles, that, you think, are applicable
        ◦ Think of proper classes, interfaces, and exceptions design
        ◦ etc.

 # Grammar for Arithmetic Expression
 
     <ArithmeticExpression> ::= <Term> | <Term> "+" <ArithmeticExpression> | <Term> "-" <ArithmeticExpression>
     <Term> ::= <Factor> | <Factor> "*" <Term> | <Factor> "/" <Term>
     <Factor> ::= <Number> | "(" <ArithmeticExpression> ")"
     <Number> ::= <Integer> | <Decimal>
     <Integer> ::= <Digit> | <Digit> <Integer>
     <Decimal> ::= <Integer> "." <Integer>
     <Digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
     
     <Whitespace> ::= " " | <Whitespace> <Whitespace>

 
