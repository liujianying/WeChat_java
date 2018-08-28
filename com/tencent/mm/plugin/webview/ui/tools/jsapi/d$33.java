package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class d$33 implements ValueCallback<String> {
    final /* synthetic */ d qhD;

    d$33(d dVar) {
        this.qhD = dVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.JsApiHandler", "sys:bridged back %s\t", new Object[]{(String) obj});
    }
}
