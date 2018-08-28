package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$9 implements Runnable {
    final /* synthetic */ String jJS;
    final /* synthetic */ String pUG;
    final /* synthetic */ Bundle pUH;
    final /* synthetic */ boolean pUI;
    final /* synthetic */ 4 qkX;

    i$4$9(4 4, String str, String str2, Bundle bundle, boolean z) {
        this.qkX = 4;
        this.pUG = str;
        this.jJS = str2;
        this.pUH = bundle;
        this.pUI = z;
    }

    public final void run() {
        this.qkX.qkV.qfM.a(this.pUG, this.jJS, i.ac(this.pUH), this.pUI);
    }
}
