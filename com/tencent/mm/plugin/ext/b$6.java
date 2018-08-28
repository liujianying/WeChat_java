package com.tencent.mm.plugin.ext;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.i;
import com.tencent.mm.pluginsdk.model.i$b;
import com.tencent.mm.pluginsdk.model.i.a;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.protocal.c.bxc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bu;
import java.util.Iterator;

class b$6 implements a {
    final /* synthetic */ b iJo;

    b$6(b bVar) {
        this.iJo = bVar;
    }

    public final void a(l lVar) {
        if (lVar != null) {
            ajd ajd;
            if (lVar.ivx == null) {
                ajd = null;
            } else {
                ajd = (ajd) lVar.ivx.dIE.dIL;
            }
            Iterator it = ajd.rLP.iterator();
            int i = 0;
            while (it.hasNext()) {
                bxc bxc = (bxc) it.next();
                x.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", new Object[]{lVar.qyY, bxc.hbL, bxc.stI});
                if (!(bi.oW(bxc.hbL) || bi.oW(bxc.stI))) {
                    au.HU();
                    ab Ye = c.FR().Ye(bxc.hbL);
                    if (Ye == null || ((int) Ye.dhP) <= 0) {
                        x.e("MicroMsg.SubCoreExt", "contact is null");
                    } else if (Ye.ckW()) {
                        x.w("MicroMsg.SubCoreExt", "isBizContact");
                    } else {
                        i$b SM = i.SM(bxc.stI);
                        if (!(SM == null || bi.oW(SM.qyS))) {
                            x.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", new Object[]{lVar.qyY, SM.qyS});
                            b.aIM().a(new bu(lVar.qyY, bxc.hbL, SM.qyS));
                            i = 1;
                        }
                    }
                }
            }
            if (i != 0) {
                this.iJo.aIQ();
            }
        }
    }
}
