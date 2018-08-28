package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class FTSMainUI$1 implements OnClickListener {
    final /* synthetic */ FTSMainUI jxp;

    FTSMainUI$1(FTSMainUI fTSMainUI) {
        this.jxp = fTSMainUI;
    }

    public final void onClick(View view) {
        FTSMainUI fTSMainUI = this.jxp;
        String str = (String) view.getTag();
        if (System.currentTimeMillis() - fTSMainUI.ghF > 1000) {
            fTSMainUI.ghF = System.currentTimeMillis();
            if (p.zO(0)) {
                Intent adR = p.adR();
                adR.putExtra("ftsbizscene", 15);
                adR.putExtra("ftsQuery", str);
                adR.putExtra("title", str);
                adR.putExtra("isWebwx", str);
                adR.putExtra("ftscaneditable", false);
                Map b = p.b(15, false, 2);
                b.put("query", str);
                b.put("sceneActionType", "2");
                adR.putExtra("rawUrl", p.v(b));
                kx kxVar = new kx();
                kxVar.bVh.scene = 0;
                a.sFg.m(kxVar);
                adR.putExtra("ftsInitToSearch", true);
                d.b(fTSMainUI.mController.tml, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", adR);
                ad.aR(15, str);
                return;
            }
            x.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }
}
