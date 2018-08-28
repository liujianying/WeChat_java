package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.BleScanWorker.3;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.a.2;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static BroadcastReceiver fKZ;
    public static boolean fLa;
    public static com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.a fLb = new 1();
    private static Map<String, b> map = new ConcurrentHashMap();

    public static j a(String str, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a aVar, h hVar, g gVar) {
        x.i("MicroMsg.Ble.BleManager", "open appId:%s", new Object[]{str});
        boolean z = !d.fS(18) && ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (z) {
            if (!map.containsKey(str)) {
                b bVar;
                x.w("MicroMsg.Ble.BleManager", "already open appId:%s", new Object[]{str});
                b bVar2 = new b(str);
                bVar2.fLc = new b(ad.getContext());
                b bVar3 = bVar2.fLc;
                c cVar = bVar3.fLH;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
                if (cVar.fLQ == null) {
                    cVar.fLQ = new ConcurrentHashMap();
                }
                cVar.fLQ.clear();
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.a aVar2 = bVar3.fLI;
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.i("MicroMsg.Ble.BleScanWorker", "init", new Object[0]);
                aVar2.fMR.set(true);
                aVar2.fMP = new HashMap();
                aVar2.fMS = new ArrayList();
                aVar2.fMN = new 2(aVar2);
                String str2 = "middle";
                if (str2.equals("low")) {
                    aVar2.fMO = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.ScanSettingsCompat.a().kD(0).aiy();
                } else if (str2.equals("middle")) {
                    aVar2.fMO = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.ScanSettingsCompat.a().kD(1).aiy();
                } else if (str2.equals("high")) {
                    aVar2.fMO = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.ScanSettingsCompat.a().kD(2).aiy();
                } else {
                    aVar2.fMO = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.scan.ScanSettingsCompat.a().kD(0).aiy();
                }
                if (aVar2.fKZ == null) {
                    x.i("MicroMsg.Ble.BleScanWorker", "bluetoothStateListener init");
                    aVar2.fKZ = new 3(aVar2);
                    aVar2.context.registerReceiver(aVar2.fKZ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                }
                bVar2.fLd = aVar;
                if (bVar2.fLc != null) {
                    bVar = bVar2.fLc;
                    if (bVar.fLH != null) {
                        bVar.fLH.fLR = hVar;
                    }
                }
                if (bVar2.fLc != null) {
                    bVar = bVar2.fLc;
                    if (bVar.fLH != null) {
                        bVar.fLH.fLS = gVar;
                    }
                }
                map.put(str, bVar2);
                e.a(str, bVar2);
                aip();
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.a.fNU = fLb;
            }
            if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiB()) {
                return j.fMv;
            }
            x.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
            return j.fMy;
        }
        x.e("MicroMsg.Ble.BleManager", "api version is below 18");
        return j.fMG;
    }

    public static b tr(String str) {
        return (b) map.get(str);
    }

    public static j ts(String str) {
        x.i("MicroMsg.Ble.BleManager", "close appId:%s", new Object[]{str});
        if (!map.containsKey(str)) {
            return j.fMv;
        }
        b bVar = (b) map.remove(str);
        e.b(str, bVar);
        bVar.uninit();
        if (map.size() == 0) {
            aiq();
        }
        return j.fMv;
    }

    private static synchronized void aip() {
        synchronized (a.class) {
            if (fKZ == null) {
                x.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
                fKZ = new 2();
                ad.getContext().registerReceiver(fKZ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                fLa = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.d.b.aiB();
            }
        }
    }

    private static synchronized void aiq() {
        synchronized (a.class) {
            if (fKZ != null) {
                x.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
                ad.getContext().unregisterReceiver(fKZ);
                fKZ = null;
            }
        }
    }
}
