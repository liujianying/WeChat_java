package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.sdk.platformtools.x;

class z$1 implements Runnable {
    final /* synthetic */ int pLZ;
    final /* synthetic */ z pMa;
    final /* synthetic */ String val$url;

    z$1(z zVar, int i, String str) {
        this.pMa = zVar;
        this.pLZ = i;
        this.val$url = str;
    }

    public final void run() {
        boolean bTd;
        z.a(this.pMa);
        z zVar = this.pMa;
        switch (this.pLZ) {
            case 1:
                bTd = zVar.bTd();
                break;
            case 2:
                bTd = zVar.bTe();
                break;
            case 4:
                bTd = zVar.bTd();
                break;
            default:
                x.w("MicroMsg.WebSearch.WebSearchPreloadExport", "unknown preload biz %d", new Object[]{Integer.valueOf(this.pLZ)});
                bTd = false;
                break;
        }
        if (bTd) {
            z.G("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", this.val$url, this.pLZ);
            return;
        }
        x.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preload switch close , biz %d, url %s", new Object[]{Integer.valueOf(this.pLZ), this.val$url});
    }
}
