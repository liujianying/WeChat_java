package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.g.a.tj;
import com.tencent.mm.plugin.remittance.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class b$6 extends c<tj> {
    final /* synthetic */ b mtR;

    b$6(b bVar) {
        this.mtR = bVar;
        this.sFo = tj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.plugin.remittance.b.c Kx;
        tj tjVar = (tj) bVar;
        d bqS = b.bqS();
        String str = tjVar.ceU.bXz;
        if (bi.oW(str) || !d.eBb.containsKey(str)) {
            Kx = bqS.Kx(str);
            if (Kx != null) {
                d.eBb.put(str, Kx);
            } else {
                Kx = null;
            }
        } else {
            Kx = (com.tencent.mm.plugin.remittance.b.c) d.eBb.get(str);
        }
        if (Kx != null) {
            tjVar.ceV.status = Kx.field_receiveStatus;
            tjVar.ceV.ceW = Kx.field_isSend;
        } else {
            tjVar.ceV.status = -2;
            tjVar.ceV.ceW = false;
        }
        return false;
    }
}
