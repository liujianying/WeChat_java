package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$2 extends g {
    final /* synthetic */ b qwe;

    b$2(b bVar, MMActivity mMActivity, i iVar) {
        this.qwe = bVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.qwe.a(this.fEY, 0, b.e(this.qwe));
        this.fEY.finish();
        return true;
    }

    public final boolean m(Object... objArr) {
        b.f(this.qwe).putString("key_pwd1", (String) objArr[0]);
        this.uXK.a(new r((String) objArr[0], 5, ""), true, 1);
        return true;
    }
}
