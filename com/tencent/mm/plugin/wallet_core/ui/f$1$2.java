package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.f.1;
import com.tencent.mm.sdk.platformtools.x;

class f$1$2 extends h {
    final /* synthetic */ Bankcard oZt;
    final /* synthetic */ 1 psP;

    f$1$2(1 1, Context context, Bankcard bankcard) {
        this.psP = 1;
        this.oZt = bankcard;
        super(context);
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", this.oZt.field_forbid_url);
        intent.putExtra("rawUrl", r1);
        intent.putExtra("geta8key_username", q.GF());
        intent.putExtra("pay_channel", 1);
        d.b(this.psP.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
