package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azk;
import com.tencent.mm.protocal.c.azl;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private b diG;
    private e diJ;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new azk();
        aVar.dIH = new azl();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
        aVar.dIF = 1767;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        azk azk = (azk) this.diG.dID.dIL;
        azk.jQb = str;
        azk.rsx = str4;
        azk.rsw = str2;
        azk.rsy = str5;
        azk.rsz = str6;
        azk.rhq = str3;
        azk.rrC = str7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        azl azl = (azl) ((b) qVar).dIE.dIL;
        if (i3 == 0 && i2 == 0) {
            i3 = azl.iwS;
            str = azl.iwT;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1767;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
