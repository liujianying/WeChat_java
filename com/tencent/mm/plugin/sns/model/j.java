package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class j extends l implements k {
    private b diG;
    public e diJ;
    private final int dxI;

    public j() {
        a aVar = new a();
        aVar.dIG = new awn();
        aVar.dIH = new awo();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
        aVar.dIF = 2842;
        this.dxI = -1216949095;
        this.diG = aVar.KT();
        awn awn = (awn) this.diG.dID.dIL;
        g.Ek();
        g.Eg();
        awn.rZO = com.tencent.mm.kernel.a.Df();
        awn.rZP = -1216949095;
        x.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", new Object[]{Integer.valueOf(awn.rZO), Integer.valueOf(awn.rZP)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", new Object[]{Integer.valueOf(this.dxI), Integer.valueOf(((awo) ((b) qVar).dIE.dIL).status)});
            if (this.dxI == -1216949095) {
                g.Ek();
                g.Ei().DT().a(aa.a.sQN, Boolean.valueOf(r0.status == 1));
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 2842;
    }
}
