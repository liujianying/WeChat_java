package com.tencent.mm.plugin.account.model;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.protocal.c.gz;

public final class d extends l implements k {
    public static int eNX = 1;
    public static int eNY = 2;
    private b diG;
    private e diJ;

    public d(int i, String str) {
        a aVar = new a();
        aVar.dIG = new gy();
        aVar.dIH = new gz();
        aVar.uri = "/cgi-bin/micromsg-bin/bindemail";
        aVar.dIF = GLIcon.TOP;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        gy gyVar = (gy) this.diG.dID.dIL;
        gyVar.qZc = i;
        gyVar.rhg = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return GLIcon.TOP;
    }

    public final int Oh() {
        return ((gy) this.diG.dID.dIL).qZc;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
