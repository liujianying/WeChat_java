package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class d$1 extends g {
    final /* synthetic */ d qwg;

    d$1(d dVar, MMActivity mMActivity, i iVar) {
        this.qwg = dVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean m(Object... objArr) {
        return false;
    }

    public final boolean r(Object... objArr) {
        Bankcard bankcard = (Bankcard) objArr[0];
        this.uXK.a(new d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, 1);
        return true;
    }
}
