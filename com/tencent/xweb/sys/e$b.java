package com.tencent.xweb.sys;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import java.util.HashMap;

public class e$b {
    HashMap<String, ValueCallback<String>> vDk = new HashMap();
    int vDl = 0;

    @JavascriptInterface
    public final void notifyJava(String str, String str2) {
        ValueCallback valueCallback = (ValueCallback) this.vDk.get(str);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(str2);
            this.vDk.remove(str);
        }
    }
}
