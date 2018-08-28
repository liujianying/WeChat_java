package com.tencent.mm.plugin.voip.widget;

import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements a {
    final /* synthetic */ b oWh;

    b$3(b bVar) {
        this.oWh = bVar;
    }

    public final boolean vD() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.e(this.oWh));
        if (b.e(this.oWh) == 8 || b.e(this.oWh) == 262 || !d.bLT()) {
            au.getNotification().cancel(40);
            x.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
            if (b.g(this.oWh) == null || b.g(this.oWh).ciq()) {
                return false;
            }
            b.g(this.oWh).SO();
            return false;
        }
        x.i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
        String h = b.h(this.oWh);
        this.oWh.g(h, r.gT(b.d(this.oWh).field_username), h, false);
        return true;
    }
}
