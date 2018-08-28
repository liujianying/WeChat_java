package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceRankInfoUI$1 implements Runnable {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$1(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final void run() {
        ExdeviceRankInfoUI.b(this.iFG).iEH = ExdeviceRankInfoUI.a(this.iFG);
        ExdeviceRankInfoUI.b(this.iFG).notifyDataSetChanged();
        ExdeviceRankInfoUI.c(this.iFG);
    }
}
