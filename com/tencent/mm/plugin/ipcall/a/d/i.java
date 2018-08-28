package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.bcb;
import com.tencent.mm.protocal.c.bcc;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private b diG = null;
    private e diJ = null;
    public bcb krw = null;
    public bcc krx = null;

    public i(String str, String str2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.dIG = new bcb();
        aVar.dIH = new bcc();
        aVar.dIF = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        long currentTimeMillis = System.currentTimeMillis();
        int aYA = c.aYA();
        bcb bcb = (bcb) this.diG.dID.dIL;
        bcb.jTv = q.GF();
        bcb.seg = str2;
        bcb.jTu = str;
        bcb.sef = i;
        bcb.rth = aYA;
        bcb.seo = 1;
        bcb.see = currentTimeMillis;
        bcb.sen = i2;
        bcb.sep = i3;
        this.krw = bcb;
        x.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(aYA), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int getType() {
        return 991;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.krx = (bcc) ((b) qVar).dIE.dIL;
        if (i2 == 0 || i3 == 0) {
            if (this.diJ != null) {
                this.diJ.a(i2, i3, str, this);
            }
        } else if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
