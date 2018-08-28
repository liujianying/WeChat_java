package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aal;
import com.tencent.mm.protocal.c.aam;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    boolean dNU = false;
    public b diG;
    private e diJ;

    public o(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new aal();
        aVar.dIH = new aam();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.dIF = 1352;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aal aal = (aal) this.diG.dID.dIL;
        aal.riE = str;
        aal.riK = str2;
        this.dNU = true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1352;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        return a(eVar, this.diG, this);
    }
}
