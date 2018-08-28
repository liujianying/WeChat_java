package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

class LoadDataWebviewUI$a$1 implements Runnable {
    final /* synthetic */ WebView qeK;
    final /* synthetic */ Bitmap qeL;
    final /* synthetic */ a qeM;
    final /* synthetic */ String val$url;

    LoadDataWebviewUI$a$1(a aVar, WebView webView, String str, Bitmap bitmap) {
        this.qeM = aVar;
        this.qeK = webView;
        this.val$url = str;
        this.qeL = bitmap;
    }

    public final void run() {
        try {
            LoadDataWebviewUI.a(this.qeM.qeJ).await();
        } catch (Throwable e) {
            x.printErrStackTrace("LoadDataWebviewUI", e, "", new Object[0]);
        }
        ah.A(new 1(this));
    }
}
