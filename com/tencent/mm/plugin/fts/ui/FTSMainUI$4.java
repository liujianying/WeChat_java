package com.tencent.mm.plugin.fts.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class FTSMainUI$4 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$4(FTSMainUI fTSMainUI, int i) {
        this.jxp = fTSMainUI;
        this.bpX = i;
    }

    public final void run() {
        if (System.currentTimeMillis() - FTSMainUI.m(this.jxp) > 1000) {
            FTSMainUI.a(this.jxp, System.currentTimeMillis());
            if (p.zO(0)) {
                ad.q(this.bpX, 14, r.PY("searchID"));
                x.i("MicroMsg.FTS.FTSMainUI", "FTSWebReportLogic.kvReportGlobalTabClick reported type %d, searchId %s", new Object[]{Integer.valueOf(this.bpX), r0});
                this.jxp.YC();
                Intent adR = p.adR();
                adR.putExtra("ftsneedkeyboard", true);
                adR.putExtra("ftsbizscene", 14);
                adR.putExtra("ftsType", this.bpX);
                Map b = p.b(14, true, this.bpX);
                b.put("sessionId", e.jqM);
                b.put("subSessionId", e.jqM);
                adR.putExtra("sessionId", e.jqM);
                adR.putExtra("subSessionId", e.jqM);
                adR.putExtra("rawUrl", p.v(b));
                adR.putExtra("key_load_js_without_delay", true);
                Bundle bundle = null;
                if (VERSION.SDK_INT >= 21) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(this.jxp, new Pair[0]).toBundle();
                }
                d.a(this.jxp, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR, bundle);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }
}
