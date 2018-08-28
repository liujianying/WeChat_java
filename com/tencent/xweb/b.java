package com.tencent.xweb;

import com.tencent.xweb.c.b.a;

public final class b {
    private static b vzU;
    public a vzV;

    private b() {
    }

    public static synchronized b cIi() {
        b bVar;
        synchronized (b.class) {
            if (vzU == null) {
                vzU = new b();
            }
            bVar = vzU;
        }
        return bVar;
    }

    public final void removeAllCookie() {
        this.vzV.removeAllCookie();
    }

    public final String getCookie(String str) {
        return this.vzV.getCookie(str);
    }

    public final synchronized void setCookie(String str, String str2) {
        this.vzV.setCookie(str, str2);
    }

    public final synchronized void cIj() {
        if (this.vzV != null) {
            this.vzV.cIj();
        }
    }

    public final synchronized void c(WebView webView) {
        if (this.vzV != null) {
            this.vzV.c(webView);
        }
    }
}
