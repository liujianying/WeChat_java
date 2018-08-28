package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k, e {
    private b diG;
    private e diJ;
    private boolean iMA = false;
    public String iMB = null;
    public boolean iMC = false;
    private String iMD = "";

    public m(long j, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.dIG = new vn();
        aVar.dIH = new vo();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/faceidentify";
        aVar.dIF = 1080;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        vn vnVar = (vn) this.diG.dID.dIL;
        vnVar.bPS = str;
        vnVar.ryO = j;
        vnVar.ryI = str2;
        vnVar.ryQ = str3;
        vnVar.ryP = str4;
    }

    public final int getType() {
        return 1080;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneFaceVerifyFace", "alvinluo NetSceneFacePicThirdVerifyFace errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        vo voVar = (vo) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneFaceVerifyFace", "identity_id: %s", new Object[]{voVar.ryR});
        this.iMB = voVar.ryR;
        this.iMC = voVar.ryS;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final String aJs() {
        return this.iMB;
    }

    public final boolean aJr() {
        return this.iMC;
    }
}
