package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.x;

class FreeWifiStateUI$8 implements Runnable {
    final /* synthetic */ FreeWifiStateUI jnZ;

    FreeWifiStateUI$8(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final void run() {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.jnZ.ssid});
        this.jnZ.aPp();
    }
}
