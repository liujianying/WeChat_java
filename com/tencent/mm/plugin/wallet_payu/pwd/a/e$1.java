package com.tencent.mm.plugin.wallet_payu.pwd.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class e$1 extends g {
    final /* synthetic */ e pFP;

    e$1(e eVar, MMActivity mMActivity, i iVar) {
        this.pFP = eVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof d)) {
            return false;
        }
        x.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.pFP.jfZ.putInt("key_errcode_payu", 0);
        a.c(this.fEY, this.pFP.jfZ, 0);
        return true;
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[0];
        this.uXK.a(new d(this.pFP.jfZ.getString("payu_reference"), pVar.eJn), true);
        return true;
    }
}
