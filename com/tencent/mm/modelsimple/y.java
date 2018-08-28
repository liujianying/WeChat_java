package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class y extends l implements k {
    public final b diG;
    private e diJ;

    public y(String str, String str2, int i, bhy bhy) {
        a aVar = new a();
        aVar.dIG = new bmg();
        aVar.dIH = new bmh();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        aVar.dIF = 383;
        aVar.dII = 180;
        aVar.dIJ = 1000000180;
        this.diG = aVar.KT();
        bmg bmg = (bmg) this.diG.dID.dIL;
        bmg.iwG = bi.WN(str);
        bmg.rwj = str2;
        bmg.skA = i;
        bmg.res = bhy;
        x.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, type:%d, authkey:%s", new Object[]{str, str2, Integer.valueOf(i), bi.bB(ab.a(bhy))});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 383;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
