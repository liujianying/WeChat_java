package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.10;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.sdk.platformtools.x;

class WalletBalanceFetchUI$10$1 extends h {
    final /* synthetic */ Bankcard oZt;
    final /* synthetic */ 10 pai;

    WalletBalanceFetchUI$10$1(10 10, Context context, Bankcard bankcard) {
        this.pai = 10;
        this.oZt = bankcard;
        super(context);
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletBalanceFetchUI", "go to url %s", new Object[]{this.oZt.field_forbid_url});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("pay_channel", 1);
        d.b(this.pai.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
