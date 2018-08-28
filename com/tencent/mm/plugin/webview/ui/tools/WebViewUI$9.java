package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.model.ak.g;

class WebViewUI$9 implements OnClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$9(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onClick(View view) {
        this.pZJ.j(WebViewUI.C(this.pZJ), true, -1);
        g bUy = this.pZJ.pQY.bUy();
        bUy.pSr = new Object[]{this.pZJ.cbP, Integer.valueOf(4)};
        bUy.c(this.pZJ.gcO);
    }
}
