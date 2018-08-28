package com.tencent.mm.plugin.websearch.api;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

class aa$2 extends p {
    final /* synthetic */ aa pMf;
    final /* synthetic */ MMWebView pMg;

    aa$2(aa aaVar, MMWebView mMWebView) {
        this.pMf = aaVar;
        this.pMg = mMWebView;
    }

    public final void a(WebView webView, String str) {
        x.i(this.pMf.TAG, "onPageFinished, view %s", new Object[]{webView.toString()});
        this.pMf.a(this.pMg);
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i(this.pMf.TAG, "onPageStarted, view %s", new Object[]{webView.toString()});
        y.a(this.pMg);
    }

    public final boolean b(WebView webView, String str) {
        if (!y.fj(str, "weixin://private/setresult/")) {
            return false;
        }
        x.i(this.pMf.TAG, "handleUrl %s ,view %s", new Object[]{str, webView.toString()});
        this.pMg.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        return true;
    }
}
