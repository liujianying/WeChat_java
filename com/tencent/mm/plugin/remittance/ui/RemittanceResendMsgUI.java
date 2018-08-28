package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.contentView.setVisibility(8);
        setTitleVisibility(8);
        String stringExtra = getIntent().getStringExtra("transaction_id");
        String stringExtra2 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (!bi.oW(stringExtra2)) {
            j(stringExtra, stringExtra2, intExtra2, intExtra);
        }
    }

    public void j(String str, String str2, int i, int i2) {
        y yVar = new y(str, str2, i, i2);
        yVar.dox = "RemittanceProcess";
        a(yVar, true, true);
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof y)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            h.bA(this, getString(i.remittance_resended));
            finish();
            return true;
        }
        h.bA(this, str);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
