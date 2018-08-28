package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.6;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h.d;

class WalletRealNameVerifyUI$6$1 implements d {
    final /* synthetic */ 6 pkF;

    WalletRealNameVerifyUI$6$1(6 6) {
        this.pkF = 6;
    }

    public final void bx(int i, int i2) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                intent.putExtra("rawUrl", this.pkF.pkE.getString(i.wallet_agreemnet_user, new Object[]{w.chP()}));
                break;
            case 1:
                if (WalletRealNameVerifyUI.e(this.pkF.pkE) != null) {
                    intent.putExtra("rawUrl", this.pkF.pkE.getString(i.wallet_agreemnet_bank, new Object[]{w.chP(), WalletRealNameVerifyUI.e(this.pkF.pkE).lMV}));
                    break;
                }
                break;
        }
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(this.pkF.pkE.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
