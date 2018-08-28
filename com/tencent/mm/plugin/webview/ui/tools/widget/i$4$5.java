package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$5 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ 4 qkX;

    i$4$5(4 4, Bundle bundle) {
        this.qkX = 4;
        this.bAE = bundle;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null) {
            this.qkX.qkV.qfM.RJ(this.bAE.getString("webview_network_type"));
        }
    }
}
