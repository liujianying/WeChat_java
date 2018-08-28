package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cx;
import com.tencent.mm.plugin.exdevice.h.a;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.plugin.exdevice.service.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$10 extends w {
    final /* synthetic */ d itl;

    d$10(d dVar) {
        this.itl = dVar;
    }

    public final void a(long j, int i, int i2, int i3, long j2) {
        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "onStateChange, deviceId = %s, oldSate = %d, newState = %d, errCode = %d", new Object[]{b.cY(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (ad.getContext() == null) {
            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "MMApplicationContext is null");
            return;
        }
        if (4 == i2) {
            u.aHF().cQ(j);
            long[] Aj = a.Aj("shut_down_device");
            if (!(Aj == null || Aj.length == 0)) {
                for (long j3 : Aj) {
                    if (j3 == j) {
                        x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Stop channel in the shut down device list, deviceId = %d", new Object[]{Long.valueOf(j3)});
                        d.cB(j3);
                        if (!a.B("shut_down_device", j3)) {
                            x.e("MicroMsg.exdevice.ExdeviceConnectManager", "removeFromSharedPreferences failed!!!");
                        }
                    }
                }
            }
            if (d.e(this.itl).get(Long.valueOf(j)) != null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Device connect strategy(%d)", new Object[]{d.e(this.itl).get(Long.valueOf(j))});
                cx cxVar = new cx();
                com.tencent.mm.sdk.b.a.sFg.m(cxVar);
                if (!(cxVar.bKs.bAL && (((Integer) d.e(this.itl).get(Long.valueOf(j))).intValue() & 1) == 1)) {
                    d.cB(j);
                }
            } else {
                d.cB(j);
            }
        }
        if (i != i2) {
            com.tencent.mm.plugin.exdevice.h.b Ak = ad.aHe().Ak(String.valueOf(j));
            if (Ak == null || bi.oW(Ak.field_brandName)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "get hdinfo by mac failed : %d", new Object[]{Long.valueOf(j)});
                return;
            }
            f.a cN = u.aHF().cN(j);
            if (cN != null) {
                cN.bLv = i2;
            } else {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "get connect state faild : %d", new Object[]{Long.valueOf(j)});
            }
            if (i2 == 2) {
                x.w("MicroMsg.exdevice.ExdeviceConnectManager", "newState = EMMACCS_connected");
                return;
            }
            ad.aHp();
            e.e(Ak.field_brandName, Ak.field_url, i2, Ak.field_deviceID);
        }
    }
}
