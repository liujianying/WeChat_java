package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class FreeWifiPcUI$3 implements OnClickListener {
    final /* synthetic */ FreeWifiPcUI jnS;

    FreeWifiPcUI$3(FreeWifiPcUI freeWifiPcUI) {
        this.jnS = freeWifiPcUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", FreeWifiPcUI.f(this.jnS));
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jnS.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
