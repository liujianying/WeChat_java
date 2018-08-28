package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.ui.u;

class OfflineAlertView$5 extends u {
    final /* synthetic */ Runnable lKV;
    final /* synthetic */ OfflineAlertView lKX;

    OfflineAlertView$5(OfflineAlertView offlineAlertView, Runnable runnable) {
        this.lKX = offlineAlertView;
        this.lKV = runnable;
    }

    public final void aBU() {
        this.lKV.run();
    }
}
