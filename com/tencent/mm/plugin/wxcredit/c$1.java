package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class c$1 extends g {
    final /* synthetic */ c qwf;

    c$1(c cVar, MMActivity mMActivity, i iVar) {
        this.qwf = cVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        this.qwf.a(this.fEY, 0, c.a(this.qwf));
        this.fEY.finish();
        return true;
    }

    public final boolean m(Object... objArr) {
        c.b(this.qwf).putString("key_pwd1", (String) objArr[0]);
        this.uXK.a(new r((String) objArr[0], 5, ""), true, 1);
        return true;
    }

    public final boolean r(Object... objArr) {
        return false;
    }
}
