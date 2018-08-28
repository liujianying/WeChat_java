package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$k implements a {
    final /* synthetic */ WebViewUI pZJ;

    private WebViewUI$k(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    /* synthetic */ WebViewUI$k(WebViewUI webViewUI, byte b) {
        this(webViewUI);
    }

    public final void vM(int i) {
        int i2 = 2;
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 4;
                break;
        }
        WebViewUI.d(this.pZJ, i2);
        try {
            if (this.pZJ.gcO.aSn()) {
                this.pZJ.gcO.ek(16384, i2);
                this.pZJ.gcO.ek(16388, i2);
            }
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
        }
    }
}
