package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class d implements a {
    CookieManager vDw = CookieManager.getInstance();

    public final void cIj() {
        this.vDw.setAcceptCookie(true);
    }

    public final void c(WebView webView) {
        if (webView == null) {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
            return;
        }
        View webViewUI = webView.getWebViewUI();
        if (webViewUI instanceof com.tencent.smtt.sdk.WebView) {
            this.vDw.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView) webViewUI, true);
        } else {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
        }
    }

    public final void removeAllCookie() {
        this.vDw.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.vDw.getCookie(str);
    }

    public final void setCookie(String str, String str2) {
        this.vDw.setCookie(str, str2);
    }

    public final void removeSessionCookie() {
        this.vDw.removeSessionCookie();
    }
}
