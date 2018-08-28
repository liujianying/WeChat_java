package com.tencent.mm.ac;

import com.tencent.mm.ab.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Map;

class z$9 implements a {
    final /* synthetic */ z dMY;

    z$9(z zVar) {
        this.dMY = zVar;
    }

    public final void a(d.a aVar) {
        by byVar = aVar.dIN;
        if (byVar == null) {
            x.e("MicroMsg.SubCoreBiz", "AddMsg is null.");
            return;
        }
        String a = ab.a(byVar.rcl);
        if (bi.oW(a)) {
            x.e("MicroMsg.SubCoreBiz", "msg content is null");
            return;
        }
        Map z = bl.z(a, "sysmsg");
        if (z == null || z.size() <= 0) {
            x.e("MicroMsg.SubCoreBiz", "receiveMessage, no sysmsg");
            return;
        }
        if ("mmbizattrappsvr_BizAttrSync".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            x.i("MicroMsg.SubCoreBiz", "BizAttrSync openFlag : %d.", new Object[]{Integer.valueOf(bi.getInt((String) z.get(".sysmsg.mmbizattrappsvr_BizAttrSync.openflag"), 0))});
            g.Ei().DT().a(aa.a.sQF, Integer.valueOf(r0));
            g.Ei().DT().lm(true);
            return;
        }
        x.e("MicroMsg.SubCoreBiz", "receiveMessage, type not BizAttrSync.");
    }
}
