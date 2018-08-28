package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.g.a.pb;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23$22 implements Runnable {
    final /* synthetic */ 23 pZM;

    WebViewUI$23$22(23 23) {
        this.pZM = 23;
    }

    public final void run() {
        if (this.pZM.pZJ.mhH != null) {
            b.lFJ.a(this.pZM.pZJ.mhH, pb.class);
            if (this.pZM.pZJ.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false)) {
                x.i("MicroMsg.WebViewUI", "on service click, test");
                a.sFg.m(new pb());
            }
        }
    }
}
