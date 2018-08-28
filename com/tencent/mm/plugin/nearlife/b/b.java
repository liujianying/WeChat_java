package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.qr;
import com.tencent.mm.protocal.c.qs;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends l implements k {
    private com.tencent.mm.ab.b dIy;
    private e lCQ;
    public String lCR;

    public b(String str, String str2, String str3, aqr aqr, int i, LinkedList<bhz> linkedList, String str4) {
        a aVar = new a();
        aVar.dIG = new qr();
        aVar.dIH = new qs();
        aVar.uri = "/cgi-bin/micromsg-bin/createpoi";
        aVar.dIF = 650;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dIy = aVar.KT();
        String aG = bi.aG(str4, "");
        String aG2 = bi.aG(null, "");
        qr qrVar = (qr) this.dIy.dID.dIL;
        qrVar.jPe = str;
        qrVar.ruY = str2;
        qrVar.rva = aqr;
        qrVar.hbF = i;
        if (linkedList != null) {
            qrVar.rvb = linkedList;
        }
        qrVar.rvc = aG;
        qrVar.rvd = aG2;
        qrVar.ruZ = str3;
        x.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[]{str, str2, str3, Float.valueOf(aqr.rms), Float.valueOf(aqr.rmr), Integer.valueOf(i), aG, aG2});
    }

    public final int getType() {
        return 650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.lCQ = eVar2;
        return a(eVar, this.dIy, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        qs qsVar = (qs) this.dIy.dIE.dIL;
        if (this.dIy.dIE.qWB != 0) {
            this.lCQ.a(i2, i3, str, this);
            return;
        }
        this.lCR = qsVar.rve;
        x.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.lCR);
        this.lCQ.a(i2, i3, str, this);
    }
}
