package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.g.a.ti;
import com.tencent.mm.plugin.wallet_core.d.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class o$6 extends c<ti> {
    final /* synthetic */ o pqJ;

    o$6(o oVar) {
        this.pqJ = oVar;
        this.sFo = ti.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        y yVar;
        ti tiVar = (ti) bVar;
        g bOT = o.bOT();
        String str = tiVar.ceP.ceR;
        if (!bi.oW(str)) {
            if (g.eBb.containsKey(str)) {
                yVar = (y) g.eBb.get(str);
            } else {
                yVar = bOT.Pk(str);
                if (yVar != null) {
                    g.eBb.put(str, yVar);
                }
            }
            if (yVar != null) {
                tiVar.ceQ.ceS = yVar.field_hbStatus;
                tiVar.ceQ.ceT = yVar.field_receiveStatus;
            }
            return false;
        }
        yVar = null;
        if (yVar != null) {
            tiVar.ceQ.ceS = yVar.field_hbStatus;
            tiVar.ceQ.ceT = yVar.field_receiveStatus;
        }
        return false;
    }
}
