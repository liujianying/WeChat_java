package com.tencent.mm.plugin.wear.ui;

import com.tencent.mm.plugin.wear.ui.WearYoUI.a;

class WearYoUI$3 implements Runnable {
    final /* synthetic */ WearYoUI pKt;

    WearYoUI$3(WearYoUI wearYoUI) {
        this.pKt = wearYoUI;
    }

    public final void run() {
        WearYoUI.c(this.pKt).vibrate(200);
        WearYoUI.d(this.pKt).animate().scaleX(1.2f);
        WearYoUI.d(this.pKt).animate().scaleY(1.2f);
        WearYoUI.d(this.pKt).animate().setDuration(200);
        WearYoUI.d(this.pKt).animate().start();
        WearYoUI.d(this.pKt).animate().setListener(new a(this.pKt, 1));
    }
}
