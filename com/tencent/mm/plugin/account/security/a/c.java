package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bvd;
import com.tencent.mm.protocal.c.bve;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public String bKv;
    public String byN;
    public String deviceName;
    private b diG;
    private e diJ;

    public c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new bvd();
        aVar.dIH = new bve();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        aVar.dIF = 361;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.byN = str;
        this.deviceName = str2;
        this.bKv = str3;
        bvd bvd = (bvd) this.diG.dID.dIL;
        bvd.rvq = str;
        bvd.jPe = str2;
        bvd.reT = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.oW(this.byN) || bi.oW(this.deviceName) || bi.oW(this.bKv)) {
            x.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            return -1;
        }
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
