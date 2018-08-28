package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements OnClickListener {
    final /* synthetic */ String pvE;
    final /* synthetic */ Context val$context;

    k$1(String str, Context context) {
        this.pvE = str;
        this.val$context = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{this.pvE});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("pay_channel", 1);
        d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
