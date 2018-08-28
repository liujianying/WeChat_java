package com.tencent.mm.plugin.freewifi.ui;

class FreeWifiManufacturerLoadingUI$6 implements Runnable {
    final /* synthetic */ FreeWifiManufacturerLoadingUI jnE;

    FreeWifiManufacturerLoadingUI$6(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        this.jnE = freeWifiManufacturerLoadingUI;
    }

    public final void run() {
        FreeWifiManufacturerLoadingUI.d(this.jnE).setVisibility(0);
    }
}
