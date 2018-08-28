package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxcredit.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class e$1 extends g {
    final /* synthetic */ e qwh;

    e$1(e eVar, MMActivity mMActivity, i iVar) {
        this.qwh = eVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (lVar instanceof b) {
            b bVar = (b) lVar;
            e.a(this.qwh).putString("KEY_SESSION_KEY", bVar.token);
            e.b(this.qwh).putString("key_pre_name", bVar.name);
            e.c(this.qwh).putString("key_pre_indentity", bVar.qwk);
            e.d(this.qwh).putBoolean("key_has_indentity_info", bVar.qwl);
        }
        this.qwh.a(this.fEY, 0, e.e(this.qwh));
        return true;
    }

    public final boolean m(Object... objArr) {
        int i = 0;
        e.f(this.qwh).putString("key_pwd1", (String) objArr[0]);
        i iVar = this.uXK;
        String str = (String) objArr[0];
        if (objArr[1] != null) {
            i = bi.WU((String) objArr[1]);
        }
        iVar.a(new b(str, i, e.g(this.qwh).getString("key_bank_type")), true, 1);
        return true;
    }
}
