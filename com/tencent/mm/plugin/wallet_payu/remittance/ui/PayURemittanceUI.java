package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.plugin.remittance.ui.RemittanceUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.d;
import com.tencent.mm.plugin.wallet_payu.remittance.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.s;

public class PayURemittanceUI extends RemittanceUI {
    private final String pGh = "ZAR";

    public final void brn() {
        a(new g(this.cYO, this.myV), true, true);
    }

    public final void a(String str, String str2, String str3, fo foVar) {
        a(new d(this.myQ, "ZAR", this.cYO, this.fdx), true, true);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(lVar instanceof d)) {
            return true;
        }
        d dVar = (d) lVar;
        if (bi.oW(dVar.bST)) {
            s.makeText(this.mController.tml, i.walley_payu_remittance_gen_error, 0).show();
            return true;
        }
        String str2 = dVar.bST;
        String str3 = this.cYO;
        PayInfo payInfo = new PayInfo();
        payInfo.bOd = str2;
        payInfo.bVY = this.myU;
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", getIntent().getStringExtra("desc"));
        bundle.putString("extinfo_key_4", getIntent().getStringExtra("scan_remittance_id"));
        bundle.putString("fee_type", "ZAR");
        bundle.putDouble("total_fee", this.myQ);
        payInfo.qUL = bundle;
        h.a(this, payInfo, 1);
        return true;
    }
}
