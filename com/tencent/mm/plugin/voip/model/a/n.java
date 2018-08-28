package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public abstract class n<REQ, RESP> extends l implements k {
    protected b diG;
    e diJ;
    private e jkx;
    protected j oKs = com.tencent.mm.plugin.voip.model.k.bKc();

    public abstract e bLm();

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        dP(i2, i3);
        if (this.jkx != null) {
            this.jkx.a(i2, i3, str, this);
        }
        if (this.diJ != null) {
            ah.A(new 1(this, i2, i3, str));
        }
    }

    public int bLn() {
        return 0;
    }

    public void dP(int i, int i2) {
    }

    public final void bLp() {
        x.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        au.DF().a(this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int bLn = bLn();
        if (bLn != 0) {
            return bLn;
        }
        this.jkx = eVar2;
        this.diJ = bLm();
        return a(eVar, this.diG, this);
    }

    public final <RESP> RESP bLq() {
        return this.diG.dIE.dIL;
    }

    public final <REQ> REQ bLr() {
        return this.diG.dID.dIL;
    }
}
