package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.debug.DebugHandler.1;
import com.eclipsesource.v8.debug.DebugHandler.DebugEvent;

class DebugHandler$BreakpointHandler implements JavaVoidCallback {
    final /* synthetic */ DebugHandler this$0;

    private DebugHandler$BreakpointHandler(DebugHandler debugHandler) {
        this.this$0 = debugHandler;
    }

    public void invoke(V8Object v8Object, V8Array v8Array) {
        if (v8Array != null && !v8Array.isUndefined()) {
            int integer = v8Array.getInteger(0);
            for (BreakHandler invokeHandler : DebugHandler.access$100(this.this$0)) {
                invokeHandler(v8Array, integer, invokeHandler);
            }
        }
    }

    private void invokeHandler(V8Array v8Array, int i, BreakHandler breakHandler) {
        Releasable object;
        Releasable object2;
        Releasable object3;
        Throwable th;
        Releasable releasable;
        Releasable releasable2;
        try {
            object = v8Array.getObject(1);
            try {
                object2 = v8Array.getObject(2);
                try {
                    object3 = v8Array.getObject(3);
                } catch (Throwable th2) {
                    th = th2;
                    releasable = null;
                    releasable2 = null;
                    object3 = null;
                }
            } catch (Throwable th3) {
                th = th3;
                releasable = null;
                releasable2 = null;
                object3 = null;
                object2 = null;
                safeRelease(object);
                safeRelease(object2);
                safeRelease(object3);
                safeRelease(releasable2);
                safeRelease(releasable);
                throw th;
            }
            try {
                releasable2 = new ExecutionState(object);
                try {
                    DebugEvent debugEvent = DebugEvent.values()[i];
                    releasable = createDebugEvent(debugEvent, object2);
                    try {
                        breakHandler.onBreak(debugEvent, releasable2, releasable, object3);
                        safeRelease(object);
                        safeRelease(object2);
                        safeRelease(object3);
                        safeRelease(releasable2);
                        safeRelease(releasable);
                    } catch (Throwable th4) {
                        th = th4;
                        safeRelease(object);
                        safeRelease(object2);
                        safeRelease(object3);
                        safeRelease(releasable2);
                        safeRelease(releasable);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    releasable = null;
                }
            } catch (Throwable th6) {
                th = th6;
                releasable = null;
                releasable2 = null;
                safeRelease(object);
                safeRelease(object2);
                safeRelease(object3);
                safeRelease(releasable2);
                safeRelease(releasable);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            releasable = null;
            releasable2 = null;
            object3 = null;
            object2 = null;
            object = null;
            safeRelease(object);
            safeRelease(object2);
            safeRelease(object3);
            safeRelease(releasable2);
            safeRelease(releasable);
            throw th;
        }
    }

    private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
        switch (1.$SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[debugEvent.ordinal()]) {
            case 1:
                return new BreakEvent(v8Object);
            case 2:
                return new CompileEvent(v8Object);
            case 3:
                return new CompileEvent(v8Object);
            case 4:
                return new ExceptionEvent(v8Object);
            default:
                return new EventData(v8Object);
        }
    }

    private void safeRelease(Releasable releasable) {
        if (releasable != null) {
            releasable.release();
        }
    }
}
