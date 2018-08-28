package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsError;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import java.net.URL;

class JsVirtualMachine$a implements IX5JsContext {
    private WebView a;

    public JsVirtualMachine$a(Context context) {
        this.a = new WebView(context);
        this.a.getSettings().setJavaScriptEnabled(true);
    }

    public void a() {
        if (this.a != null) {
            this.a.onPause();
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        if (this.a != null) {
            this.a.addJavascriptInterface(obj, str);
            this.a.loadUrl("about:blank");
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.onResume();
        }
    }

    public void destroy() {
        if (this.a != null) {
            this.a.clearHistory();
            this.a.clearCache(true);
            this.a.loadUrl("about:blank");
            this.a.freeMemory();
            this.a.pauseTimers();
            this.a.destroy();
            this.a = null;
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback, URL url) {
        if (this.a != null) {
            this.a.evaluateJavascript(str, valueCallback == null ? null : new e(this, valueCallback));
        }
    }

    public IX5JsValue evaluateScript(String str, URL url) {
        if (this.a != null) {
            this.a.evaluateJavascript(str, null);
        }
        return null;
    }

    public void evaluateScriptAsync(String str, ValueCallback<IX5JsValue> valueCallback, URL url) {
        if (this.a != null) {
            this.a.evaluateJavascript(str, valueCallback == null ? null : new f(this, valueCallback));
        }
    }

    public void removeJavascriptInterface(String str) {
        if (this.a != null) {
            this.a.removeJavascriptInterface(str);
        }
    }

    public void setExceptionHandler(ValueCallback<IX5JsError> valueCallback) {
    }

    public void setName(String str) {
    }

    public void setPerContextData(Object obj) {
    }

    public void stealValueFromOtherCtx(String str, IX5JsContext iX5JsContext, String str2) {
    }
}
