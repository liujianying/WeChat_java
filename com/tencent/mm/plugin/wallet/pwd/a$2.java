package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$2 extends g {
    final /* synthetic */ a phb;

    a$2(a aVar, MMActivity mMActivity, i iVar) {
        this.phb = aVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof f)) {
            return false;
        }
        a.a(this.phb).putString("kreq_token", ((f) lVar).token);
        this.phb.a(this.fEY, 0, a.b(this.phb));
        return true;
    }

    public final boolean m(Object... objArr) {
        int i;
        Authen authen = (Authen) objArr[0];
        if (this.phb.bQH()) {
            authen.bWA = 4;
        } else {
            authen.bWA = 1;
        }
        if (a.c(this.phb).getBoolean("key_is_paymanager")) {
            i = 1;
        } else {
            i = 0;
        }
        this.uXK.a(new f(authen, a.d(this.phb).getBoolean("key_is_reset_with_new_card", false), i), true, 1);
        return true;
    }
}
