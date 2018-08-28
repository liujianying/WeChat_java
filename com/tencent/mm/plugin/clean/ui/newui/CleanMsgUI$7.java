package com.tencent.mm.plugin.clean.ui.newui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.sdk.platformtools.ah;

class CleanMsgUI$7 implements h {
    final /* synthetic */ CleanMsgUI hTx;

    CleanMsgUI$7(CleanMsgUI cleanMsgUI) {
        this.hTx = cleanMsgUI;
    }

    public final void cq(int i, int i2) {
        CleanMsgUI.c(this.hTx).setMessage(this.hTx.getString(R.l.clean_progress_tip, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void ck(long j) {
        ah.A(new 1(this, j));
        com.tencent.mm.plugin.report.service.h.mEJ.a(282, 12, 1, false);
        com.tencent.mm.plugin.report.service.h.mEJ.a(282, 13, j / 1024, false);
    }
}
