package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewDownloadWithX5UI$1 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewDownloadWithX5UI pWO;

    WebViewDownloadWithX5UI$1(WebViewDownloadWithX5UI webViewDownloadWithX5UI) {
        this.pWO = webViewDownloadWithX5UI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.pWO.finish();
        return true;
    }
}
