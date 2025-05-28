package com.keresman.dap;

public class DapConnector {

//    private DebugProtocolServer server;
//
//    public void connect(String command, String... args) throws IOException {
//        Process process = new ProcessBuilder(command, args).start();
//
//        InputStream in = process.getInputStream();
//        OutputStream out = process.getOutputStream();
//
//        DAPLauncher<DebugProtocolClient> launcher = DAPLauncher.createClientLauncher(
//                new DapClientImpl(), in, out
//        );
//
//        this.server = launcher.getRemoteProxy();
//        launcher.startListening();
//    }
//
//    public DebugProtocolServer getServer() {
//        return server;
//    }
}
