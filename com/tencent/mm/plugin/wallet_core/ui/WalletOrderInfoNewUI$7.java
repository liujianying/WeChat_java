package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;
import com.tencent.smtt.sdk.WebView;

class WalletOrderInfoNewUI$7 implements c {
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$7(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.pwh = walletOrderInfoNewUI;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(WalletOrderInfoNewUI.t(this.pwh)).toString()));
                intent.addFlags(268435456);
                this.pwh.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
