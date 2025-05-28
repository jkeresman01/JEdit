# JEdit

Simple Java-based code editor with toy Language Server Protocol (LSP) and Debug Adapter Protocol (DAP) integration.


## Project structure:

```
JEdit/                                    # Maven aggregator
├── Components/                           # Reusable components
|
├── DAP/                                  # Debug Adapter Protocol integration
│   ├── client/                           # DAP client implementations
│   ├── events/                           # Debug event bus interface
│   ├── DapClientManager.java
│   └── DapConnector.java
|
├── Editor/                               # Main GUI application
│   ├── listeners/                        # Editor event/document listeners
│   ├── events/                           # Editor-side event bus implementation
│   ├── model/                            # Models
│   └── view/
│       ├── app/                          # Main application container (EditorManager)
│       ├── edit/                         # Code editor (EditorPanel)
│       ├── projects/                     # File tree (projects tab)
│       └── welcome/                      # Welcome screen panel
|
├── Jlang/                                # Language-specific logic (lexer, tokens, highlighting)
│   ├── lexer/                            # Token, TokenType, Lexer
│   └── highlight/                        # SyntaxHighlighter
|
├── LSP/                                  # Language Server Protocol integration
│   ├── client/                           # LSP client implementation
│   ├── events/                           # Editor event bus interface
│   ├── listeners/                        # LSP document listener
│   ├── LSPConnector.java
│   └── LspClientManager.java
|
├── Utilities/                            # Shared utilities
│   ├── enums/                            # Constants and enums
│   ├── exceptions/                       # Custom exception interfaces
│   ├── utilities/                        # Utilities
│   └── visitors/                         # Visitors
|
├── LICENSE
├── pom.xml                               # Parent Maven POM
└── README.md
```
