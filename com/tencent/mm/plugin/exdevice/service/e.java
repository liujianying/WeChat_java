package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.g.a.dm;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.model.d.4;
import com.tencent.mm.plugin.exdevice.service.q.a;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    private static e iyH = new e();

    private e() {
    }

    public static e aHw() {
        return iyH;
    }

    public final boolean an(String str, boolean z) {
        x.i("MicroMsg.exdevice.ExdeviceIBeaconManager", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        if (str == null) {
            x.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "uuid is null");
            return false;
        } else if (u.aHG().isY != null) {
            return u.aHG().isY.a(str, z, this);
        } else {
            x.e("MicroMsg.exdevice.ExdeviceIBeaconManager", "MMExDeviceCore.getTaskQueue().getDispatcher() is null !!!now retry invoke doTaskAfterServiceStarted!");
            d aHl = ad.aHl();
            1 1 = new 1(this, str, z);
            x.d("MicroMsg.exdevice.ExdeviceConnectManager", "doTaskAfterServiceStarted");
            if (aHl.itd == null) {
                aHl.itd = new c();
                aHl.itd.iyE = new 4(aHl, 1);
                aHl.itd.dd(com.tencent.mm.sdk.platformtools.ad.getContext());
                return false;
            }
            aHl.itd.x(1);
            return false;
        }
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        x.d("MicroMsg.exdevice.ExdeviceIBeaconManager", "onRangdingCallback, distance = %f, major = %d, minor = %d, uuid = %s, rssi = %f,aMac = %s,txPower = %d", new Object[]{Double.valueOf(d), Integer.valueOf(i), Integer.valueOf(i2), b.aq(bArr), Double.valueOf(d2), str, Integer.valueOf(i3)});
        dm dmVar = new dm();
        String aq = b.aq(bArr);
        if (aq.length() >= 32) {
            aq = aq.substring(0, 8) + "-" + aq.substring(8, 12) + "-" + aq.substring(12, 16) + "-" + aq.substring(16, 20) + "-" + aq.substring(20);
        }
        dmVar.bLn.bLl = aq;
        dmVar.bLn.bLq = d;
        dmVar.bLn.bLo = i;
        dmVar.bLn.bLp = i2;
        dmVar.bLn.bLr = d2;
        dmVar.bLn.bLs = str;
        dmVar.bLn.bLt = i3;
        com.tencent.mm.sdk.b.a.sFg.m(dmVar);
    }
}
