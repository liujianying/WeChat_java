package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet.pwd.a.h;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$3 extends g {
    final /* synthetic */ a phb;

    a$3(a aVar, MMActivity mMActivity, i iVar) {
        this.phb = aVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof f)) {
            return false;
        }
        a.e(this.phb).putString("kreq_token", ((f) lVar).token);
        return true;
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[1];
        pVar.flag = "3";
        this.uXK.a(new h(pVar), true, 1);
        return true;
    }
}
