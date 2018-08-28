package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;

class i$4 implements Runnable {
    final /* synthetic */ Bundle fuf;
    final /* synthetic */ String fwv;
    final /* synthetic */ int pPk;
    final /* synthetic */ String pPl;
    final /* synthetic */ boolean pPm;
    final /* synthetic */ i pPx;

    i$4(i iVar, int i, String str, String str2, boolean z, Bundle bundle) {
        this.pPx = iVar;
        this.pPk = i;
        this.pPl = str;
        this.fwv = str2;
        this.pPm = z;
        this.fuf = bundle;
    }

    public final void run() {
        if (i.b(this.pPx) != null) {
            x.i("MicroMsg.FTS.WebSearchLogic", "waiting for countdown, %d", new Object[]{Long.valueOf(i.b(this.pPx).getCount())});
            try {
                i.b(this.pPx).await();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.WebSearchLogic", e, "", new Object[0]);
            }
        } else {
            x.i("MicroMsg.FTS.WebSearchLogic", "count down latch null");
        }
        int i = this.pPk;
        if (i.c(this.pPx) != null) {
            i = i.c(this.pPx).bWo;
            if (i.c(this.pPx).pLh && i.d(this.pPx)) {
                x.w("MicroMsg.FTS.WebSearchLogic", "ingore pre get data");
                return;
            }
        }
        x.i("MicroMsg.FTS.WebSearchLogic", "calling back to webview, id %d, reqId %s,  %s", new Object[]{Integer.valueOf(i), this.pPl, i.c(this.pPx)});
        h.Bh(i).a(this.fwv, this.pPm, this.pPl, this.fuf);
    }
}
