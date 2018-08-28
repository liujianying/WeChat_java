package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class h extends g {
    private final b qkG;

    public h(MMWebView mMWebView, b bVar) {
        super((MMWebViewWithJsApi) mMWebView);
        this.qkG = bVar;
    }

    public final void d(WebView webView, String str) {
        if (this.qkG != null) {
            this.qkG.iZ(str);
        } else {
            super.d(webView, str);
        }
    }
}
