package com.tencent.mm.plugin.bottle.ui;

class ThrowBottleUI$7 implements Runnable {
    final /* synthetic */ ThrowBottleUI hnD;

    ThrowBottleUI$7(ThrowBottleUI throwBottleUI) {
        this.hnD = throwBottleUI;
    }

    public final void run() {
        ThrowBottleUI.y(this.hnD).stopTone();
    }
}
