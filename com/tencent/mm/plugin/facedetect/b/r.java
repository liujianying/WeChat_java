package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.sdk.platformtools.x;

public final class r extends l implements k {
    private b diG;
    private e diJ;
    public String mFileName = "";

    public r(String str, long j, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.dIG = new vp();
        aVar.dIH = new vq();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        aVar.dIF = 1197;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.mFileName = str;
        vp vpVar = (vp) this.diG.dID.dIL;
        vpVar.bPS = str2;
        vpVar.ryO = j;
        vpVar.ryP = str4;
        vpVar.ryT = str3;
    }

    public final int getType() {
        return 1197;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
