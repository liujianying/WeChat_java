package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ab.d.c;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.HashMap;

public final class i implements ar {
    private r oJo = null;
    private n oJp = new n();
    g oJq;
    private a oJr = new a();

    private static i bJH() {
        au.HN();
        i iVar = (i) bs.iK("plugin.voip");
        if (iVar != null) {
            return iVar;
        }
        iVar = new i();
        au.HN().a("plugin.voip", iVar);
        return iVar;
    }

    public static r bJI() {
        if (au.HX()) {
            if (bJH().oJo == null) {
                bJH().oJo = new r();
            }
            return bJH().oJo;
        }
        throw new b();
    }

    public static g bJJ() {
        if (au.HX()) {
            if (bJH().oJq == null) {
                bJH().oJq = new g();
            }
            return bJH().oJq;
        }
        throw new b();
    }

    public final void onAccountRelease() {
        if (this.oJq != null) {
            ah.A(new 1(this));
        }
        c.b(Integer.valueOf(50), this.oJp);
        bJI();
        r.bLa();
        com.tencent.mm.sdk.b.a.sFg.c(this.oJr);
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        c.a(Integer.valueOf(50), this.oJp);
        bJI();
        r.bKZ();
        com.tencent.mm.sdk.b.a.sFg.b(this.oJr);
        au.getNotification().cancel(40);
        au.HU();
        boolean booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(73217, Boolean.valueOf(true))).booleanValue();
        au.HU();
        boolean booleanValue2 = ((Boolean) com.tencent.mm.model.c.DT().get(73218, Boolean.valueOf(true))).booleanValue();
        boolean Am = com.tencent.mm.k.a.Am();
        au.HU();
        x.i("MicroMsg.SubCoreVoip", "voipSound: %s, voipAudioSound: %s, msgSound: %s, hasReport: %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(booleanValue2), Boolean.valueOf(Am), Boolean.valueOf(((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sZP, Boolean.valueOf(false))).booleanValue())});
        if (!((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sZP, Boolean.valueOf(false))).booleanValue()) {
            boolean z2 = booleanValue || booleanValue2;
            if (z2 != Am) {
                if (z2 && !Am) {
                    h.mEJ.a(500, 13, 1, false);
                } else if (!z2 && Am) {
                    h.mEJ.a(500, 14, 1, false);
                }
            }
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.sZP, Boolean.valueOf(true));
        }
        as.ha(1);
    }

    public final void bo(boolean z) {
    }
}
