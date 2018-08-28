package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceConnectWifiUI$6 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;

    ExdeviceConnectWifiUI$6(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        this.iCh = exdeviceConnectWifiUI;
    }

    public final void run() {
        if (ExdeviceConnectWifiUI.g(this.iCh) != null && ExdeviceConnectWifiUI.g(this.iCh).isShowing()) {
            ExdeviceConnectWifiUI.g(this.iCh).dismiss();
        }
    }
}
