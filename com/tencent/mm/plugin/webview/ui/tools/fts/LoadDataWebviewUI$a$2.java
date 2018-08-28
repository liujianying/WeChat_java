package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

class LoadDataWebviewUI$a$2 implements Runnable {
    final /* synthetic */ WebView qeK;
    final /* synthetic */ a qeM;
    final /* synthetic */ String val$url;

    LoadDataWebviewUI$a$2(a aVar, WebView webView, String str) {
        this.qeM = aVar;
        this.qeK = webView;
        this.val$url = str;
    }

    public final void run() {
        try {
            LoadDataWebviewUI.a(this.qeM.qeJ).await();
        } catch (Throwable e) {
            x.printErrStackTrace("LoadDataWebviewUI", e, null, new Object[0]);
        }
        ah.A(new 1(this));
    }
}
