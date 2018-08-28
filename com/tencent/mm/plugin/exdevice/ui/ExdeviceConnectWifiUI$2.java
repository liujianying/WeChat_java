package com.tencent.mm.plugin.exdevice.ui;

import android.net.wifi.WifiInfo;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceConnectWifiUI$2 implements Runnable {
    final /* synthetic */ ExdeviceConnectWifiUI iCh;
    final /* synthetic */ String iCi;
    final /* synthetic */ String iCj;
    final /* synthetic */ WifiInfo iCk;

    ExdeviceConnectWifiUI$2(ExdeviceConnectWifiUI exdeviceConnectWifiUI, String str, String str2, WifiInfo wifiInfo) {
        this.iCh = exdeviceConnectWifiUI;
        this.iCi = str;
        this.iCj = str2;
        this.iCk = wifiInfo;
    }

    public final void run() {
        ExdeviceConnectWifiUI.f(this.iCh).acquire();
        int startAirKissWithInter = Java2CExDevice.startAirKissWithInter(this.iCi, this.iCj, ExdeviceConnectWifiUI.l(this.iCh), 60000, ExdeviceConnectWifiUI.m(this.iCh), ExdeviceConnectWifiUI.n(this.iCh));
        x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Start AirKiss result (%d). input ssid = %s, ssid by system = %s, bssid by system = %s", new Object[]{Integer.valueOf(startAirKissWithInter), this.iCj, this.iCk.getSSID(), this.iCk.getBSSID()});
    }
}
