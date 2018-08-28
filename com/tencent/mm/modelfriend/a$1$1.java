package com.tencent.mm.modelfriend;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelfriend.a.1;
import com.tencent.mm.sdk.platformtools.x;

class a$1$1 implements e {
    final /* synthetic */ 1 dRE;

    a$1$1(1 1) {
        this.dRE = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            this.dRE.dRD.a(this.dRE.dRD.dIX, this.dRE.dRD.diJ);
        } else {
            this.dRE.dRD.diJ.a(i, i2, "", this.dRE.dRD);
        }
    }
}
