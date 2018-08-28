package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class CleanMsgUI$5 implements h {
    final /* synthetic */ CleanMsgUI hSL;

    CleanMsgUI$5(CleanMsgUI cleanMsgUI) {
        this.hSL = cleanMsgUI;
    }

    public final void cq(int i, int i2) {
        CleanMsgUI.a(this.hSL).setMessage(this.hSL.getString(R.l.clean_progress_tip, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void ck(final long j) {
        x.i("MicroMsg.CleanMsgUI", "onDeleteEnd %d ", new Object[]{Long.valueOf(j)});
        ah.A(new Runnable() {
            public final void run() {
                long j = 0;
                if (CleanMsgUI.a(CleanMsgUI$5.this.hSL) != null) {
                    CleanMsgUI.a(CleanMsgUI$5.this.hSL).dismiss();
                }
                long j2 = j.aBt().hQE;
                long j3 = j.aBt().hQE - j;
                if (j3 < 0) {
                    j2 = j.aBt().hQC - j2;
                } else {
                    j2 = j.aBt().hQC - j;
                    j = j3;
                }
                j.aBt().hQE = j;
                j.aBt().hQC = j2;
                CleanMsgUI.a(CleanMsgUI$5.this.hSL, j.aBt().hQC, j.aBt().hQD, j.aBt().hQE);
            }
        });
        com.tencent.mm.plugin.report.service.h.mEJ.a(714, 13, 1, false);
    }
}
