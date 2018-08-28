package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class e$2 extends g {
    final /* synthetic */ e qwh;

    e$2(e eVar, MMActivity mMActivity, i iVar) {
        this.qwh = eVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (lVar instanceof a) {
            a aVar = (a) lVar;
            e.h(this.qwh).putString("KEY_SESSION_KEY", aVar.token);
            e.i(this.qwh).putString("key_mobile", aVar.bTi);
            e.j(this.qwh).putBoolean("key_need_bind_deposit", aVar.cdW);
            e.k(this.qwh).putBoolean("key_is_bank_user", aVar.qwj);
        }
        this.qwh.a(this.fEY, 0, e.l(this.qwh));
        return true;
    }

    public final boolean m(Object... objArr) {
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        e.m(this.qwh).putString("key_name", str);
        e.n(this.qwh).putString("key_indentity", str2);
        this.uXK.a(new a(str, str2, e.o(this.qwh).getString("KEY_SESSION_KEY"), e.p(this.qwh).getString("key_bank_type")), true, 1);
        return true;
    }
}
