package com.keresman.jlang.lexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Lexer {

    private static final Map<String, TokenType> KEYWORDS = Map.ofEntries(
            Map.entry("interface", TokenType.INTERFACE),
            Map.entry("struct", TokenType.STRUCT),
            Map.entry("void", TokenType.VOID),
            Map.entry("int32", TokenType.INT32),
            Map.entry("var", TokenType.VAR),
            Map.entry("if", TokenType.IF),
            Map.entry("else", TokenType.ELSE),
            Map.entry("return", TokenType.RETURN)
    );

    private final String source;
    private final List<Token> tokens = new ArrayList<>();

    private int start = 0;
    private int current = 0;
    private int line = 1;

    public Lexer(String source) {
        this.source = source;
    }

    public List<Token> tokenize() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }

        tokens.add(new Token(TokenType.EOF, "", line));
        return tokens;
    }

    private void scanToken() {
        skipWhitespace();

        if (isAtEnd()) {
            return;
        }

        char c = advance();

        switch (c) {
            case '{' ->
                addToken(TokenType.L_BRACE);
            case '}' ->
                addToken(TokenType.R_BRACE);
            case '(' ->
                addToken(TokenType.L_PAREN);
            case ')' ->
                addToken(TokenType.R_PAREN);
            case ';' ->
                addToken(TokenType.SEMICOLON);
            case ',' ->
                addToken(TokenType.COMMA);
            case '.' ->
                addToken(TokenType.DOT);
            case '*' ->
                addToken(TokenType.STAR);
            case '=' ->
                addToken(match('=') ? TokenType.EQUAL_EQUAL : TokenType.EQUAL);
            case '!' ->
                addToken(match('=') ? TokenType.NOT_EQUAL : TokenType.UNKNOWN);
            case '<' ->
                addToken(TokenType.LESS);
            case '>' ->
                addToken(TokenType.GREATER);
            case '-' ->
                addToken(match('>') ? TokenType.ARROW : TokenType.UNKNOWN);
            case '"' ->
                addStringLiteral();
            default -> {
                if (Character.isDigit(c)) {
                    addNumber();
                } else if (Character.isLetter(c) || c == '_') {
                    addIdentifier();
                } else {
                    addToken(TokenType.UNKNOWN);
                }
            }
        }
    }

    private void skipWhitespace() {
        while (!isAtEnd()) {
            char c = peek();
            if (c == ' ' || c == '\r' || c == '\t') {
                advance();
            } else if (c == '\n') {
                line++;
                advance();
            } else {
                break;
            }
        }
    }

    private void addIdentifier() {
        while (Character.isLetterOrDigit(peek()) || peek() == '_') {
            advance();
        }
        String text = source.substring(start, current);
        TokenType type = KEYWORDS.getOrDefault(text, TokenType.IDENTIFIER);
        addToken(type);
    }

    private void addNumber() {
        while (Character.isDigit(peek())) {
            advance();
        }
        addToken(TokenType.NUMBER_LITERAL);
    }

    private void addStringLiteral() {
        while (peek() != '"' && !isAtEnd()) {
            if (peek() == '\n') {
                line++;
            }
            advance();
        }

        if (isAtEnd()) {
            return;
        }

        advance();
        String value = source.substring(start + 1, current - 1);
        tokens.add(new Token(TokenType.STRING_LITERAL, value, line));
    }

    private char advance() {
        return source.charAt(current++);
    }

    private boolean match(char expected) {
        if (isAtEnd() || source.charAt(current) != expected) {
            return false;
        }
        current++;
        return true;
    }

    private char peek() {
        return isAtEnd() ? '\0' : source.charAt(current);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private void addToken(TokenType type) {
        String lexeme = source.substring(start, current);
        tokens.add(new Token(type, lexeme, line));
    }
}
