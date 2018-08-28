package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;

public final class b implements e {
    com.tencent.mm.vending.g.b eAc;

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            v vVar = ((j) lVar).eAZ;
            x.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", Integer.valueOf(vVar.hUm));
            if (vVar.hUm == 0) {
                g.a(this.eAc, vVar);
                h.mEJ.a(407, 6, 1, false);
                c pe = com.tencent.mm.plugin.aa.b.VQ().pe(vVar.qYc);
                if (pe != null) {
                    pe.field_status = vVar.state;
                    com.tencent.mm.plugin.aa.b.VQ().b(pe);
                    return;
                }
                return;
            }
            if (vVar.hUm <= 0 || bi.oW(vVar.hUn)) {
                this.eAc.ct(Boolean.valueOf(false));
            } else {
                this.eAc.ct(vVar.hUn);
            }
            h.mEJ.a(407, 8, 1, false);
            return;
        }
        if (this.eAc != null) {
            this.eAc.ct(Boolean.valueOf(false));
        }
        h.mEJ.a(407, 7, 1, false);
    }
}
