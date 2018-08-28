package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class z extends l implements k {
    private b diG;
    private e diJ;
    private final b qAe;

    public z(b bVar, String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.dIG = new nd();
        aVar.dIH = new ne();
        aVar.uri = "/cgi-bin/micromsg-bin/checkbigfiledownload";
        aVar.dIF = 728;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.qAe = bVar;
        nd ndVar = (nd) this.diG.dID.dIL;
        ndVar.rmy = str;
        ndVar.rri = bVar.field_totalLen;
        ndVar.rrj = str2;
        ndVar.ecE = str3;
        ndVar.rrk = str4;
        ndVar.jTv = str5;
        au.HU();
        ndVar.jTu = (String) c.DT().get(2, "");
        ndVar.rdY = com.tencent.mm.modelcdntran.b.dOm;
        x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig AESKey[%s] FileMd5[%s] FileName[%s] FileExt[%s] FileSize[%d] FileType[%d] stack[%s]", new Object[]{bi.Xf(ndVar.rmy), ndVar.rrj, ndVar.ecE, ndVar.rrk, Long.valueOf(ndVar.rri), Integer.valueOf(ndVar.rdY), bi.cjd()});
    }

    public final int getType() {
        return 728;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            ne neVar = (ne) ((b) qVar).dIE.dIL;
            this.qAe.field_signature = neVar.eJK;
            this.qAe.field_fakeAeskey = neVar.rrm;
            this.qAe.field_fakeSignature = neVar.rrn;
            boolean c = ao.asF().c(this.qAe, new String[0]);
            x.i("MicroMsg.NetSceneCheckBigFileDownload", "summerbig onGYNetEnd field_signature[%s], field_fakeAeskey[%s], field_fakeSignature[%s], update[%b]", new Object[]{bi.Xf(this.qAe.field_signature), bi.Xf(this.qAe.field_fakeAeskey), bi.Xf(this.qAe.field_fakeSignature), Boolean.valueOf(c)});
        }
        this.diJ.a(i2, i3, str, this);
    }
}
