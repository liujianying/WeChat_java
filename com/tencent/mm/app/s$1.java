package com.tencent.mm.app;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

class s$1 implements a {
    final /* synthetic */ String bAd;
    final /* synthetic */ WXMediaMessage bAi;
    final /* synthetic */ String bAj;
    final /* synthetic */ String bAk;
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ s bAm;

    s$1(s sVar, WXMediaMessage wXMediaMessage, String str, String str2, String str3, MMActivity mMActivity) {
        this.bAm = sVar;
        this.bAi = wXMediaMessage;
        this.bAj = str;
        this.bAk = str2;
        this.bAd = str3;
        this.bAl = mMActivity;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            l.a(this.bAi, this.bAj, this.bAk, this.bAd, 3, null);
            if (!bi.oW(str)) {
                ow owVar = new ow();
                owVar.bZQ.bZR = this.bAd;
                owVar.bZQ.content = str;
                owVar.bZQ.type = s.hQ(this.bAd);
                owVar.bZQ.flags = 0;
                com.tencent.mm.sdk.b.a.sFg.m(owVar);
            }
            h.bA(this.bAl, this.bAl.getResources().getString(R.l.app_shared));
            com.tencent.mm.plugin.report.service.h.mEJ.k(10910, "2");
        }
    }
}
