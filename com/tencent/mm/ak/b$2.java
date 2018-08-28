package com.tencent.mm.ak;

import com.tencent.mm.g.a.ln;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$2 extends c<ln> {
    final /* synthetic */ b dTu;

    b$2(b bVar) {
        this.dTu = bVar;
        this.sFo = ln.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ln lnVar = (ln) bVar;
        this.dTu.dTl = (lnVar.bVQ.bVR ? 1 : -1) + this.dTu.dTl;
        if (this.dTu.dTl < 0) {
            this.dTu.dTl = 0;
            x.e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
        }
        x.i("MicroMsg.AutoGetBigImgLogic", "req pause: " + lnVar.bVQ.bVR + " count:" + this.dTu.dTl);
        this.dTu.start();
        return false;
    }
}
