package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;

class g$72 implements Runnable {
    final /* synthetic */ g qiK;
    final /* synthetic */ WebViewJSSDKFileItem qjD;

    public g$72(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem) {
        this.qiK = gVar;
        this.qjD = webViewJSSDKFileItem;
    }

    public final void run() {
        ff ffVar = new ff();
        ffVar.bNp.op = 2;
        ffVar.bNp.filePath = this.qjD.fnM;
        a.sFg.m(ffVar);
        g.C(this.qiK);
    }
}
