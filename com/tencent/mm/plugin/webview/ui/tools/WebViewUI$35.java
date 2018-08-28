package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.a;

class WebViewUI$35 implements a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$35(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void a(ImageView imageView, MenuItem menuItem) {
        if (WebViewUI.i(menuItem)) {
            imageView.setVisibility(8);
            return;
        }
        String str = menuItem.getTitle();
        if (WebViewUI.L(this.pZJ).get(str) == null || ((Bitmap) WebViewUI.L(this.pZJ).get(str)).isRecycled()) {
            x.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
            try {
                String QO = this.pZJ.gcO.QO(str);
                if (!bi.oW(QO)) {
                    Bitmap Rf = d.Rf(QO);
                    if (Rf != null && !Rf.isRecycled()) {
                        imageView.setImageBitmap(Rf);
                        WebViewUI.L(this.pZJ).put(str, Rf);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                return;
            }
        }
        imageView.setImageBitmap((Bitmap) WebViewUI.L(this.pZJ).get(str));
    }
}
