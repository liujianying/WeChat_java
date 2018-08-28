package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.c.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class e$1 extends g {
    final /* synthetic */ e pFv;

    e$1(e eVar, MMActivity mMActivity, i iVar) {
        this.pFv = eVar;
        super(mMActivity, iVar);
    }

    public final boolean r(Object... objArr) {
        PayInfo payInfo = (PayInfo) this.fEY.getIntent().getParcelableExtra("key_pay_info");
        if (payInfo == null || bi.oW(payInfo.bOd)) {
            return false;
        }
        this.uXK.a(new c(payInfo.bOd), payInfo.qUJ, 1);
        this.uXK.a(new a(), payInfo.qUJ, 1);
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean m(Object... objArr) {
        return false;
    }
}
