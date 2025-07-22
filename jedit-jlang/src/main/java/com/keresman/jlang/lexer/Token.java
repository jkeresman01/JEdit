package com.keresman.jlang.lexer;

public record Token(
        TokenType type,
        String lexeme,
        int line) {

    @Override
    public String toString() {
        return type + " -> \"" + lexeme + "\" (line " + line + ")";
    }
}
