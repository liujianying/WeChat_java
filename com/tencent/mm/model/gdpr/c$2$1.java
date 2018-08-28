package com.tencent.mm.model.gdpr;

import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.model.gdpr.c.2;
import com.tencent.mm.protocal.c.adv;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.chc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;

class c$2$1 implements b$a {
    final /* synthetic */ b dEk;
    final /* synthetic */ 2 dEl;

    c$2$1(2 2, b bVar) {
        this.dEl = 2;
        this.dEk = bVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.b bVar) {
        boolean z = i == 0 && i2 == 0 && ((bhp) bVar.dIE.dIL) != null;
        if (z) {
            adv adv = (adv) bVar.dIE.dIL;
            if (adv.rIi == null) {
                adv.rIi = new chc();
                adv.rIi.bMH = -1;
            }
            x.i("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d)", new Object[]{this.dEl.dEi.dEe, this.dEl.bAj, Integer.valueOf(adv.rIi.bMH), Integer.valueOf(adv.state)});
            if (adv.rIi.bMH != 0) {
                this.dEl.dEh.hj(0);
                this.dEk.ct(Boolean.valueOf(false));
                return;
            } else if (adv.state <= 0) {
                this.dEk.v(new Object[]{Boolean.valueOf(true)});
                return;
            } else {
                this.dEl.dEh.hj(0);
                this.dEk.ct(Boolean.valueOf(false));
                return;
            }
        }
        x.e("MicroMsg.MPGdprPolicyUtil", "onGetAuthCgiBack, business(%s), appId(%s), back(%d %d %s)", new Object[]{this.dEl.dEi.dEe, this.dEl.bAj, Integer.valueOf(i2), Integer.valueOf(i), str});
        this.dEl.dEh.hj(0);
        this.dEk.ct(Boolean.valueOf(false));
    }
}
