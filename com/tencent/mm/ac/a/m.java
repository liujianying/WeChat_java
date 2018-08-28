package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends l implements k {
    public String dNT;
    Object data;
    public b diG;
    private e diJ;

    public m(String str, String str2, String str3, Object obj) {
        a aVar = new a();
        aVar.dIG = new qf();
        aVar.dIH = new qg();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        aVar.dIF = 1315;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        qf qfVar = (qf) this.diG.dID.dIL;
        qfVar.ruF = str;
        qfVar.ruH = str2;
        qfVar.ruG = str3;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1315;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        return a(eVar, this.diG, this);
    }

    public final qg Ns() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (qg) this.diG.dIE.dIL;
    }
}
