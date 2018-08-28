package com.tencent.mm.ac.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class t extends l implements k {
    public String dNT;
    Object data;
    public b diG;
    private e diJ;

    public t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        a aVar = new a();
        aVar.dIG = new anr();
        aVar.dIH = new ans();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        aVar.dIF = 1389;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        anr anr = (anr) this.diG.dID.dIL;
        anr.ruF = str;
        if (str2 == null) {
            str2 = "";
        }
        anr.rQt = str2;
        anr.rQu = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        return a(eVar, this.diG, this);
    }

    public final ans Nv() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (ans) this.diG.dIE.dIL;
    }
}
