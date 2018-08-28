package com.tencent.mm.plugin.freewifi.model;

import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.e.c.1;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.f.a;
import com.tencent.mm.plugin.freewifi.model.f.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class j$10 extends c<ge> {
    final /* synthetic */ j jkt;

    j$10(j jVar) {
        this.jkt = jVar;
        this.sFo = ge.class.getName().hashCode();
    }

    private static boolean a(ge geVar) {
        if (geVar.bPq.data == "MAIN_UI_EVENT_UPDATE_VIEW" && m.aOd()) {
            String str = "InterruptedProtocol31-" + System.currentTimeMillis();
            b aOE = a.aOG().aOE();
            if (!(aOE == null || aOE.jjS || System.currentTimeMillis() - aOE.jjF > 180000 || m.isEmpty(aOE.jjQ) || m.isEmpty(aOE.jjP) || m.isEmpty(aOE.jjR))) {
                x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", new Object[]{str, Integer.valueOf(1), aOE.jjP, aOE.jjQ, aOE.jjR, Long.valueOf(aOE.jjF)});
                WifiInfo aOA = d.aOA();
                x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. wifiinfo = %s", new Object[]{str, Integer.valueOf(2), aOA});
                if (aOA != null) {
                    String BQ = m.BQ(aOA.getSSID());
                    if (m.BQ(aOE.jjP).equals(BQ)) {
                        String bssid = aOA.getBSSID();
                        String macAddress = aOA.getMacAddress();
                        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                            macAddress = m.aOf();
                        }
                        synchronized (a.aOG()) {
                            if (aOE != a.aOG().aOE()) {
                            } else {
                                x.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", new Object[]{str, Integer.valueOf(3), BQ, bssid, macAddress});
                                new g(BQ, bssid, macAddress).b(new 1(str, aOE));
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
