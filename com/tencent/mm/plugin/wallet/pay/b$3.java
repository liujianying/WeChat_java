package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$3 extends a {
    final /* synthetic */ b peU;

    b$3(b bVar, WalletBaseUI walletBaseUI, i iVar) {
        this.peU = bVar;
        super(bVar, walletBaseUI, iVar);
    }

    public final boolean m(Object... objArr) {
        x.i("MicroMsg.PayProcess", "start do authen");
        fd fdVar = (fd) objArr[0];
        Authen authen = (Authen) this.peU.jfZ.getParcelable("key_authen");
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = fdVar.lMW;
        bankcard.field_mobile = fdVar.pjw;
        bankcard.field_desc = fdVar.knE;
        bankcard.field_bankcardType = authen.lMV;
        x.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", new Object[]{authen.lMV, fdVar.lMW, authen.lMW});
        this.peU.jfZ.putString("key_mobile", bankcard.field_mobile);
        this.peU.jfZ.putParcelable("key_bankcard", bankcard);
        Orders orders = (Orders) this.peU.jfZ.getParcelable("key_orders");
        authen.plv = fdVar.rfW;
        authen.plw = fdVar.lMW;
        authen.plx = fdVar.lMV;
        authen.ply = "1";
        b a = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, false);
        if (a != null) {
            this.uXK.a(a, true, 1);
        }
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof b)) {
            return false;
        }
        x.i("MicroMsg.PayProcess", "finish auth");
        Authen authen = ((b) lVar).pfc;
        Orders orders = ((b) lVar).pfb;
        this.peU.jfZ.putParcelable("key_authen", authen);
        this.peU.jfZ.putParcelable("key_orders", orders);
        this.peU.jfZ.putString("kreq_token", ((b) lVar).token);
        this.peU.jfZ.putBoolean("key_is_return_from_switch_phone", true);
        this.peU.jfZ.putInt("key_err_code", 0);
        Bankcard bankcard = (Bankcard) this.peU.jfZ.getParcelable("key_bankcard");
        bankcard.field_bankcardType = authen.lMV;
        bankcard.field_bindSerial = authen.lMW;
        this.peU.a(this.fEY, 0, this.peU.jfZ);
        this.peU.z(this.fEY);
        return true;
    }
}
