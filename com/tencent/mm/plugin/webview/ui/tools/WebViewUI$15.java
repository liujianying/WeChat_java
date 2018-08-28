package com.tencent.mm.plugin.webview.ui.tools;

import android.view.KeyEvent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a;

class WebViewUI$15 implements a {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$15(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final void aSZ() {
        WebViewUI.c(this.pZJ, 0);
        this.pZJ.mhH.clearMatches();
        this.pZJ.pXM.bYy();
    }

    public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        if (webViewSearchContentInputFooter.getVisibility() == 0) {
            b(webViewSearchContentInputFooter);
        }
    }

    public final void aTa() {
        h.mEJ.a(480, 5, 1, false);
        this.pZJ.mhH.findNext(false);
    }

    public final void aTb() {
        h.mEJ.a(480, 4, 1, false);
        this.pZJ.mhH.findNext(true);
    }

    public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.pZJ.mhH.clearMatches();
        webViewSearchContentInputFooter.reset();
        this.pZJ.pXM.q(0, 0, true);
        WebViewUI.c(this.pZJ, false);
        this.pZJ.mhH.findAllAsync(webViewSearchContentInputFooter.getSearchContent());
    }

    public final boolean c(int i, KeyEvent keyEvent) {
        if (i == 67 && keyEvent.getAction() == 0) {
            h.mEJ.a(480, 6, 1, false);
        }
        return false;
    }

    public final void onShow() {
    }
}
