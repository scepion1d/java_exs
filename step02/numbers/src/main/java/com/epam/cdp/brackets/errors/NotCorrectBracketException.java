package com.epam.cdp.brackets.errors;

public class NotCorrectBracketException extends RuntimeException {
    public NotCorrectBracketException(String expectedBracket) {
        super(String.format("Expected %s", expectedBracket));
    }
}
