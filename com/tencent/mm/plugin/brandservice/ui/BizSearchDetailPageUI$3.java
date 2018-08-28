package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;

class BizSearchDetailPageUI$3 implements b {
    final /* synthetic */ BizSearchDetailPageUI hos;

    BizSearchDetailPageUI$3(BizSearchDetailPageUI bizSearchDetailPageUI) {
        this.hos = bizSearchDetailPageUI;
    }

    public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
        if (BizSearchDetailPageUI.e(this.hos) == 1 && aVar.type == 5) {
            jz jzVar = (jz) aVar.data;
            if (jzVar.rlB == null || jzVar.rlB.rlj == null) {
                x.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                return;
            }
            ju nt = cVar.nt(i3);
            String str2 = bi.oV(BizSearchDetailPageUI.a(this.hos)) + "," + i + "," + bi.oV(str) + "," + i2 + "," + cVar.hoy + "," + (nt == null ? "" : nt.rlo + ",1");
            h.mEJ.k(10866, str2);
            x.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : " + str2);
            if ((jzVar.rlB.rlj.rTe & 8) > 0) {
                h.mEJ.k(10298, str + ",35");
            }
        }
    }
}
