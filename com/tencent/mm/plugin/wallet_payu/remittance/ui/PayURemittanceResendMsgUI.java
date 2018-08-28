package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.a;

@a(3)
public class PayURemittanceResendMsgUI extends RemittanceResendMsgUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void j(String str, String str2, int i, int i2) {
        a(new h(str, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), str2, i), true, true);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof h)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.ui.base.h.bA(this, getString(a$i.remittance_resended));
            finish();
            return true;
        }
        com.tencent.mm.ui.base.h.bA(this, str);
        finish();
        return true;
    }
}
