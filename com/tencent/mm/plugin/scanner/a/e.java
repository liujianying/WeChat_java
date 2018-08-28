package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    public b diG;
    private com.tencent.mm.ab.e diJ;
    private int djw = 1;
    private byte[] mFL;
    private String mFM = "en";
    private String mFN = "zh_CN";
    private int mFO;

    public e(byte[] bArr, String str, String str2, int i) {
        this.mFL = bArr;
        this.djw = 1;
        this.mFM = str;
        this.mFN = str2;
        this.mFO = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new awh();
        aVar.dIH = new awi();
        aVar.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        aVar.dIF = 392;
        aVar.dII = 199;
        aVar.dIJ = 1000000199;
        this.diG = aVar.KT();
        awh awh = (awh) this.diG.dID.dIL;
        awh.rjz = ((int) bi.VF()) & Integer.MAX_VALUE;
        awh.rjA = new bhy().bq(this.mFL);
        awh.rjD = this.djw;
        awh.rZC = this.mFM;
        awh.rZD = this.mFN;
        awh.rjE = this.mFO;
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        awh awh = (awh) ((b) qVar).dID.dIL;
        if (awh.rjz > 0 && !bi.oW(awh.rZD) && !bi.oW(awh.rZC) && awh.rjD >= 0 && awh.rjA != null && awh.rjA.siI > 0) {
            return l.b.dJm;
        }
        x.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
        return l.b.dJn;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 392;
    }
}
