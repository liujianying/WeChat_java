package com.tencent.mm.plugin.wallet.pay;

import android.os.Parcelable;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.e.b;
import com.tencent.mm.plugin.wallet.pay.a.e.c;
import com.tencent.mm.plugin.wallet.pay.a.e.d;
import com.tencent.mm.plugin.wallet.pay.a.e.e;
import com.tencent.mm.plugin.wallet.pay.a.e.f;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$15 extends a {
    final /* synthetic */ b peU;

    b$15(b bVar, WalletBaseUI walletBaseUI, i iVar) {
        this.peU = bVar;
        super(bVar, walletBaseUI, iVar);
    }

    public final /* synthetic */ CharSequence ui(int i) {
        return this.fEY.getString(com.tencent.mm.plugin.wxpay.a.i.wallet_set_password_pay_tips);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (super.d(i, i2, str, lVar)) {
            return true;
        }
        if (!(lVar instanceof f) || i != 0 || i2 != 0) {
            return false;
        }
        f fVar = (f) lVar;
        if (fVar.pgm) {
            b.o(this.peU).putParcelable("key_orders", fVar.pfb);
        }
        Parcelable parcelable = fVar.lJN;
        if (parcelable != null) {
            b.p(this.peU).putParcelable("key_realname_guide_helper", parcelable);
        }
        this.peU.a(this.fEY, 0, b.q(this.peU));
        return true;
    }

    public final boolean m(Object... objArr) {
        l lVar;
        p pVar = (p) objArr[0];
        Orders orders = (Orders) b.r(this.peU).getParcelable("key_orders");
        if (pVar == null || orders == null) {
            x.e("MicroMsg.CgiManager", "empty verify or orders");
            lVar = null;
        } else {
            PayInfo payInfo = pVar.mpb;
            String str = "";
            if (payInfo != null) {
                x.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                str = payInfo.bOd;
            }
            if (bi.oW(str)) {
                x.i("MicroMsg.CgiManager", "get reqKey from orders");
                str = orders.bOd;
            }
            if (bi.oW(str)) {
                x.i("MicroMsg.CgiManager", "empty reqKey!");
                lVar = new f(pVar, orders);
            } else {
                if (payInfo != null) {
                    x.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.bOd, orders.bOd});
                }
                x.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", new Object[]{str});
                x.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                lVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.e.a(pVar, orders) : str.startsWith("sns_tf_") ? new e(pVar, orders) : str.startsWith("sns_ff_") ? new b(pVar, orders) : str.startsWith("ts_") ? new c(pVar, orders) : str.startsWith("sns_") ? new d(pVar, orders) : new f(pVar, orders);
            }
        }
        if (lVar != null) {
            this.uXK.a(lVar, true, 1);
        }
        return true;
    }
}
