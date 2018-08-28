package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.xweb.WebView;
import org.xwalk.core.Log;

public final class a implements com.tencent.xweb.c.b.a {
    CookieManager vCJ = CookieManager.getInstance();

    public final void cIj() {
        this.vCJ.setAcceptCookie(true);
    }

    public final void c(WebView webView) {
        if (VERSION.SDK_INT < 21) {
            return;
        }
        if (webView == null || webView.getWebViewUI() == null || !(webView.getWebViewUI() instanceof android.webkit.WebView)) {
            Log.e("SysCookieManagerWrapper", "webview kind not match");
        } else {
            this.vCJ.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI(), true);
        }
    }

    public final void removeAllCookie() {
        this.vCJ.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.vCJ.getCookie(str);
    }

    public final void setCookie(String str, String str2) {
        this.vCJ.setCookie(str, str2);
    }

    public final void removeSessionCookie() {
        this.vCJ.removeSessionCookie();
    }
}
