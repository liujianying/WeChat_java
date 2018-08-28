package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    private static class a {
        private static b jkA = new b();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public static b aPg() {
        return a.jkA;
    }

    public static void J(Intent intent) {
        boolean z = true;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("free_wifi_ap_key");
            if (!m.isEmpty(stringExtra)) {
                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                if (2 == intExtra) {
                    intExtra = 11;
                } else if (3 == intExtra) {
                    intExtra = 12;
                } else if (4 == intExtra) {
                    intExtra = 13;
                } else {
                    intExtra = 1;
                }
                intent.putExtra("free_wifi_channel_id", intExtra);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.E(intent) + "_" + m.G(intent) + "_" + m.H(intent) + "_" + System.currentTimeMillis());
                boolean j = com.tencent.mm.plugin.freewifi.e.d.a.aPi().j(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
                com.tencent.mm.plugin.freewifi.k.a aOa = k.aOa();
                aOa.ssid = m.BS(TAG);
                aOa.bssid = m.BT(TAG);
                aOa.bIQ = stringExtra;
                aOa.jid = intent.getStringExtra("free_wifi_schema_ticket");
                aOa.jie = m.G(intent);
                aOa.jif = com.tencent.mm.plugin.freewifi.k.b.jiy.jiQ;
                aOa.jig = com.tencent.mm.plugin.freewifi.k.b.jiy.name;
                aOa.bVU = m.H(intent);
                aOa.result = j ? 0 : -1;
                k aOc = aOa.aOc();
                if (j) {
                    z = false;
                }
                aOc.b(intent, z).aOb();
                x.i(TAG, "getLock = " + j);
                m.BV("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + j);
                if (j) {
                    m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                    intent.setClass(ad.getContext(), FreeWifiNetCheckUI.class);
                    intent.addFlags(67108864);
                    d.b(ad.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                }
            }
        }
    }
}
