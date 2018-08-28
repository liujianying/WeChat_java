package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class WebViewUI$53 implements d {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$53(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        WebViewUI.k(this.pZJ, menuItem.getTitle().toString());
    }
}
