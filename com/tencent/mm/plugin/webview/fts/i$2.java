package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;

class i$2 extends c<ly> {
    final /* synthetic */ i pPx;

    i$2(i iVar) {
        this.pPx = iVar;
        this.sFo = ly.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ly lyVar = (ly) bVar;
        i iVar = this.pPx;
        String str = lyVar.bWq.bWs;
        String str2 = lyVar.bWq.bJK;
        String str3 = lyVar.bWq.bWr;
        Object obj = lyVar.bWq.bWm;
        int i = lyVar.bWq.scene;
        String str4 = lyVar.bWq.bWt;
        if (!TextUtils.isEmpty(obj)) {
            if (!iVar.pPh) {
                x.w("MicroMsg.FTS.WebSearchLogic", "do no support pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", new Object[]{Integer.valueOf(p.zP(0)), str, str2, str3});
            } else if (System.currentTimeMillis() - iVar.pPs <= i.pOZ) {
                x.w("MicroMsg.FTS.WebSearchLogic", "pre get data fail for time interval limit");
            } else {
                x.w("MicroMsg.FTS.WebSearchLogic", "pre get data, h5.ver %d, seq %s, sessionId %s, subSessionId %s", new Object[]{Integer.valueOf(p.zP(0)), str, str2, str3});
                iVar.pPc = true;
                if (iVar.pPe != null) {
                    iVar.pPe.countDown();
                }
                iVar.pPe = new CountDownLatch(1);
                iVar.pPd = false;
                iVar.a(str, str2, str3, obj, i, str4);
                iVar.pPs = System.currentTimeMillis();
            }
        }
        return false;
    }
}
