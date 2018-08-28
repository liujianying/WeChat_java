package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends p implements k, e {
    private final q dJM = new g();
    private boolean iMA = false;
    private String iMF = "";

    public final boolean aJr() {
        return true;
    }

    public final String aJs() {
        return this.iMF;
    }

    public t(long j, String str, String str2) {
        a aVar = (a) this.dJM.KV();
        aVar.iMt.rFO = p.iMG;
        aVar.iMt.rFP = j;
        aVar.iMt.shb = str2;
        aVar.iMt.sha = str;
    }

    final int g(e eVar) {
        this.dJM.KV();
        return a(eVar, this.dJM, this);
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final void a(l.a aVar) {
    }

    public final int getType() {
        return 930;
    }

    public final void c(int i, int i2, String str, q qVar) {
        boolean z = true;
        x.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        k.b bVar = (k.b) qVar.Id();
        if (i == 0 && i2 == 0) {
            this.iMA = bVar.iMu.shd == 0;
            this.iMF = bVar.iMu.shc;
            String str2 = "MicroMsg.NetSceneFaceVerifyFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.iMA);
            objArr[1] = Integer.valueOf(bVar.iMu.shd);
            if (bi.oW(this.iMF)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
            i2 = bVar.iMu.shd;
        } else if (!(bVar == null || bVar.iMu == null || bVar.iMu.shd == 0)) {
            x.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i2 = bVar.iMu.shd;
        }
        this.diJ.a(i, i2, str, this);
    }

    final void AQ(String str) {
        ((a) this.dJM.KV()).iMt.rFO = str;
    }

    protected final avt g(q qVar) {
        return ((k.b) qVar.Id()).iMu.rFR;
    }
}
