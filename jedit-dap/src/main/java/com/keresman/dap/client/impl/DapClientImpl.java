package com.keresman.dap.client.impl;

import com.keresman.dap.events.DebugEventBus;
import org.eclipse.lsp4j.debug.BreakpointEventArguments;
import org.eclipse.lsp4j.debug.ContinuedEventArguments;
import org.eclipse.lsp4j.debug.ExitedEventArguments;
import org.eclipse.lsp4j.debug.OutputEventArguments;
import org.eclipse.lsp4j.debug.StoppedEventArguments;
import org.eclipse.lsp4j.debug.TerminatedEventArguments;
import org.eclipse.lsp4j.debug.ThreadEventArguments;
import org.eclipse.lsp4j.debug.services.IDebugProtocolClient;

public class DapClientImpl implements IDebugProtocolClient {

  private final DebugEventBus eventBus;

  public DapClientImpl(DebugEventBus eventBus) {
    this.eventBus = eventBus;
  }

  @Override
  public void initialized() {
    eventBus.onInitialized();
  }

  @Override
  public void stopped(StoppedEventArguments params) {
    eventBus.onStopped(params);
  }

  @Override
  public void continued(ContinuedEventArguments params) {
    eventBus.onContinued(params);
  }

  @Override
  public void exited(ExitedEventArguments params) {
    eventBus.onExited(params);
  }

  @Override
  public void terminated(TerminatedEventArguments params) {
    eventBus.onTerminated(params);
  }

  @Override
  public void output(OutputEventArguments params) {
    eventBus.onOutput(params);
  }

  @Override
  public void breakpoint(BreakpointEventArguments params) {
    eventBus.onBreakpoint(params);
  }

  @Override
  public void thread(ThreadEventArguments params) {
    eventBus.onThread(params);
  }
}
