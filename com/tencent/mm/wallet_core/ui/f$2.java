package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;

class f$2 implements OnClickListener {
    final /* synthetic */ WalletBaseUI uZe;
    final /* synthetic */ String uZf;

    f$2(WalletBaseUI walletBaseUI, String str) {
        this.uZe = walletBaseUI;
        this.uZf = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        f.c(this.uZe);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.uZf);
        d.b(this.uZe.mController.tml, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        e.He(3);
    }
}
