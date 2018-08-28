package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.b.c$a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private c$a kqr = new 1(this);
    public com.tencent.mm.e.b.c ltc = new com.tencent.mm.e.b.c(v2protocal.lsT, 1, 1);
    private a ltf = new 2(this);
    public b oKt;

    public c() {
        this.ltc.ey(20);
        this.ltc.aN(true);
        this.ltc.wm();
        this.ltc.t(1, false);
        this.ltc.aM(true);
        this.ltc.bEb = this.kqr;
        this.oKt = new b();
        this.oKt.X(v2protocal.lsT, 20, 0);
        this.oKt.r(ad.getContext(), false);
        this.oKt.oHi = this.ltf;
    }

    private boolean iJ(boolean z) {
        if (this.oKt != null) {
            return this.oKt.iJ(z);
        }
        return false;
    }

    public final void ja(boolean z) {
        x.k("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: " + z, new Object[0]);
        x.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + au.HV().yI());
        if (au.HV().yE()) {
            z = false;
        }
        if (q.deN.dby) {
            q.deN.dump();
            if (q.deN.dbz > 0) {
                iJ(z);
            }
        }
        if (q.deN.dcb >= 0 || q.deN.dcc >= 0) {
            iJ(z);
        }
        if (this.oKt != null) {
            au.HV().b(z, this.oKt.bJx(), false);
            com.tencent.mm.plugin.voip_cs.b.b.a bMv = com.tencent.mm.plugin.voip_cs.b.b.bMv();
            int tf = z ? bMv.kqx.tf(401) : bMv.kqx.tf(402);
            if (tf < 0) {
                com.tencent.mm.plugin.voip.b.a.eV("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:" + tf);
            }
        }
    }
}
