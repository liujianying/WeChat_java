package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$6 implements a {
    final /* synthetic */ String dEt;
    final /* synthetic */ String efo;
    private int mCount = 0;
    final /* synthetic */ b oWh;
    final /* synthetic */ String oWj;

    b$6(b bVar, String str, String str2, String str3) {
        this.oWh = bVar;
        this.oWj = str;
        this.dEt = str2;
        this.efo = str3;
    }

    public final boolean vD() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.e(this.oWh));
        this.mCount++;
        if (b.e(this.oWh) == 8 || b.e(this.oWh) == 262 || !d.bLT()) {
            x.i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
            au.getNotification().cancel(40);
            if (!(b.g(this.oWh) == null || b.g(this.oWh).ciq())) {
                b.g(this.oWh).SO();
            }
            return false;
        }
        this.oWh.g(this.oWj + (this.mCount % 2 == 1 ? " " : ""), this.dEt, this.efo, false);
        return true;
    }
}
