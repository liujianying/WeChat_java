package com.tencent.mm.plugin.bottle.ui;

class BottleBeachUI$1 implements Runnable {
    final /* synthetic */ BottleBeachUI hkL;

    BottleBeachUI$1(BottleBeachUI bottleBeachUI) {
        this.hkL = bottleBeachUI;
    }

    public final void run() {
        if (BottleBeachUI.a(this.hkL) != null && BottleBeachUI.b(this.hkL) == 0 && BottleBeachUI.c(this.hkL)) {
            BottleBeachUI.d(this.hkL);
        }
    }
}
