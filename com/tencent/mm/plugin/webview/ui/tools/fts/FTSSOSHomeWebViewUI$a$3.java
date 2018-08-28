package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import java.util.List;

class FTSSOSHomeWebViewUI$a$3 implements Runnable {
    final /* synthetic */ List qev;
    final /* synthetic */ a qew;

    FTSSOSHomeWebViewUI$a$3(a aVar, List list) {
        this.qew = aVar;
        this.qev = list;
    }

    public final void run() {
        for (c cVar : this.qev) {
            if (!a.a(this.qew).contains(cVar)) {
                a.a(this.qew).add(cVar);
            }
        }
        this.qew.notifyDataSetChanged();
    }
}
