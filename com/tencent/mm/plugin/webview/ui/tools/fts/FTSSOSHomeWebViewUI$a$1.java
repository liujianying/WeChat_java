package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.a;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import java.util.List;

class FTSSOSHomeWebViewUI$a$1 implements Runnable {
    final /* synthetic */ List qev;
    final /* synthetic */ a qew;

    FTSSOSHomeWebViewUI$a$1(a aVar, List list) {
        this.qew = aVar;
        this.qev = list;
    }

    public final void run() {
        if (a.a(this.qew).size() > 0) {
            for (c cVar : a.a(this.qew)) {
                if (!this.qev.contains(cVar)) {
                    this.qev.add(cVar);
                }
            }
        }
        a.a(this.qew, this.qev);
        this.qew.notifyDataSetChanged();
    }
}
