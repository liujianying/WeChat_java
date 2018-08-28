package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.bi;

class WebViewUI$23$27 implements Runnable {
    final /* synthetic */ boolean gnL;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ boolean qae;

    WebViewUI$23$27(23 23, boolean z, boolean z2) {
        this.pZM = 23;
        this.qae = z;
        this.gnL = z2;
    }

    public final void run() {
        if (this.qae) {
            if (!(this.pZM.pZJ.mhH == null || bi.oW(this.pZM.pZJ.mhH.getUrl()))) {
                WebViewUI.e(this.pZM.pZJ).put(this.pZM.pZJ.mhH.getUrl(), Boolean.valueOf(false));
            }
            this.pZM.pZJ.ka(false);
            return;
        }
        if (!(this.pZM.pZJ.mhH == null || bi.oW(this.pZM.pZJ.mhH.getUrl()))) {
            WebViewUI.e(this.pZM.pZJ).put(this.pZM.pZJ.mhH.getUrl(), Boolean.valueOf(this.gnL));
        }
        this.pZM.pZJ.ka(this.gnL);
    }
}
