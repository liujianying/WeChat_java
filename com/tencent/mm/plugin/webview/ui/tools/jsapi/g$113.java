package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

class g$113 implements a {
    final /* synthetic */ String bAd;
    final /* synthetic */ String dUT;
    final /* synthetic */ String fFV;
    final /* synthetic */ g qiK;
    final /* synthetic */ f qiT;
    final /* synthetic */ String qiU;
    final /* synthetic */ String qiV;
    final /* synthetic */ String qiW;
    final /* synthetic */ boolean qjY = true;
    final /* synthetic */ String qjZ;
    final /* synthetic */ String qka;

    g$113(g gVar, f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.qiK = gVar;
        this.qiT = fVar;
        this.fFV = str;
        this.bAd = str2;
        this.dUT = str3;
        this.qiU = str4;
        this.qiV = str5;
        this.qiW = str6;
        this.qjZ = str7;
        this.qka = str8;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            g.a(this.qiK, this.qiT, this.fFV, this.bAd, this.dUT, this.qiU, this.qiV, str, this.qiW);
            if (this.qjY) {
                d.e(g.j(this.qiK), ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", this.bAd));
            } else if (g.j(this.qiK) != null) {
                h.bA(g.j(this.qiK), g.j(this.qiK).getResources().getString(R.l.app_shared));
            }
            this.qiK.em(1, 1);
            g.a(this.qiK, g.k(this.qiK), this.qjZ, null);
            return;
        }
        this.qiK.em(1, 3);
        g.a(this.qiK, g.k(this.qiK), this.qka, null);
    }
}
