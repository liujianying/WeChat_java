package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.rv;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ap$1 extends c<rv> {
    ap$1() {
        this.sFo = rv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 1;
        rv rvVar = (rv) bVar;
        if (rvVar instanceof rv) {
            String str = rvVar.ccL.id;
            int i2 = rvVar.ccL.type;
            a ce = ap.ce(str, i2);
            if (ce != null) {
                String str2 = rvVar.ccL.ccM;
                ce.nrG = str2;
                ce.cbd = rvVar.ccL.cbd;
                String str3 = "MicroMsg.SnsTranslateManager";
                String str4 = "finish translate, id:%s, type: %d, success: %b";
                Object[] objArr = new Object[3];
                objArr[0] = ce.id;
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Boolean.valueOf(!bi.oW(str2));
                x.i(str3, str4, objArr);
                switch (i2) {
                    case 2:
                        break;
                    case 3:
                        i = 2;
                        break;
                    default:
                        i = -1;
                        break;
                }
                if (i != -1) {
                    ap.e(str, i, ce.nrG, ce.cbd);
                    ap.auZ().remove(ce);
                }
            }
        }
        return false;
    }
}
