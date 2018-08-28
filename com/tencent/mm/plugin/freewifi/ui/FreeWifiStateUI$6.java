package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class FreeWifiStateUI$6 implements OnClickListener {
    final /* synthetic */ FreeWifiStateUI jnZ;

    FreeWifiStateUI$6(FreeWifiStateUI freeWifiStateUI) {
        this.jnZ = freeWifiStateUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jnZ.jmZ);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jnZ.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
