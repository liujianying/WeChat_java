package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.5;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h.d;

class WalletCardImportUI$5$1 implements d {
    final /* synthetic */ 5 puy;

    WalletCardImportUI$5$1(5 5) {
        this.puy = 5;
    }

    public final void bx(int i, int i2) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                intent.putExtra("rawUrl", this.puy.puv.getString(i.wallet_agreemnet_user, new Object[]{w.chP()}));
                break;
            case 1:
                if (WalletCardImportUI.c(this.puy.puv) != null) {
                    intent.putExtra("rawUrl", this.puy.puv.getString(i.wallet_agreemnet_bank, new Object[]{w.chP(), WalletCardImportUI.c(this.puy.puv).lMV}));
                    break;
                }
                break;
        }
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(this.puy.puv.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
