package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;

public final class aa extends l implements k {
    private b diG;
    private e diJ;
    private final a qAf;

    public aa(a aVar, String str, String str2, a aVar2) {
        b.a aVar3 = new b.a();
        aVar3.dIG = new nf();
        aVar3.dIH = new ng();
        aVar3.uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
        this.diG = aVar3.KT();
        nf nfVar = (nf) this.diG.dID.dIL;
        if (aVar != null) {
            nfVar.rmy = aVar.dwK;
            nfVar.rrj = aVar.filemd5;
            nfVar.ecE = aVar.title;
            nfVar.rrk = aVar.dwp;
            nfVar.rri = (long) aVar.dwo;
        } else {
            g.NE();
            nfVar.rmy = com.tencent.mm.modelcdntran.b.Nw();
            g.NE();
            nfVar.rrj = com.tencent.mm.modelcdntran.b.lq(str);
            nfVar.ecE = com.tencent.mm.a.e.cq(str);
            nfVar.rrk = com.tencent.mm.a.e.cp(str);
            nfVar.rri = (long) com.tencent.mm.a.e.cm(str);
        }
        nfVar.rdY = com.tencent.mm.modelcdntran.b.dOm;
        nfVar.jTu = str2;
        nfVar.jTv = q.GF();
        this.qAf = aVar2;
        x.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", aVar, nfVar.rmy, nfVar.rrj, nfVar.ecE, Long.valueOf(nfVar.rri), nfVar.rrk, nfVar.jTu, nfVar.jTv, bi.cjd());
    }

    public final int getType() {
        return 727;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
            nf nfVar = (nf) ((b) qVar).dID.dIL;
            ng ngVar = (ng) ((b) qVar).dIE.dIL;
            x.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", ngVar.eJK, Integer.valueOf(ngVar.rrl), ngVar.rrm, ngVar.rrn);
            if (this.qAf != null) {
                this.qAf.a(nfVar.rrj, nfVar.rmy, ngVar.eJK, ngVar.rrm, ngVar.rrn, nfVar.rri);
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
        if (this.qAf != null) {
            this.qAf.a("", "", "", "", "", 0);
        }
    }
}
