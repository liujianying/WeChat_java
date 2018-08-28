package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;

class k$5 implements OnClickListener {
    final /* synthetic */ Dialog nmd;
    final /* synthetic */ String pvG;
    final /* synthetic */ Context val$context;

    k$5(String str, Context context, Dialog dialog) {
        this.pvG = str;
        this.val$context = context;
        this.nmd = dialog;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{this.pvG});
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("pay_channel", 1);
        d.b(this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
