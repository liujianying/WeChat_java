package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import com.tencent.smtt.sdk.JsVirtualMachine.a;

class e implements ValueCallback<String> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ a b;

    e(a aVar, ValueCallback valueCallback) {
        this.b = aVar;
        this.a = valueCallback;
    }

    /* renamed from: a */
    public void onReceiveValue(String str) {
        this.a.onReceiveValue(str);
    }
}
