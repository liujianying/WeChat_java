package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewUI$41 implements OnMenuItemClickListener {
    final /* synthetic */ String dMs;
    final /* synthetic */ WebViewUI pZJ;
    final /* synthetic */ boolean qay;

    WebViewUI$41(WebViewUI webViewUI, boolean z, String str) {
        this.pZJ = webViewUI;
        this.qay = z;
        this.dMs = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.qay) {
            WebViewUI.i(this.pZJ, this.dMs);
        } else {
            this.pZJ.aTe();
        }
        return true;
    }
}
