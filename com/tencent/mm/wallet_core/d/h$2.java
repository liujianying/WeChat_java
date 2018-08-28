package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class h$2 implements OnClickListener {
    final /* synthetic */ WalletBaseUI peV;

    h$2(WalletBaseUI walletBaseUI) {
        this.peV = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
        d.b(this.peV, "webview", ".ui.tools.WebViewUI", intent);
        if (this.peV.bbR() || this.peV.mController.contentView.getVisibility() != 0) {
            this.peV.finish();
        }
    }
}
