package com.tencent.mm.plugin.offline.ui;

import android.view.View;

class OfflineAlertView$1 implements Runnable {
    final /* synthetic */ int bpX = 2;
    final /* synthetic */ View lKU;
    final /* synthetic */ Runnable lKV;
    final /* synthetic */ Runnable lKW;
    final /* synthetic */ OfflineAlertView lKX;

    OfflineAlertView$1(OfflineAlertView offlineAlertView, View view, Runnable runnable, Runnable runnable2) {
        this.lKX = offlineAlertView;
        this.lKU = view;
        this.lKV = runnable;
        this.lKW = runnable2;
    }

    public final void run() {
        OfflineAlertView.a(this.lKX, this.lKU, this.lKV, this.lKW, this.bpX);
    }
}
