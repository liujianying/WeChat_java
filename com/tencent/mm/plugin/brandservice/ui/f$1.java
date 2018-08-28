package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;

class f$1 implements c$b {
    final /* synthetic */ f hpU;

    f$1(f fVar) {
        this.hpU = fVar;
    }

    public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
        ju nt = this.hpU.nt(i3);
        String str2 = bi.oV(this.hpU.hoo) + "," + i + "," + bi.oV(str) + "," + i2 + "," + cVar.hoy + "," + (nt == null ? "" : nt.rlo + ",0");
        h.mEJ.k(10866, str2);
        x.d("MicroMsg.SearchOrRecommendBizAdapter", "report : " + str2);
    }
}
