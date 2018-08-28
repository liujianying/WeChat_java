package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.30;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$30$1 implements Runnable {
    final /* synthetic */ 30 odF;

    SnsTimeLineUI$30$1(30 30) {
        this.odF = 30;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.odF.odw) == null || SnsTimeLineUI.y(this.odF.odw) == null) {
            x.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
            return;
        }
        SnsTimeLineUI.y(this.odF.odw).setListener(null);
        SnsTimeLineUI.a(this.odF.odw, SnsTimeLineUI.E(this.odF.odw));
        if (SnsTimeLineUI.F(this.odF.odw)) {
            x.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
            return;
        }
        if (SnsTimeLineUI.u(this.odF.odw)) {
            af.bye().z(af.byv().nro, -1);
        }
        if (!SnsTimeLineUI.u(this.odF.odw)) {
            SnsTimeLineUI.k(this.odF.odw).onl.b(SnsTimeLineUI.q(this.odF.odw), SnsTimeLineUI.i(this.odF.odw), SnsTimeLineUI.j(this.odF.odw), SnsTimeLineUI.r(this.odF.odw));
        }
        SnsTimeLineUI.a(this.odF.odw, false);
        if (this.odF.odw.nUq != null) {
            this.odF.odw.nUq.bwM();
        }
    }
}
