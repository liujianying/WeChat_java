package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.protocal.c.iq;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends l implements k {
    private b diG;
    private e diJ;

    public h(String str, String str2, int i, String str3, int i2, int i3) {
        a aVar = new a();
        aVar.dIG = new ip();
        aVar.dIH = new iq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
        aVar.dIF = 1064;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ip ipVar = (ip) this.diG.dID.dIL;
        ipVar.rjL = d.qVI;
        ipVar.rjM = d.qVH;
        ipVar.rjN = d.qVK;
        ipVar.rjO = d.qVL;
        ipVar.rjP = w.chP();
        ipVar.mEk = 11294;
        ipVar.rjQ = null;
        ipVar.mFz = str;
        ipVar.mFy = str2;
        ipVar.type = i;
        ipVar.value = str3;
        ipVar.count = i2;
        ipVar.lKQ = i3;
        x.v("MircoMsg.NetSceneScanProductReport", "statid:" + str2);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetSceneScanProductReport", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1064;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
