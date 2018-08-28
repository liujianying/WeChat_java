package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$1 extends g {
    final /* synthetic */ b piV;

    b$1(b bVar, MMActivity mMActivity, i iVar) {
        this.piV = bVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean m(Object... objArr) {
        return false;
    }

    public final CharSequence ui(int i) {
        switch (i) {
            case 0:
                return this.fEY.getString(a.i.wallet_check_pwd_tip);
            case 1:
                return this.fEY.getString(a.i.wallet_index_ui_bind_card_pref);
            default:
                return super.ui(i);
        }
    }
}
