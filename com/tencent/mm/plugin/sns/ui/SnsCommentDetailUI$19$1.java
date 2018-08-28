package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.19;

class SnsCommentDetailUI$19$1 implements Runnable {
    final /* synthetic */ boolean dSV;
    final /* synthetic */ 19 nUQ;

    SnsCommentDetailUI$19$1(19 19, boolean z) {
        this.nUQ = 19;
        this.dSV = z;
    }

    public final void run() {
        if (this.dSV && !this.nUQ.nUO.isFinishing() && this.nUQ.nUO.nUL < 5) {
            this.nUQ.nUO.bDd();
        }
        SnsCommentDetailUI snsCommentDetailUI = this.nUQ.nUO;
        snsCommentDetailUI.nUL++;
    }
}
