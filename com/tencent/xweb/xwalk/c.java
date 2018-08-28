package com.tencent.xweb.xwalk;

import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.XWalkCookieManager;

public final class c implements a {
    XWalkCookieManager vEK = new XWalkCookieManager();

    public final void cIj() {
        this.vEK.setAcceptCookie(true);
    }

    public final void c(WebView webView) {
    }

    public final void removeAllCookie() {
        this.vEK.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.vEK.getCookie(str);
    }

    public final void setCookie(String str, String str2) {
        this.vEK.setCookie(str, str2);
    }

    public final void removeSessionCookie() {
        this.vEK.removeSessionCookie();
    }
}
