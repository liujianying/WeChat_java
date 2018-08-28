package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class e$2 extends g {
    final /* synthetic */ e pFv;

    e$2(e eVar, MMActivity mMActivity, i iVar) {
        this.pFv = eVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
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
                return this.fEY.getString(a.i.wallet_balance_result_save_title);
            case 1:
                return this.fEY.getString(a.i.wallet_balance_result_save_success);
            default:
                return super.ui(i);
        }
    }
}
