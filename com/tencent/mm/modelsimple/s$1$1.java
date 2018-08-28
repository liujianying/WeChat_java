package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.s.1;
import com.tencent.mm.sdk.platformtools.x;

class s$1$1 implements e {
    final /* synthetic */ 1 egk;

    s$1$1(1 1) {
        this.egk = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.egk.egj.a(this.egk.egj.dIX, this.egk.egj.diJ);
        } else {
            this.egk.egj.diJ.a(i, i2, "", this.egk.egj);
        }
    }
}
