package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$1 extends g {
    final /* synthetic */ a jhb;

    a$1(a aVar, MMActivity mMActivity, i iVar) {
        this.jhb = aVar;
        super(mMActivity, iVar);
    }

    public final boolean m(Object... objArr) {
        a.a(this.jhb).putString("pwd", (String) objArr[0]);
        x.i("MicroMsg.FingerPrintAuthProcess", "this is onNext");
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }
}
