package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.plugin.freewifi.b.a.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public final synchronized void a(ew ewVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String BQ = m.BQ(ewVar.bMD.ssid);
        final String str = ewVar.bMD.bssid;
        if (m.isEmpty(BQ)) {
            a(ewVar, 1141, "Ssid is empty.");
        } else if (m.isEmpty(str)) {
            a(ewVar, 1142, "Bssid is empty.");
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + ewVar.bMD.ssid + "; bssid=" + ewVar.bMD.bssid + "; version=" + ewVar.bMD.version);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            com.tencent.mm.plugin.freewifi.b.a.b cO = a.aOl().cO(BQ, str);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (cO != null) {
                final String str2 = cO.bIQ;
                int i = cO.jie;
                if (i == 4) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    ah.A(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.aOe());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            d.b(ad.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    });
                    a(ewVar, 1, null);
                } else if (i == 31) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    ah.A(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", BQ);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(ad.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(268435456);
                            ad.getContext().startActivity(intent);
                        }
                    });
                    a(ewVar, 1, null);
                } else {
                    a(ewVar, 1143, "Wechant installed Currently doesn't support connect protocol " + i);
                }
            } else if (a.aOl().size() == 0) {
                a(ewVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
            } else {
                a(ewVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
            }
        }
    }

    private static void a(ew ewVar, int i, String str) {
        ewVar.bME.bMH = i;
        ewVar.bME.bMI = str;
        ewVar.bME.bMG = 1;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (ewVar.bJX != null) {
            ewVar.bJX.run();
        }
    }
}
