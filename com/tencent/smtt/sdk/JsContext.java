package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

public final class JsContext {
    private final JsVirtualMachine a;
    private final IX5JsContext b;
    private ExceptionHandler c;
    private String d;

    public JsContext(Context context) {
        this(new JsVirtualMachine(context));
    }

    public JsContext(JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine == null) {
            throw new IllegalArgumentException("The virtualMachine value can not be null");
        }
        this.a = jsVirtualMachine;
        this.b = this.a.a();
        try {
            this.b.setPerContextData(this);
        } catch (AbstractMethodError e) {
        }
    }

    public static JsContext current() {
        return (JsContext) X5JsCore.a();
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.b.addJavascriptInterface(obj, str);
    }

    public final void destroy() {
        this.b.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        this.b.evaluateJavascript(str, valueCallback, url);
    }

    public final JsValue evaluateScript(String str) {
        return evaluateScript(str, null);
    }

    public final JsValue evaluateScript(String str, URL url) {
        IX5JsValue evaluateScript = this.b.evaluateScript(str, url);
        return evaluateScript == null ? null : new JsValue(this, evaluateScript);
    }

    public final void evaluateScriptAsync(String str, ValueCallback<JsValue> valueCallback, URL url) {
        this.b.evaluateScriptAsync(str, valueCallback == null ? null : new c(this, valueCallback), url);
    }

    public final ExceptionHandler exceptionHandler() {
        return this.c;
    }

    public final String name() {
        return this.d;
    }

    public final void removeJavascriptInterface(String str) {
        this.b.removeJavascriptInterface(str);
    }

    public final void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.c = exceptionHandler;
        if (exceptionHandler == null) {
            this.b.setExceptionHandler(null);
        } else {
            this.b.setExceptionHandler(new d(this));
        }
    }

    public final void setName(String str) {
        this.d = str;
        this.b.setName(str);
    }

    public final void stealValueFromOtherCtx(String str, JsContext jsContext, String str2) {
        this.b.stealValueFromOtherCtx(str, jsContext.b, str2);
    }

    public final JsVirtualMachine virtualMachine() {
        return this.a;
    }
}
