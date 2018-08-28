package com.tencent.mm.plugin.websearch.c.a;

import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;

class b$1 implements l {
    final /* synthetic */ b pNd;

    b$1(b bVar) {
        this.pNd = bVar;
    }

    public final void b(j jVar) {
        a aVar = (a) jVar.jsw.jrq;
        if (aVar != null) {
            CountDownLatch countDownLatch = (CountDownLatch) this.pNd.pNa.remove(aVar);
            switch (jVar.bjW) {
                case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                case -2:
                case -1:
                    aVar.cL(Collections.emptyList());
                    break;
                case 0:
                    if (jVar.jsx != null && jVar.jsx.size() != 0) {
                        aVar.cL(jVar.jsx);
                        break;
                    }
                    x.i("FTSMatchContact", "local contact search size 0");
                    aVar.cL(Collections.emptyList());
                    countDownLatch.countDown();
                    return;
            }
            countDownLatch.countDown();
        }
    }
}
