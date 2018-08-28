package com.tencent.mm.plugin.wallet.balance;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$6 extends g {
    final /* synthetic */ b oYy;

    b$6(b bVar, MMActivity mMActivity, i iVar) {
        this.oYy = bVar;
        super(mMActivity, iVar);
    }

    public final /* synthetic */ CharSequence ui(int i) {
        return this.fEY.getString(a.i.wallet_set_password_pay_tips);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof f)) {
            return false;
        }
        f fVar = (f) lVar;
        if (fVar.pgm) {
            b.E(this.oYy).putParcelable("key_orders", fVar.pfb);
        }
        this.oYy.a(this.fEY, 0, b.F(this.oYy));
        return true;
    }

    public final boolean m(Object... objArr) {
        this.uXK.a(new f((p) objArr[0], (Orders) b.G(this.oYy).getParcelable("key_orders")), true, 1);
        return true;
    }
}
