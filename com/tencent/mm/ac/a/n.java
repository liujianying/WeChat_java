package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    Object data;
    public b diG;
    private e diJ;

    public n(String str, xr xrVar, Object obj) {
        a aVar = new a();
        aVar.dIG = new ql();
        aVar.dIH = new qm();
        aVar.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        aVar.dIF = 1355;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ql qlVar = (ql) this.diG.dID.dIL;
        qlVar.riK = str;
        qlVar.ruQ = xrVar;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1355;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        return a(eVar, this.diG, this);
    }

    public final qm Nt() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (qm) this.diG.dIE.dIL;
    }

    public final ql Nu() {
        if (this.diG == null || this.diG.dID.dIL == null) {
            return null;
        }
        return (ql) this.diG.dID.dIL;
    }
}
