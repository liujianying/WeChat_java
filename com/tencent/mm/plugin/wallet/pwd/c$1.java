package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class c$1 extends g {
    final /* synthetic */ c phe;

    c$1(c cVar, MMActivity mMActivity, i iVar) {
        this.phe = cVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new r((String) objArr[0], 3, (String) objArr[1]), true, 1);
        return true;
    }

    public final CharSequence ui(int i) {
        switch (i) {
            case 0:
                return this.fEY.getString(a.i.wallet_check_pwd_modify_pwd_tip);
            case 1:
                return this.fEY.getString(a.i.wallet_password_setting_ui_modify);
            default:
                return super.ui(i);
        }
    }
}
