package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ab extends l implements k {
    private b diG;
    private e diJ;
    private a qAg;

    public interface a {
        void ac(String str, int i, int i2);
    }

    public ab(String str, String str2, String str3, int i, a aVar) {
        com.tencent.mm.ab.b.a aVar2 = new com.tencent.mm.ab.b.a();
        aVar2.dIG = new oc();
        aVar2.dIH = new od();
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmd5";
        aVar2.dIF = 939;
        aVar2.dII = 0;
        aVar2.dIJ = 0;
        this.diG = aVar2.KT();
        oc ocVar = (oc) this.diG.dID.dIL;
        ocVar.fileid = str;
        ocVar.bKg = str2;
        ocVar.rsn = str3;
        ocVar.rso = i;
        this.qAg = aVar;
        x.i("MicroMsg.NetSceneCheckMd5", "summersafecdn NetSceneCheckMd5 fileid[%s], md5[%s], newmd5[%s], crc[%d], stack[%s]", new Object[]{ocVar.fileid, ocVar.bKg, ocVar.rsn, Integer.valueOf(ocVar.rso), bi.cjd()});
    }

    public final int getType() {
        return 939;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckMd5", "summersafecdn onGYNetEnd [%d, %d, %s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
        if (this.qAg != null) {
            String str2;
            a aVar;
            a aVar2;
            if (i2 == 0 && i3 == 0) {
                od odVar = (od) ((b) qVar).dIE.dIL;
                a aVar3 = this.qAg;
                if (odVar != null) {
                    str2 = odVar.aeskey;
                    aVar = aVar3;
                    aVar.ac(str2, i2, i3);
                }
                aVar2 = aVar3;
            } else {
                aVar2 = this.qAg;
            }
            str2 = "";
            aVar = aVar2;
            aVar.ac(str2, i2, i3);
        }
    }
}
