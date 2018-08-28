package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SightUploadUI.5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c.a;

class SightUploadUI$5$1 implements a {
    final /* synthetic */ int nRy;
    final /* synthetic */ 5 nRz;

    SightUploadUI$5$1(5 5, int i) {
        this.nRz = 5;
        this.nRy = i;
    }

    public final void pO(String str) {
        PInt pInt = new PInt();
        SightUploadUI.j(this.nRz.nRw).a(SightUploadUI.c(this.nRz.nRw), 0, null, SightUploadUI.d(this.nRz.nRw), null, SightUploadUI.e(this.nRz.nRw).getLocation(), this.nRy, SightUploadUI.f(this.nRz.nRw), SightUploadUI.g(this.nRz.nRw), pInt, "", SightUploadUI.h(this.nRz.nRw), SightUploadUI.i(this.nRz.nRw));
        h hVar = h.mEJ;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(SightUploadUI.k(this.nRz.nRw));
        objArr[1] = Long.valueOf(bi.VE());
        objArr[2] = Integer.valueOf(SightUploadUI.l(this.nRz.nRw) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        hVar.h(13303, objArr);
        String str2 = "MicroMsg.SightUploadUI";
        String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
        objArr = new Object[4];
        objArr[0] = Long.valueOf(SightUploadUI.k(this.nRz.nRw));
        objArr[1] = Long.valueOf(bi.VE());
        objArr[2] = Integer.valueOf(SightUploadUI.l(this.nRz.nRw) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        x.d(str2, str3, objArr);
    }

    public final void YX() {
    }

    public final void YY() {
        com.tencent.mm.ui.base.h.i(this.nRz.nRw, j.sns_upload_post_text_invalid_more, j.sns_upload_post_text_invalid_title);
    }
}
