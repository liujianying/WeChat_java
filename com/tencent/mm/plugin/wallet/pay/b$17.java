package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$17 extends g {
    final /* synthetic */ b peU;

    b$17(b bVar, MMActivity mMActivity, i iVar) {
        this.peU = bVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && (lVar instanceof c)) {
            x.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
            this.peU.a(this.fEY, 0, this.peU.jfZ);
            return true;
        } else if (i != 0 || i2 != 0 || !(lVar instanceof t)) {
            return false;
        } else {
            x.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
            bNt();
            return false;
        }
    }

    public final boolean m(Object... objArr) {
        x.i("MicroMsg.PayProcess", "onNext for select bank card");
        this.peU.jfZ.putInt("key_err_code", 0);
        Bankcard bankcard = (Bankcard) this.peU.jfZ.getParcelable("key_bankcard");
        if (bankcard == null) {
            x.i("MicroMsg.PayProcess", "directToBindNew()");
            this.peU.jfZ.putInt("key_pay_flag", 2);
            this.peU.a(this.fEY, 0, this.peU.jfZ);
        } else if (o.bPe().OW(bankcard.field_bankcardType) != null) {
            bNt();
        } else {
            this.uXK.a(new t("", "", null), true, 1);
        }
        return false;
    }

    private void bNt() {
        x.i("MicroMsg.PayProcess", "directToNext()");
        boolean z = this.peU.jfZ.getBoolean("key_balance_change_phone_need_confirm_phone", false);
        Authen authen = (Authen) this.peU.jfZ.getParcelable("key_authen");
        Orders orders = (Orders) this.peU.jfZ.getParcelable("key_orders");
        Bankcard bankcard = (Bankcard) this.peU.jfZ.getParcelable("key_bankcard");
        ElementQuery OW = o.bPe().OW(bankcard.field_bankcardType);
        this.peU.jfZ.putParcelable("elemt_query", OW);
        if (z) {
            authen.lMV = bankcard.field_bankcardType;
            authen.lMW = bankcard.field_bindSerial;
            this.peU.a(this.fEY, 0, this.peU.jfZ);
            return;
        }
        authen.pjw = "";
        authen.lMV = bankcard.field_bankcardType;
        authen.lMW = bankcard.field_bindSerial;
        this.peU.jfZ.putString("key_mobile", bankcard.field_mobile);
        if (OW == null || OW.pno || OW.pnp) {
            x.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
            this.peU.a(this.fEY, 0, this.peU.jfZ);
            return;
        }
        this.uXK.a(new c(authen, orders, this.peU.jfZ.getBoolean("key_isbalance", false)), true);
    }
}
