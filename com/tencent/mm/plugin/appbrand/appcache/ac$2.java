package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cgk;
import com.tencent.mm.protocal.c.cgl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class ac$2 implements a {
    ac$2() {
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        h.mEJ.a(368, 40, 1, false);
        if (g.Eg().Dx()) {
            g.Ei().DT().a(aa.a.sTu, Long.valueOf(86400 + bi.VE()));
        }
        if (i == 0 && i2 == 0) {
            try {
                ac.b(((cgk) bVar.dID.dIL).version, (cgl) bVar.dIE.dIL, ac$a.fgF);
            } catch (RuntimeException e) {
                x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, e %s", new Object[]{e});
            }
        } else {
            x.e("MicroMsg.WxaCommLibVersionChecker", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        return 0;
    }
}
