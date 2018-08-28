package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class RechargeUI$11 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$11(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", RechargeUI.a(this.mqE));
        d.b(this.mqE, "webview", ".ui.tools.WebViewUI", intent);
    }
}
