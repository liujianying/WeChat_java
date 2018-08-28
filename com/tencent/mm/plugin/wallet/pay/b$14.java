package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$14 extends a {
    final /* synthetic */ b peU;

    b$14(b bVar, WalletBaseUI walletBaseUI, i iVar) {
        this.peU = bVar;
        super(bVar, walletBaseUI, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (super.d(i, i2, str, lVar)) {
            return true;
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        Orders orders = (Orders) objArr[0];
        p.bNp();
        Bankcard bankcard = p.bNq().paw;
        bankcard.plV += orders.mBj;
        return false;
    }

    public final CharSequence ui(int i) {
        switch (i) {
            case 0:
                return this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_balance_result_save_title);
            case 1:
                return this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_balance_result_save_success);
            default:
                return super.ui(i);
        }
    }
}
