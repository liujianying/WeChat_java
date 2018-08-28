package com.tencent.mm.plugin.game.model.a;

import android.content.IntentFilter;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class d {
    private static int icD = -1;
    private static b jOJ;
    private static a jOK;
    private static b jOL;
    private static c jOM = new 1();
    private static c jON = new 2();

    public static void aDb() {
        if (jOJ == null) {
            jOJ = new b((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ad.getContext().registerReceiver(jOJ, intentFilter);
        if (jOK == null) {
            jOK = new a((byte) 0);
        }
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        ad.getContext().registerReceiver(jOK, intentFilter);
        a.sFg.b(jOM);
        a.sFg.b(jON);
        if (jOL == null) {
            jOL = new b();
        }
        com.tencent.mm.plugin.downloader.model.d.aCU();
        b.a(jOL);
    }

    public static void aDc() {
        if (jOJ != null) {
            ad.getContext().unregisterReceiver(jOJ);
            jOJ = null;
        }
        if (jOK != null) {
            ad.getContext().unregisterReceiver(jOK);
            jOK = null;
        }
        a.sFg.c(jOM);
        a.sFg.c(jON);
        if (jOL != null) {
            com.tencent.mm.plugin.downloader.model.d.aCU();
            b.b(jOL);
            jOL = null;
        }
    }
}
