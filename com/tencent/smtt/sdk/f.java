package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;

class f implements ValueCallback<String> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ JsVirtualMachine$a b;

    f(JsVirtualMachine$a jsVirtualMachine$a, ValueCallback valueCallback) {
        this.b = jsVirtualMachine$a;
        this.a = valueCallback;
    }

    /* renamed from: a */
    public void onReceiveValue(String str) {
        this.a.onReceiveValue(null);
    }
}
