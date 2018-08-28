package com.tencent.mm.openim.b;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.bjr;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private final b diG;
    private com.tencent.mm.ab.e diJ;
    private String euv;
    public bjp euw;
    public String eux;

    public e(String str) {
        this.euv = str;
        a aVar = new a();
        aVar.dIG = new bjq();
        aVar.dIH = new bjr();
        aVar.uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
        aVar.dIF = 372;
        this.diG = aVar.KT();
        x.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[]{str});
        ((bjq) this.diG.dID.dIL).sjD = str;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 372;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.euw = ((bjr) this.diG.dIE.dIL).sjE;
            j jVar = new j();
            jVar.username = this.euw.hbL;
            jVar.dHR = this.euw.rqZ;
            jVar.dHQ = this.euw.rra;
            jVar.bWA = -1;
            x.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[]{jVar.getUsername(), jVar.Kx(), jVar.Ky()});
            jVar.csA = 3;
            jVar.by(true);
            com.tencent.mm.aa.q.KH().a(jVar);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && i3 == -2034) {
            this.eux = ((bjr) this.diG.dIE.dIL).url;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
