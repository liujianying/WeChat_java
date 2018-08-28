package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class ProtocolThreeOneUI$4 implements OnClickListener {
    final /* synthetic */ ProtocolThreeOneUI jov;

    ProtocolThreeOneUI$4(ProtocolThreeOneUI protocolThreeOneUI) {
        this.jov = protocolThreeOneUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jov.jmZ);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.jov.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
