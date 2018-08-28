package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class FreeWifiFrontPageUI$4 implements OnClickListener {
    final /* synthetic */ FreeWifiFrontPageUI jnd;

    FreeWifiFrontPageUI$4(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.jnd = freeWifiFrontPageUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jnd.jmZ);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jnd.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
