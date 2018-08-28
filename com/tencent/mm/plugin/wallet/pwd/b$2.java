package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$2 extends g {
    final /* synthetic */ b phc;

    b$2(b bVar, MMActivity mMActivity, i iVar) {
        this.phc = bVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (!(lVar instanceof b)) {
                return true;
            }
            this.phc.a(this.fEY, 0, b.a(this.phc));
            h.bA(this.fEY, this.fEY.getString(a$i.wallet_password_setting_success_tip));
            return true;
        } else if (!(lVar instanceof b)) {
            return false;
        } else {
            h.a(this.fEY, str, "", false, new 1(this));
            return true;
        }
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[0];
        this.uXK.a(new b(b.b(this.phc).getString("key_pwd1"), pVar.eJn), true, 1);
        return true;
    }
}
