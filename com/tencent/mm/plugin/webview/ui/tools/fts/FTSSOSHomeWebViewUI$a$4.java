package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;

class FTSSOSHomeWebViewUI$a$4 implements Runnable {
    final /* synthetic */ a qew;

    FTSSOSHomeWebViewUI$a$4(a aVar) {
        this.qew = aVar;
    }

    public final void run() {
        a.a(this.qew).clear();
        this.qew.notifyDataSetChanged();
    }
}
