package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$11 extends a {
    final /* synthetic */ b peU;

    b$11(b bVar, WalletBaseUI walletBaseUI, i iVar) {
        this.peU = bVar;
        super(bVar, walletBaseUI, iVar);
    }

    public final boolean r(Object... objArr) {
        if (b.a(this.peU).getInt("key_pay_scene", 0) == 11) {
            p.bNp();
            b.b(this.peU).putParcelable("key_history_bankcard", p.bNq().prB);
        }
        return super.r(objArr);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (super.d(i, i2, str, lVar)) {
            return true;
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        return false;
    }
}
