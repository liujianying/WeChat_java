package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.g.a.jj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class CleanNewUI$9 extends c<jj> {
    final /* synthetic */ CleanNewUI hTh;

    CleanNewUI$9(CleanNewUI cleanNewUI) {
        this.hTh = cleanNewUI;
        this.sFo = jj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jj jjVar = (jj) bVar;
        if (!(jjVar == null || jjVar.bSO == null)) {
            x.i("MicroMsg.CleanNewUI", "%s manual scan [%d %d %b]", CleanNewUI.a(this.hTh), Long.valueOf(jjVar.bSO.bSP), Long.valueOf(jjVar.bSO.bSQ), Boolean.valueOf(jjVar.bSO.bwt));
            if (jjVar.bSO.bwt) {
                CleanNewUI.b(this.hTh, bi.VF());
                CleanNewUI.l(this.hTh);
                h.mEJ.a(714, 51, 1, false);
            } else {
                int i = (int) (((((float) jjVar.bSO.bSP) * 1.0f) / ((float) jjVar.bSO.bSQ)) * 100.0f);
                CleanNewUI cleanNewUI = this.hTh;
                if (i <= 0) {
                    i = 0;
                }
                cleanNewUI.cr(i, 100);
            }
        }
        return false;
    }
}
