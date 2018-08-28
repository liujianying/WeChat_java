package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class WebViewUI$55 implements OnClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$55(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onClick(View view) {
        if (this.pZJ.mhH != null) {
            this.pZJ.mhH.goBack();
            WebViewUI.am(this.pZJ);
        }
    }
}
