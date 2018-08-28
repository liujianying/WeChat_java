package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.c.ahk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    private e diJ;
    public final b efk;

    public o() {
        a aVar = new a();
        aVar.dIG = new ahj();
        aVar.dIH = new ahk();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        aVar.dIF = 725;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.efk = aVar.KT();
        ((ahj) this.efk.dID.dIL).hcE = 0;
        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", new Object[]{Integer.valueOf(0), bi.cjd()});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            h.mEJ.a(405, 2, 1, true);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 725;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        h.mEJ.a(405, 1, 1, true);
        return a(eVar, this.efk, this);
    }
}
