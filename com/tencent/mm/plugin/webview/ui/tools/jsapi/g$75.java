package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.fc;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;

class g$75 implements Runnable {
    final /* synthetic */ g qiK;
    final /* synthetic */ WebViewJSSDKFileItem qjD;

    g$75(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem) {
        this.qiK = gVar;
        this.qjD = webViewJSSDKFileItem;
    }

    public final void run() {
        fc fcVar = new fc();
        fcVar.bNi.op = 2;
        fcVar.bNi.fileName = this.qjD.fileName;
        a.sFg.m(fcVar);
    }
}
