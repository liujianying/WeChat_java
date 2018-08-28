package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class f$1 extends g {
    final /* synthetic */ f qwi;

    f$1(f fVar, MMActivity mMActivity, i iVar) {
        this.qwi = fVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof f)) {
            return false;
        }
        this.qwi.a(this.fEY, 0, f.a(this.qwi));
        return true;
    }

    public final boolean m(Object... objArr) {
        if (f.b(this.qwi).getBoolean("key_is_show_detail", true)) {
            return false;
        }
        Bankcard bankcard = (Bankcard) f.c(this.qwi).getParcelable("key_bankcard");
        this.uXK.a(new f(bankcard.field_bankcardType, bankcard.field_bindSerial, f.d(this.qwi).getString("key_pwd1")), true, 1);
        return true;
    }
}
