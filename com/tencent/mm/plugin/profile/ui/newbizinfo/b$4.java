package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.c;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements a {
    final /* synthetic */ b lYu;

    b$4(b bVar) {
        this.lYu = bVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        ih ihVar = (ih) bVar.dIE.dIL;
        if (i == 0 && i2 == 0 && ihVar != null) {
            x.d("MicroMsg.ContactWidgetNewBizInfo", "BizProfileResp:%d", new Object[]{Integer.valueOf(ihVar.rgX.size())});
            this.lYu.lYt = c.a(this.lYu.guS.field_username, ihVar);
            this.lYu.bnp();
            b bVar2 = this.lYu;
            if (bVar2.guS == null || bVar2.lUs == null || bVar2.lYt == null) {
                x.w("MicroMsg.ContactWidgetNewBizInfo", "reportUpdate fail, err");
            } else {
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(bVar2.guS.field_username, bVar2.eLK, bVar2.lUs.field_type, bVar2.cYb, com.tencent.mm.l.a.gd(bVar2.guS.field_type) ? 1 : 0, bVar2.lYt.field_originalArticleCount, bVar2.lYt.field_friendSubscribeCount, bVar2.lVH != null ? bVar2.lVH.size() : 0, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bJ(bVar2.lYt.bnM()), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.bK(bVar2.lYt.bnN()));
                if (bVar2.lYt != null && bVar2.lYt.bnQ()) {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(bVar2.guS.field_username, 104);
                }
                if (bVar2.lYt != null && bVar2.lYt.bnP()) {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(bVar2.guS.field_username, 101);
                }
                if (bVar2.lYt != null && bVar2.awi() && bVar2.lVH != null && bVar2.lVH.size() > 0) {
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bT(bVar2.guS.field_username, 105);
                }
            }
        }
        return 0;
    }
}
