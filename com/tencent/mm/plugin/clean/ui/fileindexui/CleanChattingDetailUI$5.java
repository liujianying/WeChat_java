package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;

class CleanChattingDetailUI$5 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dVx;
    final /* synthetic */ CleanChattingDetailUI hSj;

    CleanChattingDetailUI$5(CleanChattingDetailUI cleanChattingDetailUI, int i, int i2) {
        this.hSj = cleanChattingDetailUI;
        this.dPF = i;
        this.dVx = i2;
    }

    public final void run() {
        CleanChattingDetailUI.c(this.hSj).setMessage(this.hSj.getString(R.l.clean_progress_tip, new Object[]{((this.dPF * 100) / this.dVx) + "%"}));
    }
}
