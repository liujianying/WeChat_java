package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class HtmlTextView2$2 extends p {
    final /* synthetic */ HtmlTextView2 lSe;

    HtmlTextView2$2(HtmlTextView2 htmlTextView2) {
        this.lSe = htmlTextView2;
    }

    public final boolean b(WebView webView, String str) {
        x.d("test", str);
        return true;
    }
}
