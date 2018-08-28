package com.tencent.mm.openim.b;

import com.tencent.mm.aa.f;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class i {
    public static ab a(axq axq) {
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(axq.eup);
        if (Yg == null) {
            Yg = new ab();
        }
        Yg.setUsername(axq.eup);
        Yg.dx(axq.nickname);
        Yg.setType(axq.type);
        Yg.dv(axq.fky);
        Yg.setSource(axq.source);
        Yg.dy(axq.saN);
        Yg.dz(axq.saO);
        Yg.dC(axq.saP);
        Yg.dB(axq.saQ);
        Yg.eb(axq.saR == null ? "" : axq.saR.jQf);
        Yg.eT(axq.saR == null ? 0 : axq.saR.saT);
        Yg.ea(axq.rcw);
        Yg.dG(axq.hva);
        Yg.eJ(axq.sex);
        Yg.dF(axq.saS);
        Yg.eQ((int) bi.VE());
        return Yg;
    }

    public static void b(axq axq) {
        boolean z;
        boolean z2 = true;
        Object obj = "";
        Object obj2 = "";
        j kc = q.KH().kc(axq.eup);
        if (kc != null) {
            obj = kc.Kx();
            obj2 = kc.Ky();
        }
        kc = new j();
        kc.bWA = -1;
        kc.username = axq.eup;
        kc.dHQ = axq.saM;
        kc.dHR = axq.saL;
        x.i("MicroMsg.OpenIMContactLogic", "dealwithAvatarFromModContact contact %s b[%s] s[%s]", kc.getUsername(), kc.Kx(), kc.Ky());
        if (kc.Kx().equals(obj)) {
            z = false;
        } else {
            q.Kp();
            f.B(axq.eup, true);
            z = true;
        }
        if (kc.Ky().equals(obj2)) {
            z2 = z;
        } else {
            q.Kp();
            f.B(axq.eup, false);
        }
        if (z2) {
            q.KJ().jO(axq.eup);
            q.KH().a(kc);
        }
    }
}
