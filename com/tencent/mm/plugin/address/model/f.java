package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.bfd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class f extends l implements k {
    private b diG;
    private e diJ;
    public int eXI = 0;

    public f(int i) {
        a aVar = new a();
        aVar.dIG = new bfc();
        aVar.dIH = new bfd();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.dIF = TbsListener$ErrorCode.INFO_USE_BACKUP_FILE_INSTALL_BY_SERVER;
        aVar.dII = TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM;
        aVar.dIJ = 1000000201;
        this.diG = aVar.KT();
        this.eXI = i;
        x.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id " + i);
        ((bfc) this.diG.dID.dIL).id = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bfd bfd = (bfd) ((b) qVar).dIE.dIL;
            if (bfd.sgt.sgw != null) {
                x.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + bfd.sgt.sgw.size());
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().q(bfd.sgt.sgw);
                com.tencent.mm.plugin.address.a.a.Zv();
                com.tencent.mm.plugin.address.a.a.Zx().Zz();
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return TbsListener$ErrorCode.INFO_USE_BACKUP_FILE_INSTALL_BY_SERVER;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
