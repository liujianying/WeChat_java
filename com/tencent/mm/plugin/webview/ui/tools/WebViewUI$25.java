package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView$b;

class WebViewUI$25 implements OnLongClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$25(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final boolean onLongClick(View view) {
        if (this.pZJ.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
            return bWF();
        }
        return true;
    }

    private boolean bWF() {
        boolean da;
        Exception e;
        boolean z;
        WebView$b hitTestResult = this.pZJ.mhH.getHitTestResult();
        if (hitTestResult == null || bi.oW(hitTestResult.mExtra)) {
            x.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
            return false;
        }
        try {
            da = this.pZJ.gcO.da(hitTestResult.mExtra);
            if (da) {
                try {
                    this.pZJ.gcO.cw(hitTestResult.mExtra, this.pZJ.hashCode());
                } catch (Exception e2) {
                    e = e2;
                    x.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                    z = da;
                    if (!z) {
                        return z;
                    }
                    WebViewUI.d(this.pZJ, hitTestResult.mExtra);
                    return true;
                }
            }
            z = da;
        } catch (Exception e3) {
            e = e3;
            da = true;
        }
        if (!z) {
            return z;
        }
        WebViewUI.d(this.pZJ, hitTestResult.mExtra);
        return true;
    }
}
