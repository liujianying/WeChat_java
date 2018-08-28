package com.tencent.mm.plugin.fav.ui;

class FavCleanUI$7 implements Runnable {
    final /* synthetic */ FavCleanUI iYA;

    FavCleanUI$7(FavCleanUI favCleanUI) {
        this.iYA = favCleanUI;
    }

    public final void run() {
        if (FavCleanUI.e(this.iYA) != null) {
            FavCleanUI.e(this.iYA).aMD();
        }
        this.iYA.aMg();
    }
}
