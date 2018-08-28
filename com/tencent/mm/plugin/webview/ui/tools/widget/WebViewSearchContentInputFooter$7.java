package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import com.tencent.mm.ui.MMActivity;

class WebViewSearchContentInputFooter$7 implements Runnable {
    final /* synthetic */ WebViewSearchContentInputFooter qlx;

    WebViewSearchContentInputFooter$7(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
        this.qlx = webViewSearchContentInputFooter;
    }

    public final void run() {
        MMActivity.showVKB((Activity) this.qlx.getContext());
    }
}
