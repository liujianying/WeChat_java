package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;

public final class c {
    Context gKE;
    boolean gKV = false;
    int gKZ;
    int gLa;
    b qlR;
    a qlS;

    public final a bYC() {
        if (this.qlR == null) {
            this.qlR = new b();
            this.qlR.gKE = this.gKE;
            this.qlR.setPanelManager(this);
        }
        return this.qlR;
    }
}
