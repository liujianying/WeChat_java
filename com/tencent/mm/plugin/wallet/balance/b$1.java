package com.tencent.mm.plugin.wallet.balance;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.c.v;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class b$1 extends g {
    final /* synthetic */ b oYy;

    b$1(b bVar, MMActivity mMActivity, i iVar) {
        this.oYy = bVar;
        super(mMActivity, iVar);
    }

    public final boolean r(Object... objArr) {
        String str = null;
        p.bNp();
        b.a(this.oYy).putParcelable("key_history_bankcard", p.bNq().prB);
        PayInfo payInfo = (PayInfo) this.oYy.jfZ.get("key_pay_info");
        if (a.bOi()) {
            this.uXK.a(new v(payInfo == null ? null : payInfo.bOd), true);
        } else {
            i iVar = this.uXK;
            if (payInfo != null) {
                str = payInfo.bOd;
            }
            iVar.a(new y(str, 4), true);
        }
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean m(Object... objArr) {
        this.oYy.a(this.fEY, 0, this.oYy.jfZ);
        return true;
    }
}
