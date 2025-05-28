<div align="center">

  <img src="https://raw.githubusercontent.com/github/explore/main/topics/java/java.png" height="100" alt="Java Logo" />

  <h1>JEdit</h1>
  <h3>!!!!!!! Not baked yet !!!!!!!</h3>
  <h6>---> Random simple not working editor....<---</h6>

  ![Work In Progress](https://img.shields.io/badge/Work%20In%20Progress-orange?style=for-the-badge)
  ![Java](https://img.shields.io/badge/Java-17+-blue?style=for-the-badge&logo=java)
  ![Work In Progress](https://img.shields.io/badge/Work%20In%20Progress-orange?style=for-the-badge)

  <img src="https://cdn-icons-png.flaticon.com/512/1076/1076742.png" width="100" alt="Under Construction Icon"/>

  <h4>#### WORK IN PROGRESSSSSSS ####</h4>
  <h4>#### UNDER CONSTRUCTION ####</h4>

  -----------------------------------------------------------------------------------------

</div>
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

