package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class WebViewUI$30 implements OnMenuItemClickListener {
    final /* synthetic */ String gdf;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$30(WebViewUI webViewUI, String str) {
        this.pZJ = webViewUI;
        this.gdf = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.pZJ.gcO.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        try {
            s.a(this.pZJ, this.gdf, b.cIi().getCookie(this.gdf), isSDCardAvailable);
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
        }
        return true;
    }
}
