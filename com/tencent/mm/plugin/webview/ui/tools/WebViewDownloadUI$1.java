package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewDownloadUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewDownloadUI pWE;

    WebViewDownloadUI$1(WebViewDownloadUI webViewDownloadUI) {
        this.pWE = webViewDownloadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pWE.finish();
        return true;
    }
}
