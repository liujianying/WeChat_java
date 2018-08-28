package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.b.a;
import java.util.Map;

class a$1 implements Runnable {
    final /* synthetic */ String jxq;
    final /* synthetic */ Activity mr;
    final /* synthetic */ a qmS;

    a$1(a aVar, String str, Activity activity) {
        this.qmS = aVar;
        this.jxq = str;
        this.mr = activity;
    }

    public final void run() {
        Intent adR = p.adR();
        adR.putExtra("ftsbizscene", 21);
        adR.putExtra("ftsQuery", this.jxq);
        adR.putExtra("title", this.jxq);
        adR.putExtra("isWebwx", this.jxq);
        adR.putExtra("ftscaneditable", false);
        Map b = p.b(21, false, 2);
        b.put("query", this.jxq);
        b.put("sceneActionType", "2");
        adR.putExtra("rawUrl", p.c(b, 1));
        kx kxVar = new kx();
        kxVar.bVh.scene = 0;
        a.sFg.m(kxVar);
        d.b(this.mr, "webview", ".ui.tools.fts.FTSWebViewUI", adR);
        ad.aR(21, this.jxq);
    }
}
