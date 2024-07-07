package com.gram.validate;

import com.gram.validate.service.ExpressionValidatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ArithmeticExpressionValidationTest {

    @Autowired
    private ExpressionValidatorService validatorService;

    @Test
    void testValidExpressions() {
        // Basic arithmetic expressions
        assertTrue(validatorService.validate("1"));
        assertTrue(validatorService.validate("-1"));
        assertTrue(validatorService.validate(" +1 "));
        assertTrue(validatorService.validate("1 + 2"));
        assertTrue(validatorService.validate("1 + 2 * 3 -1 /5"));
        assertTrue(validatorService.validate("1234.56789 - 543.21 * 2.1 + 11.99"));

        // Parentheses and whitespace variations
        assertTrue(validatorService.validate("(1 + 2)"));
        assertTrue(validatorService.validate("(((1 + 2)))"));
        assertTrue(validatorService.validate(" ( (   ( 1   +   2 ))    )"));

        // Complex expressions
        assertTrue(validatorService.validate("((1 - 2) * (1 + 2) - 3) / 4"));
        assertTrue(validatorService.validate("(   1 + 2)* ( (    ( 3-4 *((11.99))  )  )) /4.4   "));
        assertTrue(validatorService.validate("   (   1 + 2)* (  3-4    )   "));
    }

    @Test
    void testInvalidExpressions() {
        // Invalid characters and syntax errors
        assertFalse(validatorService.validate("+"));
        assertFalse(validatorService.validate(" + -"));
        assertFalse(validatorService.validate(" +-"));

        // Invalid usage of decimal points
        assertFalse(validatorService.validate("."));
        assertFalse(validatorService.validate(" .. "));
        assertFalse(validatorService.validate(". . ."));

        // Invalid parentheses and whitespace errors
        assertFalse(validatorService.validate("()"));
        assertFalse(validatorService.validate("(   )"));
        assertFalse(validatorService.validate(" (   ) "));
        assertFalse(validatorService.validate(" ( ( ) ) "));

        // Invalid decimal points and numbers
        assertFalse(validatorService.validate("*1"));
        assertFalse(validatorService.validate("23."));
        assertFalse(validatorService.validate("12 ."));
        assertFalse(validatorService.validate("1. + 2"));
        assertFalse(validatorService.validate("1.2.3 + 4"));

        // Invalid spaces and operators
        assertFalse(validatorService.validate("1 2+3"));
        assertFalse(validatorService.validate("1 2 + 3"));
        assertFalse(validatorService.validate("1 (2 - 3)"));
        assertFalse(validatorService.validate("1 2"));

        assertFalse(validatorService.validate("1+"));
        assertFalse(validatorService.validate("1 + 2 +"));
        assertFalse(validatorService.validate("(1 + 2"));
        assertFalse(validatorService.validate("1 + 2)"));

        // Invalid characters and symbols
        assertFalse(validatorService.validate(" 1 + @"));

        // Mixed invalid expressions with nested and whitespace
        assertFalse(validatorService.validate("(   1 + 2)* (  3-4 *((11.99)   )   "));
        assertFalse(validatorService.validate("  ( (   1 + 2)* (  3-4    )   "));
    }

}
