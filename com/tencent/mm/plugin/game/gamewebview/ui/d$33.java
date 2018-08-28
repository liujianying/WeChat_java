package com.tencent.mm.plugin.game.gamewebview.ui;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

class d$33 extends p {
    final /* synthetic */ d jJO;

    d$33(d dVar) {
        this.jJO = dVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        d.g(this.jJO).qfW.bXJ();
        if (ab.Ql(str)) {
            d.a(this.jJO, str);
            if (this.jJO.aSO()) {
                this.jJO.aSP();
            } else {
                this.jJO.aSQ();
            }
            d.a(this.jJO, str, false);
            d.h(this.jJO).bVT();
            d.h(this.jJO).setCurrentURL(str);
            if (!(d.i(this.jJO) == null || d.i(this.jJO).kdL == null)) {
                d.i(this.jJO).kdL.b(webView, str, bitmap);
            }
            a j = d.j(this.jJO);
            j.jIp = false;
            j.jIu = System.currentTimeMillis();
            h.mEJ.a(606, 0, 1, false);
            h.mEJ.a(611, 2, 1, false);
            return;
        }
        x.i("MicroMsg.GameWebPageView", "onPageStarted canLoadUrl fail, url = %s", new Object[]{str});
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, url = %s, id = %d", new Object[]{str, Integer.valueOf(hashCode())});
        if (!ab.Ql(str)) {
            x.f("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
            d.k(this.jJO);
            return true;
        } else if (s.fj(str, "about:blank")) {
            x.e("MicroMsg.GameWebPageView", "shouldOverride, url is about:blank");
            return true;
        } else if (str.startsWith("weixin://")) {
            x.e("MicroMsg.GameWebPageView", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
            return true;
        } else if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
            return true;
        } else {
            if (d.b(this.jJO, str)) {
                x.i("MicroMsg.GameWebPageView", "custom scheme url deal success, url = " + str);
                return true;
            }
            int Di = d.l(this.jJO).jIa.Di(str);
            boolean z = d.m(this.jJO).getBoolean("neverGetA8Key", false);
            if ((Di == 0 || Di == 2) && !z) {
                x.i("MicroMsg.GameWebPageView", "edw shouldOverride, should not continue, reason = " + Di);
                if (this.jJO.aSO()) {
                    d.n(this.jJO).stopLoading();
                    d.n(this.jJO).post(new 1(this, str));
                } else {
                    d.n(this.jJO).stopLoading();
                }
                if (!str.equals(d.f(this.jJO))) {
                    d.a(this.jJO, str, true);
                    return true;
                }
            }
            x.w("MicroMsg.GameWebPageView", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
            return super.b(webView, str);
        }
    }

    public final void a(WebView webView, String str) {
        d.o(this.jJO).setVisibility(8);
        if (ab.Ql(str)) {
            d.h(this.jJO).setCurrentURL(this.jJO.getCurrentURL());
            d.p(this.jJO).finish();
            if (!(d.i(this.jJO) == null || d.i(this.jJO).kdL == null)) {
                d.i(this.jJO).kdL.a(webView, str);
            }
            a j = d.j(this.jJO);
            x.d("MicroMsg.GameWebViewReportManager", "loadTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - j.jIu)});
            j.jIo = 1;
            j.a(j.jGU.getCurrentURL(), 2, r4, j.jIo, 0);
            h.mEJ.a(611, 3, 1, false);
            if (d.q(this.jJO) != null) {
                d.q(this.jJO).amF();
            }
            d.g(this.jJO).qfW.bXK();
            return;
        }
        x.f("MicroMsg.GameWebPageView", "onPageFinished, canLoadUrl fail, url = " + str);
        d.k(this.jJO);
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.GameWebPageView", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
        d.a(this.jJO, webView.getUrl(), false);
        d.a(this.jJO, str);
    }

    @TargetApi(8)
    public final void a(WebView webView, com.tencent.xweb.h hVar, SslError sslError) {
        String r = webView.getUrl() == null ? d.r(this.jJO) : webView.getUrl();
        d.j(this.jJO).jIo = 0;
        h.mEJ.a(606, 2, 1, false);
        d.o(this.jJO).setVisibility(8);
        if (d.s(this.jJO) == null) {
            d.a(this.jJO, new b(d.t(this.jJO), d.n(this.jJO)));
        }
        d.s(this.jJO).a(r, hVar, sslError);
    }

    public final void a(WebView webView, int i, String str, String str2) {
        a j = d.j(this.jJO);
        j.jIo = 0;
        h.mEJ.a(606, 1, 1, false);
        h.mEJ.a(606, (long) com.tencent.mm.plugin.webview.ui.tools.a.Ay(i), 1, false);
        j.a(str2, 6, 0, j.jIo, i);
    }

    public final void f(WebView webView, String str) {
        if (ab.Ql(str)) {
            a j = d.j(this.jJO);
            if (!j.jIp) {
                j.jIp = true;
                x.d("MicroMsg.GameWebViewReportManager", "domReadyTime = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - j.jIu)});
                j.a(j.jGU.getCurrentURL(), 5, r4, j.jIo, 0);
                return;
            }
            return;
        }
        d.k(this.jJO);
    }

    public final m c(WebView webView, String str) {
        if (!(d.i(this.jJO) == null || d.i(this.jJO).kdL == null)) {
            m c = d.i(this.jJO).kdL.c(webView, str);
            if (c != null) {
                return c;
            }
        }
        return super.c(webView, str);
    }

    public final m a(WebView webView, l lVar) {
        if (!(d.i(this.jJO) == null || d.i(this.jJO).kdL == null)) {
            m a = d.i(this.jJO).kdL.a(webView, lVar);
            if (a != null) {
                return a;
            }
        }
        return super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        if (!(d.i(this.jJO) == null || d.i(this.jJO).kdL == null)) {
            m a = d.i(this.jJO).kdL.a(webView, lVar, bundle);
            if (a != null) {
                return a;
            }
        }
        if (com.tencent.mm.bz.a.hi(d.t(this.jJO))) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    x.i("MicroMsg.GameWebPageView", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                    d.c(this.jJO, lVar.getUrl().toString());
                }
            } catch (Exception e) {
                x.w("MicroMsg.GameWebPageView", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
            } catch (Throwable th) {
                x.w("MicroMsg.GameWebPageView", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
            }
        }
        return super.a(webView, lVar);
    }
}
