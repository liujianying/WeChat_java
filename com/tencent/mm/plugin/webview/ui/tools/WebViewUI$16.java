package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.WebView.FindListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class WebViewUI$16 implements FindListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$16(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (!(!z || WebViewUI.D(this.pZJ) || bi.oW(this.pZJ.pXM.getSearchContent()))) {
            if (i2 == 0) {
                h.mEJ.a(480, 3, 1, false);
            } else {
                h.mEJ.a(480, 2, 1, false);
            }
            WebViewUI.c(this.pZJ, true);
        }
        this.pZJ.pXM.q(i, i2, z);
    }
}
