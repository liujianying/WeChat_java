package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;

class FTSSOSHomeWebViewUI$a$2 implements Runnable {
    final /* synthetic */ a qew;
    final /* synthetic */ c qex;

    FTSSOSHomeWebViewUI$a$2(a aVar, c cVar) {
        this.qew = aVar;
        this.qex = cVar;
    }

    public final void run() {
        a.a(this.qew).remove(this.qex);
        this.qew.notifyDataSetChanged();
    }
}
