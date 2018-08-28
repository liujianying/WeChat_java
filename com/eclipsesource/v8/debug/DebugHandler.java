package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    /* renamed from: com.eclipsesource.v8.debug.DebugHandler$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent = new int[DebugEvent.values().length];

        static {
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.Break.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.BeforeCompile.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.AfterCompile.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$eclipsesource$v8$debug$DebugHandler$DebugEvent[DebugEvent.Exception.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public DebugHandler(V8 v8) {
        this.runtime = v8;
        setupDebugObject(v8);
        setupBreakpointHandler();
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
    }

    public int setBreakpoint(V8Function v8Function) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
        }
    }

    public int setScriptBreakpoint(String str, int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
        }
    }

    public void enableScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void clearBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableAllBreakPoints() {
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
    }

    public int getScriptBreakPointCount() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            int length = executeArrayFunction.length();
            return length;
        } finally {
            executeArrayFunction.release();
        }
    }

    public int[] getScriptBreakPointIDs() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        V8Object object;
        try {
            int[] iArr = new int[executeArrayFunction.length()];
            for (int i = 0; i < executeArrayFunction.length(); i++) {
                object = executeArrayFunction.getObject(i);
                iArr[i] = object.executeIntegerFunction(NUMBER, null);
                object.release();
            }
            executeArrayFunction.release();
            return iArr;
        } catch (Throwable th) {
            executeArrayFunction.release();
        }
    }

    public ScriptBreakPoint getScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            ScriptBreakPoint scriptBreakPoint = new ScriptBreakPoint(v8Object);
            return scriptBreakPoint;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public void changeBreakPointCondition(int i, String str) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void release() {
        this.debugObject.release();
    }

    private void setupDebugObject(V8 v8) {
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
        } finally {
            object.release();
        }
    }

    private void setupBreakpointHandler() {
        Throwable th;
        V8Function v8Function;
        this.debugObject.registerJavaMethod(new BreakpointHandler(this, null), DEBUG_BREAK_HANDLER);
        V8Array push;
        try {
            V8Value v8Value = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                push = new V8Array(this.runtime).push(v8Value);
            } catch (Throwable th2) {
                th = th2;
                push = null;
                v8Function = v8Value;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, push);
                if (!(v8Value == null || v8Value.isReleased())) {
                    v8Value.release();
                }
                if (push != null && !push.isReleased()) {
                    push.release();
                }
            } catch (Throwable th3) {
                th = th3;
                v8Function = v8Value;
                if (!(v8Function == null || v8Function.isReleased())) {
                    v8Function.release();
                }
                if (!(push == null || push.isReleased())) {
                    push.release();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            push = null;
            v8Function = null;
            v8Function.release();
            push.release();
            throw th;
        }
    }
}
