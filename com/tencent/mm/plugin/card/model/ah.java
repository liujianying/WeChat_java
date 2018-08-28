package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.bgr;
import com.tencent.mm.protocal.c.bgs;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends l implements k {
    private final b diG;
    private e diJ;

    public ah(LinkedList<ayl> linkedList) {
        a aVar = new a();
        aVar.dIG = new bgr();
        aVar.dIH = new bgs();
        aVar.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        aVar.dIF = 1275;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bgr) this.diG.dID.dIL).shD = linkedList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ayl ayl = (ayl) it.next();
                x.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[]{ayl.cac, ayl.hwJ, Integer.valueOf(ayl.sbp), Integer.valueOf(ayl.sbq)});
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1275;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
