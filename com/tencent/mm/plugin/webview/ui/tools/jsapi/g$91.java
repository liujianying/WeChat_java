package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.j;
import com.tencent.mm.protocal.c.aau;
import com.tencent.mm.ui.MMActivity;

class g$91 implements e {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ g qjP;

    g$91(g gVar, i iVar, g gVar2) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qjP = gVar2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        aau bTX;
        int i3 = -1;
        if (g.l(this.qiK) != null && g.l(this.qiK).isShowing()) {
            g.l(this.qiK).dismiss();
            g.a(this.qiK, null);
        }
        au.DF().b(1393, this);
        String str2 = "openEnterpriseContact:fail";
        if (i == 0 && i2 == 0) {
            bTX = ((j) lVar).bTX();
            if (!(bTX == null || bTX.riQ == null)) {
                i3 = bTX.riQ.ret;
                if (bTX.riQ.bMI != null && bTX.riQ.bMI.length() > 0) {
                    str2 = bTX.riQ.bMI;
                }
            }
        } else {
            bTX = null;
        }
        if (i3 != 0) {
            g.a(this.qiK, this.qiH, str2, null);
            return;
        }
        str2 = bTX.rqU;
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("useJs", true);
        ((MMActivity) g.j(this.qiK)).geJ = this.qjP;
        d.b(g.j(this.qiK), "webview", ".ui.tools.WebViewUI", intent, 31);
    }
}
