package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class g$71 implements Runnable {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ WebViewJSSDKFileItem qjD;

    g$71(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem, i iVar) {
        this.qiK = gVar;
        this.qjD = webViewJSSDKFileItem;
        this.qiH = iVar;
    }

    public final void run() {
        ff ffVar = new ff();
        ffVar.bNp.op = 1;
        ffVar.bNp.filePath = this.qjD.fnM;
        ffVar.bNp.duration = bi.getInt((String) this.qiH.mcy.get("duration"), 60);
        ffVar.bNp.bBe = new 1(this, ffVar);
        a.sFg.m(ffVar);
    }
}
