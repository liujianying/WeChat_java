package com.tencent.mm.plugin.offline.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.28;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$28$2 extends h {
    final /* synthetic */ Bankcard lMA;
    final /* synthetic */ 28 lMx;

    WalletOfflineCoinPurseUI$28$2(28 28, Context context, Bankcard bankcard) {
        this.lMx = 28;
        this.lMA = bankcard;
        super(context);
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "go to url %s", new Object[]{this.lMA.field_forbid_url});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("pay_channel", 1);
        d.b(this.lMx.lMe.mController.tml, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
