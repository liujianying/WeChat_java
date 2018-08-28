package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.facedetect.b.p.1;
import com.tencent.mm.sdk.platformtools.x;

class p$1$1 implements e {
    final /* synthetic */ 1 iMI;

    p$1$1(1 1) {
        this.iMI = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.iMI.iMH.g(this.iMI.iMH.dIX);
            return;
        }
        x.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
        p.iMG = null;
        this.iMI.iMH.AQ(p.Oj());
        this.iMI.iMH.diJ.a(i, i2, "", this.iMI.iMH);
    }
}
