package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.pay.a.a;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class WalletResetInfoUI$1 implements OnClickListener {
    final /* synthetic */ WalletResetInfoUI pdH;

    WalletResetInfoUI$1(WalletResetInfoUI walletResetInfoUI) {
        this.pdH = walletResetInfoUI;
    }

    public final void onClick(View view) {
        if (WalletResetInfoUI.a(this.pdH)) {
            if (WalletResetInfoUI.b(this.pdH).getVisibility() == 0) {
                WalletResetInfoUI.c(this.pdH).pln = WalletResetInfoUI.b(this.pdH).getText();
            }
            if (WalletResetInfoUI.d(this.pdH).getVisibility() == 0) {
                WalletResetInfoUI.c(this.pdH).plo = bi.aG(WalletResetInfoUI.d(this.pdH).getText(), "");
            }
            if (WalletResetInfoUI.e(this.pdH).getVisibility() == 0) {
                WalletResetInfoUI.c(this.pdH).pjw = bi.aG(WalletResetInfoUI.f(this.pdH).getText(), "");
                this.pdH.sy.putString("key_mobile", e.aca(WalletResetInfoUI.c(this.pdH).pjw));
            }
            x.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[]{WalletResetInfoUI.c(this.pdH).lMV, WalletResetInfoUI.c(this.pdH).lMW});
            WalletResetInfoUI.c(this.pdH).plh = 1;
            WalletResetInfoUI.c(this.pdH).plz = "+" + WalletResetInfoUI.e(this.pdH).getCountryCode();
            if (this.pdH.sy.getBoolean("key_is_changing_balance_phone_num", false)) {
                this.pdH.a(new c(WalletResetInfoUI.c(this.pdH), WalletResetInfoUI.g(this.pdH), this.pdH.sy.getBoolean("key_isbalance", false)), true, true);
                return;
            }
            b a = a.a(WalletResetInfoUI.c(this.pdH), WalletResetInfoUI.g(this.pdH), false);
            if (a != null) {
                this.pdH.a(a, true, true);
                return;
            }
            return;
        }
        x.w("Micromsg.WalletResetInfoUI", "input format illegal!");
    }
}
