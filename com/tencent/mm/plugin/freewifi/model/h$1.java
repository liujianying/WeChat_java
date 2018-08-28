package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.plugin.freewifi.model.h.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class h$1 extends BroadcastReceiver {
    final /* synthetic */ h jkc;

    h$1(h hVar) {
        this.jkc = hVar;
    }

    public final void onReceive(Context context, Intent intent) {
        int i = 0;
        if (context == null || intent == null) {
            x.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
            return;
        }
        this.jkc.heV = false;
        context.unregisterReceiver(this.jkc.jkb);
        if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
            WifiManager wifiManager = (WifiManager) ad.getContext().getSystemService(TencentLocationListener.WIFI);
            if (wifiManager == null) {
                x.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                return;
            }
            List scanResults;
            try {
                scanResults = wifiManager.getScanResults();
            } catch (SecurityException e) {
                scanResults = new ArrayList(0);
                x.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e.getMessage());
            }
            h hVar = this.jkc;
            if (scanResults != null && scanResults.size() > 20) {
                Collections.sort(scanResults, new 2(hVar));
                scanResults = scanResults.subList(0, 20);
            }
            String str = "MicroMsg.FreeWifi.WifiScanReceiver";
            StringBuilder stringBuilder = new StringBuilder("wifiManager scanResults size = ");
            if (scanResults != null) {
                i = scanResults.size();
            }
            x.i(str, stringBuilder.append(i).toString());
            if (this.jkc.jka != null) {
                this.jkc.jka.bh(scanResults);
            }
        }
    }
}
