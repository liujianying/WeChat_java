package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelmulti.i.1;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class i$1$1 implements e {
    final /* synthetic */ 1 dZG;

    i$1$1(1 1) {
        this.dZG = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        lVar.dJc = true;
        x.i("MicroMsg.NetSceneSendMsg", "summerdktext verifypsw onSceneEnd[%d, %d] needVerifyPswList size[%d] errMsg[%s] verifyingPsw[%b], retryVerifyCount[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i.b(this.dZG.dZF).size()), str, Boolean.valueOf(i.c(this.dZG.dZF)), Integer.valueOf(i.d(this.dZG.dZF))});
        if (i == 0 && i2 == 0) {
            i.b(this.dZG.dZF).clear();
            i.a(this.dZG.dZF, str);
        } else {
            i.M(i.b(this.dZG.dZF));
            i.e(this.dZG.dZF).a(4, -49, this.dZG.dZE, this.dZG.dZF);
            i.N(i.b(this.dZG.dZF));
            i.b(this.dZG.dZF).clear();
        }
        i.f(this.dZG.dZF);
        af.exT = false;
    }
}
