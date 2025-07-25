package com.keresman.dap.events;

import org.eclipse.lsp4j.debug.BreakpointEventArguments;
import org.eclipse.lsp4j.debug.CapabilitiesEventArguments;
import org.eclipse.lsp4j.debug.ContinuedEventArguments;
import org.eclipse.lsp4j.debug.ExitedEventArguments;
import org.eclipse.lsp4j.debug.InvalidatedEventArguments;
import org.eclipse.lsp4j.debug.LoadedSourceEventArguments;
import org.eclipse.lsp4j.debug.MemoryEventArguments;
import org.eclipse.lsp4j.debug.OutputEventArguments;
import org.eclipse.lsp4j.debug.ProcessEventArguments;
import org.eclipse.lsp4j.debug.ProgressEndEventArguments;
import org.eclipse.lsp4j.debug.ProgressStartEventArguments;
import org.eclipse.lsp4j.debug.ProgressUpdateEventArguments;
import org.eclipse.lsp4j.debug.StoppedEventArguments;
import org.eclipse.lsp4j.debug.TerminatedEventArguments;
import org.eclipse.lsp4j.debug.ThreadEventArguments;

public interface DebugEventBus {

  void onOutput(OutputEventArguments args);

  void onInitialized();

  void onStopped(StoppedEventArguments args);

  void onContinued(ContinuedEventArguments args);

  void onExited(ExitedEventArguments args);

  void onTerminated(TerminatedEventArguments args);

  void onThread(ThreadEventArguments args);

  void onBreakpoint(BreakpointEventArguments args);

  void onLoadedSource(LoadedSourceEventArguments args);

  void onProcess(ProcessEventArguments args);

  void onCapabilities(CapabilitiesEventArguments args);

  void onInvalidated(InvalidatedEventArguments args);

  void onMemory(MemoryEventArguments args);

  void onProgressStart(ProgressStartEventArguments args);

  void onProgressUpdate(ProgressUpdateEventArguments args);

  void onProgressEnd(ProgressEndEventArguments args);
}
