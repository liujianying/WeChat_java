package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.q.1;
import com.tencent.mm.sdk.platformtools.x;

class q$1$1 implements e {
    final /* synthetic */ 1 efT;

    q$1$1(1 1) {
        this.efT = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.efT.efS.a(this.efT.efS.dIX, this.efT.efS.diJ);
        } else {
            this.efT.efS.diJ.a(i, i2, "", this.efT.efS);
        }
    }
}
