package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g;

class IPCallShareCouponCardUI$7 implements a {
    final /* synthetic */ String dMs;
    final /* synthetic */ IPCallShareCouponCardUI kyi;

    IPCallShareCouponCardUI$7(IPCallShareCouponCardUI iPCallShareCouponCardUI, String str) {
        this.kyi = iPCallShareCouponCardUI;
        this.dMs = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            g.a aVar = new g.a();
            aVar.title = IPCallShareCouponCardUI.d(this.kyi);
            aVar.url = IPCallShareCouponCardUI.e(this.kyi);
            aVar.description = IPCallShareCouponCardUI.f(this.kyi);
            aVar.thumburl = IPCallShareCouponCardUI.g(this.kyi);
            aVar.type = 5;
            l.a(aVar, null, null, this.dMs, "", null, null);
            if (!bi.oW(str)) {
                ow owVar = new ow();
                owVar.bZQ.bZR = this.dMs;
                owVar.bZQ.content = str;
                owVar.bZQ.type = s.hQ(this.dMs);
                owVar.bZQ.flags = 0;
                com.tencent.mm.sdk.b.a.sFg.m(owVar);
            }
            h.bA(this.kyi.mController.tml, this.kyi.getResources().getString(R.l.app_shared));
        }
    }
}
