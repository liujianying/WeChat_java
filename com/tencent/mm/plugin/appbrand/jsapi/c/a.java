package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static BroadcastReceiver fKZ;
    public static boolean fLa;
    public static Map<String, a> map = new ConcurrentHashMap();

    public static void a(String str, a aVar) {
        map.put(str, aVar);
        if (fKZ == null) {
            x.i("MicroMsg.BeaconManager", "bluetoothStateListener init");
            fKZ = new 1();
            ad.getContext().registerReceiver(fKZ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public static a tz(String str) {
        return (a) map.get(str);
    }

    public static void remove(String str) {
        map.remove(str);
        x.i("MicroMsg.BeaconManager", "remove Beacon appid:%s", new Object[]{str});
        if (map.size() == 0 && fKZ != null) {
            x.i("MicroMsg.BeaconManager", "bluetoothStateListener uninit");
            ad.getContext().unregisterReceiver(fKZ);
            fKZ = null;
        }
    }
}
