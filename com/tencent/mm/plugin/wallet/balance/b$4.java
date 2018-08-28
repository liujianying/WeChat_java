package com.tencent.mm.plugin.wallet.balance;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.d.e;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$4 extends g {
    final /* synthetic */ b oYy;

    b$4(b bVar, MMActivity mMActivity, i iVar) {
        this.oYy = bVar;
        super(mMActivity, iVar);
    }

    public final /* synthetic */ CharSequence ui(int i) {
        String str;
        String aG = bi.aG(b.y(this.oYy).getString("key_mobile"), "");
        if (bi.oW(aG)) {
            Bankcard bankcard = (Bankcard) b.z(this.oYy).getParcelable("key_bankcard");
            if (bankcard != null) {
                str = bankcard.field_mobile;
                return this.fEY.getString(a.i.wallet_verify_code_hint, new Object[]{str});
            }
        }
        str = aG;
        return this.fEY.getString(a.i.wallet_verify_code_hint, new Object[]{str});
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0) {
            if (lVar instanceof e) {
                e eVar = (e) lVar;
                if (eVar.pgm) {
                    b.r(this.oYy).putParcelable("key_orders", eVar.pfb);
                }
                com.tencent.mm.wallet_core.a.j(this.fEY, b.s(this.oYy));
                return true;
            } else if (lVar instanceof b) {
                b bVar = (b) lVar;
                RealnameGuideHelper realnameGuideHelper = bVar.lJN;
                if (realnameGuideHelper != null) {
                    b.t(this.oYy).putParcelable("key_realname_guide_helper", realnameGuideHelper);
                }
                b.u(this.oYy).putString("kreq_token", bVar.token);
                return true;
            }
        }
        return false;
    }

    public final boolean m(Object... objArr) {
        p pVar = (p) objArr[1];
        if (!(pVar == null || pVar.mpb == null)) {
            pVar.mpb.bVY = 21;
        }
        Orders orders = (Orders) b.v(this.oYy).getParcelable("key_orders");
        switch (this.oYy.jfZ.getInt("key_pay_flag", 0)) {
            case 1:
                pVar.flag = "1";
                break;
            case 2:
                if (!this.oYy.bQH()) {
                    pVar.flag = "2";
                    break;
                }
                pVar.flag = "5";
                break;
            case 3:
                if (!this.oYy.bQH()) {
                    pVar.flag = "3";
                    break;
                }
                pVar.flag = "6";
                break;
            default:
                return false;
        }
        this.uXK.a(new e(pVar, orders), true, 1);
        return true;
    }

    public final boolean s(Object... objArr) {
        Authen authen = (Authen) b.x(this.oYy).getParcelable("key_authen");
        this.uXK.a(new b(authen, (Orders) b.w(this.oYy).getParcelable("key_orders")), true, 1);
        return true;
    }
}
