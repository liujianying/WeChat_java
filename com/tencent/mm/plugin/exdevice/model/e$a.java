package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.h.a.b.a.f;
import com.tencent.mm.sdk.platformtools.x;

public class e$a implements b {
    private String bvw;
    final /* synthetic */ e iup;
    private String ius;
    private String iut;
    private String mURL;

    public e$a(e eVar, String str, String str2, String str3, String str4) {
        this.iup = eVar;
        this.ius = str;
        this.bvw = str2;
        this.mURL = str3;
        this.iut = str4;
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", new Object[]{str, str2});
    }

    public final void j(String str, String str2, boolean z) {
        if (this.bvw == null || !this.bvw.equals(str2)) {
            x.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", new Object[]{this.bvw, str2, Boolean.valueOf(z)});
        }
    }

    public final void b(String str, byte[] bArr, boolean z) {
        if (this.bvw == null || !this.bvw.equals(str)) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", new Object[]{this.bvw, str, Boolean.valueOf(z)});
        } else if (z && bArr != null) {
            try {
                ad.aHp();
                if (!e.c(this.bvw, this.ius, bArr)) {
                    x.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
            }
        }
    }

    public final void d(String str, int i, long j) {
        if (this.bvw == null || !this.bvw.equals(str)) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", new Object[]{this.bvw, str, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
        switch (i) {
            case 0:
                e.e(this.ius, this.mURL, 0, this.iut);
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", new Object[]{str});
                return;
            case 1:
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", new Object[]{str});
                e.e(this.ius, this.mURL, 1, this.iut);
                return;
            case 2:
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", new Object[]{str});
                e.e(this.ius, this.mURL, 2, this.iut);
                f fVar = new f();
                fVar.hhi = f.hin;
                fVar.hhj = 2;
                ad.aHp().o(this.bvw, com.tencent.mm.plugin.exdevice.j.b.bw(fVar));
                return;
            case 4:
                e.e(this.ius, this.mURL, 4, this.iut);
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", new Object[]{str});
                return;
            default:
                x.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
                e.e(this.ius, this.mURL, -1, this.iut);
                return;
        }
    }
}
