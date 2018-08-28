package com.tencent.mm.ak;

import com.tencent.mm.g.a.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<u> {
    final /* synthetic */ b dTu;

    b$3(b bVar) {
        this.dTu = bVar;
        this.sFo = u.class.getName().hashCode();
    }

    private boolean a(u uVar) {
        this.dTu.dTq = uVar.bHc.mode;
        x.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.dTu.dTq);
        com.tencent.mm.modelcontrol.c.NM();
        if (!com.tencent.mm.modelcontrol.c.NN()) {
            synchronized (this.dTu.dTg) {
                this.dTu.dTg.clear();
            }
        }
        return false;
    }
}
