package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23$25 implements Runnable {
    final /* synthetic */ int Xt;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$25(23 23, int i) {
        this.pZM = 23;
        this.Xt = i;
    }

    public final void run() {
        this.pZM.pZJ.setProgressBarIndeterminateVisibility(false);
        x.d("MicroMsg.WebViewUI", "[cpan] set title pb visibility:%d", new Object[]{Integer.valueOf(this.Xt)});
        if (this.Xt != 0) {
            this.pZM.pZJ.pXB.finish();
        } else if (!WebViewUI.c(this.pZM.pZJ) && !WebViewUI.d(this.pZM.pZJ)) {
            this.pZM.pZJ.pXB.start();
        }
    }
}
