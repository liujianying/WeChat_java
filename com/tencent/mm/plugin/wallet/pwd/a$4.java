package com.tencent.mm.plugin.wallet.pwd;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$4 extends g {
    final /* synthetic */ a phb;

    a$4(a aVar, MMActivity mMActivity, i iVar) {
        this.phb = aVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof e)) {
            return false;
        }
        this.phb.a(this.fEY, 0, a.f(this.phb));
        return true;
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new e((p) objArr[0]), true, 1);
        return true;
    }
}
