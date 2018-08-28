package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;

class h$2 implements Runnable {
    final /* synthetic */ String fwv;
    final /* synthetic */ h pPj;
    final /* synthetic */ int pPk;
    final /* synthetic */ String pPl;
    final /* synthetic */ boolean pPm;

    h$2(h hVar, int i, String str, String str2, boolean z) {
        this.pPj = hVar;
        this.pPk = i;
        this.pPl = str;
        this.fwv = str2;
        this.pPm = z;
    }

    public final void run() {
        if (h.a(this.pPj) != null) {
            x.i("MicroMsg.TopStory.RecommendLogic", "waiting for countdown, %d", new Object[]{Long.valueOf(h.a(this.pPj).getCount())});
            try {
                h.a(this.pPj).await();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TopStory.RecommendLogic", e, "", new Object[0]);
            }
        } else {
            x.i("MicroMsg.TopStory.RecommendLogic", "count down latch null");
        }
        int i = this.pPk;
        if (h.b(this.pPj) != null) {
            i = h.b(this.pPj).bWo;
            if (h.b(this.pPj).pLh && h.c(this.pPj)) {
                x.w("MicroMsg.TopStory.RecommendLogic", "ingore pre get data");
                return;
            }
        }
        x.i("MicroMsg.TopStory.RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[]{Integer.valueOf(i), this.pPl, h.b(this.pPj)});
        h.Bh(i).a(this.fwv, this.pPm, this.pPl, null);
    }
}
