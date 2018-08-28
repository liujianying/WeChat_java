package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    boolean heV;
    a jka;
    BroadcastReceiver jkb;

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.heV = false;
        this.jkb = new 1(this);
    }

    public final boolean a(a aVar) {
        if (this.heV) {
            return false;
        }
        this.heV = true;
        this.jka = aVar;
        WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            x.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            return false;
        }
        ad.getContext().registerReceiver(this.jkb, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        return true;
    }
}
