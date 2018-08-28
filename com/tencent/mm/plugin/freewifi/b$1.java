package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends BroadcastReceiver {
    final /* synthetic */ b jhF;

    b$1(b bVar) {
        this.jhF = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", this.jhF.ssid, m.BS("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.jhF.ssid.equals(m.BQ(networkInfo.getExtraInfo()))) {
                try {
                    this.jhF.jhz.lock();
                    this.jhF.jhA = true;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                    this.jhF.bvW.signalAll();
                } finally {
                    this.jhF.jhz.unlock();
                }
            }
        } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", this.jhF.ssid, m.BS("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString());
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.jhF.ssid.equals(m.BQ(networkInfo.getExtraInfo()))) {
                try {
                    this.jhF.jhz.lock();
                    this.jhF.jhB = true;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                    this.jhF.bvW.signalAll();
                } finally {
                    this.jhF.jhz.unlock();
                }
            }
        }
    }
}
