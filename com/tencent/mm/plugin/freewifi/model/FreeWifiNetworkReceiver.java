package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public b jjY;
    public a jjZ;

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            return;
        }
        String action = intent.getAction();
        x.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", new Object[]{action});
        if (bi.oW(action)) {
            x.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            x.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", new Object[]{Integer.valueOf(intent.getIntExtra("wifi_state", 0))});
            if (this.jjY != null) {
                this.jjY.qa(r0);
            }
        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                if (networkInfo != null && this.jjZ != null) {
                    this.jjZ.a(networkInfo.getState());
                }
            }
        }
    }
}
