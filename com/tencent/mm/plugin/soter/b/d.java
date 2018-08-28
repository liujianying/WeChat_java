package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.g.1;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends l implements k {
    private g onx;

    public abstract void aNJ();

    public abstract void d(int i, int i2, String str, q qVar);

    public abstract void pS(int i);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        boolean z = true;
        x.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.onx = new g(new a(this, (byte) 0));
        this.onx.onA = -3202;
        g gVar = this.onx;
        if (i2 == 4 && i3 == -3200) {
            a.a(new 1(gVar), true, new e());
        } else if (i2 != 4 || i3 != gVar.onA) {
            z = false;
        } else if (gVar.onz != null) {
            gVar.onz.bFc();
        }
        if (!z) {
            d(i2, i3, str, qVar);
        }
    }
}
