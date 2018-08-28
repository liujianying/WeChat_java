package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.ui.u;

class OfflineAlertView$6 extends u {
    final /* synthetic */ Runnable lKW;
    final /* synthetic */ OfflineAlertView lKX;

    OfflineAlertView$6(OfflineAlertView offlineAlertView, Runnable runnable) {
        this.lKX = offlineAlertView;
        this.lKW = runnable;
    }

    public final void aBU() {
        this.lKW.run();
    }
}
