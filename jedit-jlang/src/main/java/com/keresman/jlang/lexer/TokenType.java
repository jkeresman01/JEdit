package com.keresman.jlang.lexer;


public enum TokenType {
    INTERFACE,
    STRUCT, 
    VOID, 
    INT32, 
    VAR,
    IF, 
    ELSE, 
    RETURN,
    IDENTIFIER, 
    NUMBER_LITERAL, 
    STRING_LITERAL,
    L_BRACE, 
    R_BRACE, 
    L_PAREN, 
    R_PAREN, 
    SEMICOLON, 
    COMMA,
    DOT,
    STAR,
    EQUAL,
    EQUAL_EQUAL, 
    NOT_EQUAL, 
    LESS, 
    GREATER, 
    ARROW,
    EOF, 
    UNKNOWN
}
