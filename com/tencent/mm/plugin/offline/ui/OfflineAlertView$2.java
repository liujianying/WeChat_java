package com.tencent.mm.plugin.offline.ui;

import android.view.View;

class OfflineAlertView$2 implements Runnable {
    final /* synthetic */ int bpX = 4;
    final /* synthetic */ View lKU;
    final /* synthetic */ OfflineAlertView lKX;

    OfflineAlertView$2(OfflineAlertView offlineAlertView, View view) {
        this.lKX = offlineAlertView;
        this.lKU = view;
    }

    public final void run() {
        OfflineAlertView.a(this.lKX, this.lKU, this.bpX);
    }
}
