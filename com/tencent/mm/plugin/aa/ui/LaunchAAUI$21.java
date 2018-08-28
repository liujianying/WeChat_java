package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class LaunchAAUI$21 implements OnClickListener {
    final /* synthetic */ LaunchAAUI eDS;
    final /* synthetic */ String val$url;

    LaunchAAUI$21(LaunchAAUI launchAAUI, String str) {
        this.eDS = launchAAUI;
        this.val$url = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        d.b(this.eDS.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
