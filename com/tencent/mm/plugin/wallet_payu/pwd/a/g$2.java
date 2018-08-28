package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class g$2 extends g {
    final /* synthetic */ g pFQ;

    g$2(g gVar, MMActivity mMActivity, i iVar) {
        this.pFQ = gVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof b)) {
            return false;
        }
        x.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
        if (i != 0 || i2 != 0) {
            return false;
        }
        g.a(this.pFQ).putInt("key_errcode_payu", 0);
        a.c(this.fEY, this.pFQ.jfZ, 0);
        return true;
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[0];
        this.uXK.a(new b(g.b(this.pFQ).getString("key_pwd1"), pVar.eJn), true);
        return true;
    }
}
