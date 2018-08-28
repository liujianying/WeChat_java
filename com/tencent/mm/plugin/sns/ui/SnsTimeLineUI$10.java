package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$10 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI odw;
    final /* synthetic */ boolean odx;
    final /* synthetic */ boolean ody;

    SnsTimeLineUI$10(SnsTimeLineUI snsTimeLineUI, boolean z, boolean z2) {
        this.odw = snsTimeLineUI;
        this.odx = z;
        this.ody = z2;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        SnsTimeLineUI.h(this.odw).ofU = this.odx;
        if (this.odx) {
            SnsTimeLineUI.h(this.odw).im(false);
        } else if (this.ody) {
            SnsTimeLineUI.k(this.odw).onm.b("@__weixintimtline", SnsTimeLineUI.i(this.odw), SnsTimeLineUI.j(this.odw), 0);
        }
        return voidR;
    }
}
