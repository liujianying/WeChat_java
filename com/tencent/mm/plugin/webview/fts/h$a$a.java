package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.plugin.webview.fts.h.a;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class h$a$a implements Runnable {
    j dFC;
    public volatile boolean gYf;
    final /* synthetic */ a pPp;

    private h$a$a(a aVar) {
        this.pPp = aVar;
    }

    public final void run() {
        if (!Thread.interrupted()) {
            if (bi.oW(this.dFC.bHt)) {
                x.i("MicroMsg.TopStory.RecommendLogic", "error query %d %d %d %d %s %d", new Object[]{Integer.valueOf(this.dFC.iPZ), Integer.valueOf(this.dFC.scene), Integer.valueOf(this.dFC.pKO), Integer.valueOf(this.dFC.pKQ), this.dFC.iow, Integer.valueOf(this.dFC.offset)});
                return;
            }
            x.i("MicroMsg.TopStory.RecommendLogic", "start New NetScene %s ,  %d", new Object[]{this.dFC.bHt, Integer.valueOf(this.dFC.bWo)});
            if (a.a(this.pPp) != null) {
                au.DF().c(a.a(this.pPp));
            }
            if (this.gYf) {
                x.i("MicroMsg.TopStory.RecommendLogic", "was cancelled");
                return;
            }
            e.bUU().pOB.h(this.dFC.scene, this.dFC.bHt, this.dFC.iPZ);
            a.a(this.pPp, a.a(this.dFC));
            au.DF().a(a.a(this.pPp).getType(), this.pPp.pPj);
            au.DF().a(a.a(this.pPp), 0);
            x.i("MicroMsg.TopStory.RecommendLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(a.a(this.pPp).getType())});
        }
    }
}
