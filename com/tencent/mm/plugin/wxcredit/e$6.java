package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class e$6 extends g {
    final /* synthetic */ e qwh;

    e$6(e eVar, MMActivity mMActivity, i iVar) {
        this.qwh = eVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.qwh.a(this.fEY, 0, e.al(this.qwh));
        return true;
    }

    public final boolean m(Object... objArr) {
        e.am(this.qwh).putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
        e.an(this.qwh);
        this.uXK.a(new y(), true, 1);
        return true;
    }
}
