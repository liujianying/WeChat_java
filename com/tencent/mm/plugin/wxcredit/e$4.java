package com.tencent.mm.plugin.wxcredit;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.b.a.a;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.e;

class e$4 extends g {
    final /* synthetic */ e qwh;

    e$4(e eVar, MMActivity mMActivity, i iVar) {
        this.qwh = eVar;
        super(mMActivity, iVar);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0 || !(lVar instanceof a)) {
            return false;
        }
        a aVar = (a) lVar;
        new StringBuilder("reqKey  ").append(aVar.pfn);
        e.P(this.qwh).putString("kreq_token", aVar.token);
        this.qwh.a(this.fEY, 0, e.Q(this.qwh));
        return true;
    }

    public final boolean m(Object... objArr) {
        c.bQW();
        Authen authen = new Authen();
        authen.plm = (String) objArr[0];
        authen.lMV = (String) objArr[1];
        authen.pjw = (String) objArr[2];
        e.R(this.qwh).putString("key_bank_phone", (String) objArr[3]);
        authen.bWA = o.bOW().bPs() ? 2 : 1;
        authen.pll = 1;
        authen.mpb = (PayInfo) e.S(this.qwh).getParcelable("key_pay_info");
        authen.pli = e.T(this.qwh).getString("key_pwd1");
        if (!e.U(this.qwh).getBoolean("key_has_indentity_info", false)) {
            authen.plj = e.V(this.qwh).getString("key_name");
            authen.plk = e.W(this.qwh).getString("key_indentity");
        }
        e.X(this.qwh).putString("key_mobile", e.aca(authen.pjw));
        e.Y(this.qwh).putBoolean("key_is_oversea", false);
        this.uXK.a(new a(authen), true, 1);
        return true;
    }

    public final boolean s(Object... objArr) {
        this.uXK.a(new t("", (String) objArr[0], (PayInfo) e.Z(this.qwh).getParcelable("key_pay_info")), true, 1);
        return true;
    }
}
