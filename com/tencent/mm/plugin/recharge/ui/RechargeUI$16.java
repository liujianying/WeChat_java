package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bi;

class RechargeUI$16 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$16(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(RechargeUI.h(this.mqE).prU.pse)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RechargeUI.h(this.mqE).prU.pse);
            intent.putExtra("geta8key_username", q.GF());
            d.b(this.mqE, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }
}
