package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class SnsTimeLineUI$11 implements a<Void, Void> {
    final /* synthetic */ SnsTimeLineUI odw;
    final /* synthetic */ String odz;

    SnsTimeLineUI$11(SnsTimeLineUI snsTimeLineUI, String str) {
        this.odw = snsTimeLineUI;
        this.odz = str;
    }

    public final /* synthetic */ Object call(Object obj) {
        Void voidR = (Void) obj;
        ax a = SnsTimeLineUI.a(this.odw);
        if (a != null) {
            a.oeg.nQU = this.odz;
            aw awVar = a.oeg;
            awVar.looperCheckForVending();
            x.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[]{Boolean.valueOf(awVar.odZ)});
            if (!awVar.odZ) {
                synchronized (awVar.oea) {
                    awVar.iKw = awVar.r(0, awVar.iKw);
                }
            }
            a.oeg.notifyVendingDataChange();
        }
        return voidR;
    }
}
