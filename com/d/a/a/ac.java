package com.d.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class ac extends e {
    private final WifiManager bnh;

    ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.bnh = wifiManager;
    }

    final void sv() {
        this.bnh.startScan();
    }
}
