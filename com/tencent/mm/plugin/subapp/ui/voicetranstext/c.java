package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bws;
import com.tencent.mm.protocal.c.bwt;
import com.tencent.mm.protocal.c.bwu;
import com.tencent.mm.protocal.c.byo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class c extends l implements k {
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private String bZR;
    private b dIy;
    private e lCQ;
    private String mFileName;
    private String otU;
    private byo otW;
    private int otY;
    private String otZ;
    public bws oue;

    public c(c cVar) {
        this.otU = cVar.otU;
        this.otW = cVar.otW;
        this.oue = cVar.oue;
        this.mFileName = cVar.mFileName;
        this.otY = cVar.otY;
        this.otZ = cVar.otZ;
        this.bZR = cVar.bZR;
        x.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[]{Integer.valueOf(cVar.otY), cVar.otZ, cVar.bZR});
        bGD();
    }

    public c(String str, bws bws, int i, String str2) {
        Assert.assertTrue(str2 != null);
        this.otU = str;
        this.oue = bws;
        this.otW = d.aI(i, str2);
        this.mFileName = str2;
        bGD();
    }

    public c(String str, bws bws, int i, String str2, int i2, String str3, String str4) {
        Assert.assertTrue(str2 != null);
        x.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[]{Integer.valueOf(i2), str3, str4});
        this.otU = str;
        this.oue = bws;
        this.otW = d.aI(i, str2);
        this.mFileName = str2;
        this.otY = i2;
        this.otZ = str3;
        this.bZR = str4;
        bGD();
    }

    public final int getType() {
        return 547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.lCQ = eVar2;
        Object obj = (bi.oW(this.mFileName) || bi.oW(this.otU) || this.oue == null || this.otW == null) ? null : 1;
        if (obj == null) {
            x.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            return -1;
        }
        bwt bwt = (bwt) this.dIy.dID.dIL;
        bwt.rsZ = this.otU;
        bwt.rta = this.otW;
        bwt.rtc = this.oue;
        String str = this.mFileName;
        int i = this.oue.rdW;
        int i2 = this.oue.rdX;
        bhy bhy = new bhy();
        com.tencent.mm.modelvoice.b ok = q.ok(str);
        if (ok != null) {
            bhy = ab.O(ok.br(i, i2).buf);
        }
        bwt.rtW = bhy;
        bwt.otY = this.otY;
        bwt.jTv = this.otZ;
        bwt.jTu = this.bZR;
        return a(eVar, this.dIy, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bGE();
        if (i2 == 0 && i3 == 0) {
            this.oue = ((bwu) this.dIy.dIE.dIL).rtc;
        } else {
            x.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.lCQ.a(i2, i3, str, this);
        if (bGE()) {
            boolean z;
            String str2 = "MicroMsg.NetSceneUploadVoiceForTrans";
            String str3 = "succeeed finish: %B";
            Object[] objArr = new Object[1];
            if (this.oue != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
        }
    }

    private void bGD() {
        a aVar = new a();
        aVar.dIG = new bwt();
        aVar.dIH = new bwu();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.dIF = 547;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dIy = aVar.KT();
    }

    public final boolean bGE() {
        if (this.oue == null || this.oue.rdX <= 0) {
            return true;
        }
        return false;
    }
}
