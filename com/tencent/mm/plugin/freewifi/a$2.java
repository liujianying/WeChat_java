package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends BroadcastReceiver {
    final /* synthetic */ a jhE;

    a$2(a aVar) {
        this.jhE = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.jhE.ssid, m.BS("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.jhE.ssid.equals(m.BQ(networkInfo.getExtraInfo()))) {
                try {
                    this.jhE.jhz.lock();
                    this.jhE.jhA = true;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                    this.jhE.bvW.signalAll();
                } finally {
                    this.jhE.jhz.unlock();
                }
            }
        } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            if (networkInfo != null) {
                x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.jhE.ssid, m.BS("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
            }
            if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.jhE.ssid.equals(m.BQ(networkInfo.getExtraInfo()))) {
                try {
                    this.jhE.jhz.lock();
                    this.jhE.jhB = true;
                    x.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                    this.jhE.bvW.signalAll();
                } finally {
                    this.jhE.jhz.unlock();
                }
            }
        }
    }
}
