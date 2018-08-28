package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$8(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            this.pZJ.mhH.loadUrl(this.pZJ.gcO.QY(null));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", new Object[]{e.getMessage()});
        }
        return false;
    }
}
