package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    a jjC;
    BroadcastReceiver jjD;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.jjC = new a((byte) 0);
        this.jjD = new 1(this);
    }

    public final void aNO() {
        try {
            ad.getContext().unregisterReceiver(this.jjD);
        } catch (IllegalArgumentException e) {
        }
    }

    static void a(a aVar, a aVar2) {
        m.BV("on mobile connected.");
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        com.tencent.mm.plugin.freewifi.f.b.kB(0);
    }

    static void b(a aVar, a aVar2) {
        m.BV("on wifi connected.");
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", aVar.toString(), aVar2.toString());
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.BV("on wifi roaming.");
            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", str, str2, str3);
        }
        com.tencent.mm.plugin.freewifi.f.b.kB(1);
    }
}
