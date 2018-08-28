package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.bc.a$a;
import com.tencent.mm.bc.a.b;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$3 implements b {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$3(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void a(a$a a_a, a$a a_a2) {
        x.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + a_a.name() + "; newOrientation:" + a_a2.name());
        this.pZJ.screenOrientation = 4;
        this.pZJ.ahy();
        if (this.pZJ.fYl != null) {
            this.pZJ.fYl.disable();
        }
    }
}
