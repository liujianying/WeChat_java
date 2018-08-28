package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$14 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI odw;
    final /* synthetic */ String odz;

    SnsTimeLineUI$14(SnsTimeLineUI snsTimeLineUI, String str) {
        this.odw = snsTimeLineUI;
        this.odz = str;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        ax a = SnsTimeLineUI.a(this.odw);
        if (a != null) {
            a.oeg.nQU = this.odz;
            a.oeg.bDI();
            a.oeg.notifyVendingDataChange();
        }
        return voidR;
    }
}
