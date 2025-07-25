package com.keresman.jlang.highlight;

import com.keresman.jlang.lexer.Lexer;
import com.keresman.jlang.lexer.Token;
import java.awt.Color;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class SyntaxHighlighter {

  private final JTextPane editor;

  public SyntaxHighlighter(JTextPane editor) {
    this.editor = editor;
  }

  public void highlight(String sourceCode) {
    StyledDocument doc = editor.getStyledDocument();
    doc.setCharacterAttributes(0, doc.getLength(), defaultStyle(), true);

    List<Token> tokens = new Lexer(sourceCode).tokenize();
    int offset = 0;

    for (Token token : tokens) {
      SimpleAttributeSet style =
          switch (token.type()) {
            case INTERFACE, STRUCT, VOID, VAR, IF, ELSE, RETURN, INT32 -> keywordStyle();
            case IDENTIFIER -> identifierStyle();
            case STRING_LITERAL -> stringStyle();
            case NUMBER_LITERAL -> numberStyle();
            case EQUAL_EQUAL, NOT_EQUAL, ARROW -> operatorStyle();
            case L_BRACE, R_BRACE, L_PAREN, R_PAREN, SEMICOLON, COMMA -> punctuationStyle();
            default -> defaultStyle();
          };

      doc.setCharacterAttributes(offset, token.lexeme().length(), style, true);
      offset += token.lexeme().length();
    }
  }

  private SimpleAttributeSet keywordStyle() {
    return style(Color.BLUE, true);
  }

  private SimpleAttributeSet identifierStyle() {
    return style(Color.BLACK, false);
  }

  private SimpleAttributeSet numberStyle() {
    return style(new Color(128, 0, 128), false);
  }

  private SimpleAttributeSet stringStyle() {
    return style(new Color(0, 128, 0), false);
  }

  private SimpleAttributeSet operatorStyle() {
    return style(Color.RED, false);
  }

  private SimpleAttributeSet punctuationStyle() {
    return style(Color.GRAY, false);
  }

  private SimpleAttributeSet defaultStyle() {
    return style(Color.BLACK, false);
  }

  private SimpleAttributeSet style(Color color, boolean bold) {
    SimpleAttributeSet attrs = new SimpleAttributeSet();
    StyleConstants.setForeground(attrs, color);
    StyleConstants.setBold(attrs, bold);
    return attrs;
  }
}
