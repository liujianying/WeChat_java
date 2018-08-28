package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WebViewUI$65 implements OnClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$65(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pZJ.pZc = true;
        g.pXv.close();
        this.pZJ.finish();
    }
}
