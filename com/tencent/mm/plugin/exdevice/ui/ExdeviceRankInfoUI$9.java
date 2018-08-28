package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceRankInfoUI$9 implements Runnable {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$9(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final void run() {
        ExdeviceRankInfoUI.u(this.iFG);
        if (ExdeviceRankInfoUI.v(this.iFG)) {
            ExdeviceRankInfoUI.b(this.iFG).notifyDataSetChanged();
        } else {
            ExdeviceRankInfoUI.h(this.iFG);
        }
    }
}
