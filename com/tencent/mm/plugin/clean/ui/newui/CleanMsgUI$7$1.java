package com.tencent.mm.plugin.clean.ui.newui;

import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI.7;

class CleanMsgUI$7$1 implements Runnable {
    final /* synthetic */ long hSl;
    final /* synthetic */ 7 hTA;

    CleanMsgUI$7$1(7 7, long j) {
        this.hTA = 7;
        this.hSl = j;
    }

    public final void run() {
        if (CleanMsgUI.c(this.hTA.hTx) != null) {
            CleanMsgUI.c(this.hTA.hTx).dismiss();
        }
        d.ci(d.aBm() + this.hSl);
        d.ch(d.aBl() - this.hSl);
        CleanMsgUI cleanMsgUI = this.hTA.hTx;
        d.aBm();
        CleanMsgUI.a(cleanMsgUI, d.aBj(), d.aBl(), d.aBk());
    }
}
