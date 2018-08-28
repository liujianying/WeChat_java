package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.account.friend.a.t.a;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ad extends l implements k {
    public final q dJM = new a();
    e diJ = null;

    public ad(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        a aVar = (a) this.dJM.KV();
        aVar.eKC.rKV = str;
        aVar.eKC.rKW = str2;
        aVar.eKC.hcS = str3;
        aVar.eKC.rKX = str4;
        aVar.eKC.rKY = str5;
        aVar.eKC.rKZ = str6;
        aVar.eKC.rLa = i;
        aVar.eKC.iwP = w.chP();
        aie aie = aVar.eKC;
        g.Eg();
        aie.reS = com.tencent.mm.kernel.a.DA();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 429;
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final void a(l.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.KV().qWA.ver)});
            g.Em().H(new 1(this, r0));
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final byte[] Rf() {
        return ab.a(((t.b) this.dJM.Id()).eKD.rLb, new byte[0]);
    }

    public final String Re() {
        return ((t.b) this.dJM.Id()).eKD.rKY;
    }
}
