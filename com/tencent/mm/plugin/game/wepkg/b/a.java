package com.tencent.mm.plugin.game.wepkg.b;

import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static int icD = -1;
    private static a kdV;

    public static void aDb() {
        if (kdV == null) {
            kdV = new a((byte) 0);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ad.getContext().registerReceiver(kdV, intentFilter);
        } catch (Exception e) {
        }
        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader startListen");
    }

    public static void aDc() {
        if (kdV != null) {
            try {
                ad.getContext().unregisterReceiver(kdV);
            } catch (Exception e) {
            }
        }
        kdV = null;
        x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "WepkgAutoDownloader stopListen");
    }
}
