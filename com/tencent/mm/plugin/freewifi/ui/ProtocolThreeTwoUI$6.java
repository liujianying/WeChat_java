package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class ProtocolThreeTwoUI$6 implements OnClickListener {
    final /* synthetic */ ProtocolThreeTwoUI joB;

    ProtocolThreeTwoUI$6(ProtocolThreeTwoUI protocolThreeTwoUI) {
        this.joB = protocolThreeTwoUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.joB.jmZ);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b(this.joB.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
