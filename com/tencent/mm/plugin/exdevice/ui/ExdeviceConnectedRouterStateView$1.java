package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceConnectedRouterStateView$1 implements Runnable {
    final /* synthetic */ ExdeviceConnectedRouterStateView iCH;

    ExdeviceConnectedRouterStateView$1(ExdeviceConnectedRouterStateView exdeviceConnectedRouterStateView) {
        this.iCH = exdeviceConnectedRouterStateView;
    }

    public final void run() {
        this.iCH.invalidate();
    }
}
