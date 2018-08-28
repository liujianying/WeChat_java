package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.da;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$5 extends c<da> {
    final /* synthetic */ e iup;

    e$5(e eVar) {
        this.iup = eVar;
        this.sFo = da.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        da daVar = (da) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", new Object[]{daVar.bKA.bKC, daVar.bKA.byN, Boolean.valueOf(daVar.bKA.bKD)});
        String str = daVar.bKA.bKC;
        String str2 = daVar.bKA.byN;
        boolean z2 = daVar.bKA.bKD;
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", new Object[]{str, str2, Boolean.valueOf(z2)});
        } else {
            com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(str2);
            if (Al == null) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", new Object[]{str2});
            } else if (!Al.field_brandName.equals(str)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", new Object[]{Al.field_brandName, str});
            } else if (bi.oV(Al.field_connProto).contains("4")) {
                e.e(str, Al.field_url, -1, Al.field_deviceType);
                e.bj(str, -1);
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
            } else if (a.atY()) {
                e.bj(str, -1);
                int a = e.a(Al);
                if (a == 1) {
                    if (!a.atW()) {
                        x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                    }
                } else if (a == 0 && !a.cT(ad.getContext())) {
                    e.bj(str, 1);
                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                }
                if (z2) {
                    if (aa.aHb().iuY) {
                        aa.aHb().pa(a);
                    }
                    d aHl = ad.aHl();
                    if (!(aHl.ith == null || aHl.ith.size() == 0)) {
                        aHl.ith.clear();
                    }
                    ad.aHl().a(Al.field_brandName, Al.field_mac, a);
                } else {
                    ad.aHl();
                    d.cB(Al.field_mac);
                }
                z = true;
            } else {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                e.bj(str, 0);
            }
        }
        daVar.bKB.bKE = z;
        return z;
    }
}
