package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.model.z.d;
import com.tencent.mm.ui.base.h;

class WebViewUI$59 implements d {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$59(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void Qk(String str) {
        WebViewUI.a(this.pZJ, str, true, 9);
    }

    public final void goBack() {
        if (this.pZJ.mhH != null && !WebViewUI.aE(this.pZJ)) {
            if (this.pZJ.mhH.canGoBack() && this.pZJ.jJB) {
                this.pZJ.bWc();
                return;
            }
            g.pXv.close();
            this.pZJ.finish();
        }
    }

    public final void c(OnCancelListener onCancelListener) {
        if (WebViewUI.aM(this.pZJ) != null) {
            WebViewUI.aM(this.pZJ).dismiss();
        }
        WebViewUI.a(this.pZJ, h.a(this.pZJ, this.pZJ.getString(R.l.oauth_logining), true, onCancelListener));
    }

    public final void aFs() {
        if (WebViewUI.aM(this.pZJ) != null) {
            WebViewUI.aM(this.pZJ).dismiss();
        }
    }
}
