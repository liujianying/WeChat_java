package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$13 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI odw;
    final /* synthetic */ boolean odx;

    SnsTimeLineUI$13(SnsTimeLineUI snsTimeLineUI, boolean z) {
        this.odw = snsTimeLineUI;
        this.odx = z;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        SnsTimeLineUI.h(this.odw).ofU = this.odx;
        x.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[]{Boolean.valueOf(this.odx)});
        if (this.odx) {
            SnsTimeLineUI.h(this.odw).im(false);
        }
        return voidR;
    }
}
