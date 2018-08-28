package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements OnClickListener {
    final /* synthetic */ g puQ;

    g$1(g gVar) {
        this.puQ = gVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            Intent intent = new Intent();
            x.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", (String) view.getTag());
            intent.putExtra("rawUrl", r0);
            intent.putExtra("geta8key_username", q.GF());
            intent.putExtra("pay_channel", 1);
            d.b(g.a(this.puQ), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, WalletChangeBankcardUI.pfu);
        }
    }
}
