package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.oq;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.sdk.platformtools.x;

public final class y extends l implements k {
    public static int eKP = 1;
    public static int eKQ = 2;
    public static int eKR = 3;
    public static int eKS = 4;
    private b diG;
    private e diJ;

    public y(int i) {
        a aVar = new a();
        aVar.dIG = new oq();
        aVar.dIH = new or();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        aVar.dIF = 254;
        aVar.dII = 131;
        aVar.dIJ = 1000000131;
        this.diG = aVar.KT();
        ((oq) this.diG.dID.dIL).rsT = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final String XL() {
        try {
            String str = ((or) this.diG.dIE.dIL).rsU;
            x.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
            return str;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e, "", new Object[0]);
            return null;
        }
    }

    public final int getType() {
        return 254;
    }

    public final or XM() {
        return (or) this.diG.dIE.dIL;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
