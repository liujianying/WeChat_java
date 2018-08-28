package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends BroadcastReceiver {
    final /* synthetic */ b jjE;

    b$1(b bVar) {
        this.jjE = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            try {
                x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                    return;
                }
                x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[]{Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable())});
                if (!networkInfo.isConnected()) {
                    x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                    x.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                } else if (context == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                } else if (networkInfo.getType() == 1) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManager is null.");
                        return;
                    }
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiInfo is null.");
                        return;
                    }
                    String BQ = m.BQ(connectionInfo.getSSID());
                    String toLowerCase = m.BR(connectionInfo.getBSSID()).toLowerCase();
                    x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[]{m.BQ(m.BR(networkInfo.getExtraInfo())), BQ, toLowerCase});
                    if (!m.BR(m.BQ(m.BR(networkInfo.getExtraInfo()))).equals(BQ)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                    } else if (this.jjE.jjC.type == 1 && m.BR(this.jjE.jjC.ssid).equals(BQ) && m.BR(this.jjE.jjC.bssid).equals(toLowerCase)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                    } else {
                        a aVar = new a((byte) 0);
                        aVar.jjF = System.currentTimeMillis();
                        aVar.type = 1;
                        aVar.ssid = BQ;
                        aVar.bssid = toLowerCase;
                        aVar.jjG = "";
                        b.b(this.jjE.jjC.aOt(), aVar);
                        this.jjE.jjC = aVar;
                    }
                } else if (networkInfo.getType() != 0) {
                } else {
                    if (this.jjE.jjC.type == 0 && m.BR(this.jjE.jjC.jjG).equals(m.BR(networkInfo.getExtraInfo()))) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                        return;
                    }
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                        return;
                    }
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                    if (networkInfo2 == null) {
                        x.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                        return;
                    }
                    x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[]{networkInfo2.getState(), networkInfo2.getDetailedState()});
                    if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                        return;
                    }
                    a aVar2 = new a((byte) 0);
                    aVar2.jjF = System.currentTimeMillis();
                    aVar2.type = 0;
                    aVar2.ssid = "";
                    aVar2.bssid = "";
                    aVar2.jjG = m.BR(networkInfo.getExtraInfo());
                    b.a(this.jjE.jjC.aOt(), aVar2);
                    this.jjE.jjC = aVar2;
                }
            } catch (Exception e) {
                k.a aOa = k.aOa();
                aOa.bIQ = "UnExpectedException";
                aOa.result = -1;
                aOa.hKX = m.g(e);
                aOa.aOc().aOb();
                x.e("MicroMsg.FreeWifi.UnExcepctedException", m.h(e));
            }
        }
    }
}
