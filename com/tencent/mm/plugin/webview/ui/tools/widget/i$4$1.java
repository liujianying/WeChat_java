package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$1 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ 4 qkX;

    i$4$1(4 4, Bundle bundle) {
        this.qkX = 4;
        this.bAE = bundle;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null && this.qkX.qkV.qhr != null && this.qkX.qkV.qhr.bVR() != null && this.qkX.qkV.qhr.bVR().gu(42)) {
            this.qkX.qkV.qfM.f(this.bAE, "download_succ");
        }
    }
}
