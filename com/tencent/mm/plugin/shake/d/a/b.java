package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aii;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    public com.tencent.mm.ab.b diG;
    private e diJ;
    private String mYD;
    private int scene;

    public b(String str, int i) {
        this.mYD = str;
        this.scene = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new aii();
        aVar.dIH = new aij();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.dIF = 552;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aii aii = (aii) this.diG.dID.dIL;
        aii.rLk = this.mYD;
        aii.otY = this.scene;
        return a(eVar, this.diG, this);
    }

    protected final int a(q qVar) {
        aii aii = (aii) ((com.tencent.mm.ab.b) qVar).dID.dIL;
        if (aii.otY >= 0 && aii.rLk != null && aii.rLk.length() > 0) {
            return com.tencent.mm.ab.l.b.dJm;
        }
        x.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", new Object[]{Integer.valueOf(aii.otY)});
        return com.tencent.mm.ab.l.b.dJn;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 552;
    }
}
