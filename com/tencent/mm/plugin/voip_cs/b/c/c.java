package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzh;
import com.tencent.mm.protocal.c.bzi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public b diG;
    private e diJ;

    public c(int i, String str, int i2, byte[] bArr, byte[] bArr2, String str2) {
        a aVar = new a();
        aVar.dIG = new bzh();
        aVar.dIH = new bzi();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        aVar.dIF = 823;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bzh bzh = (bzh) this.diG.dID.dIL;
        bzh.sef = i;
        bzh.svt = str;
        bzh.rth = i2;
        bzh.svu = com.tencent.mm.bk.b.bi(bArr);
        bzh.svv = com.tencent.mm.bk.b.bi(bArr2);
        bzh.see = System.currentTimeMillis();
        if (str2 != null && !str2.equals("")) {
            bzh.svw = str2;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 823;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
