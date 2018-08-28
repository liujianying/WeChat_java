package com.tencent.mm.plugin.game.wepkg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.game.wepkg.utils.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;

public class a$c extends p {
    final /* synthetic */ a kdP;

    public a$c(a aVar) {
        this.kdP = aVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[]{str});
        a.a(this.kdP, System.currentTimeMillis());
        a.a(this.kdP, this.kdP.DS(str));
        super.b(webView, str, bitmap);
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[]{str});
        if (a.i(this.kdP) != 0) {
            long currentTimeMillis = System.currentTimeMillis() - a.i(this.kdP);
            String Eu = d.Eu(str);
            if (bi.oW(Eu)) {
                a.b("PageLoadTime", str, "", null, 2, currentTimeMillis, null);
            } else if (!a.j(this.kdP) || a.g(this.kdP) == null) {
                a.b("PageLoadTime", str, Eu, null, 0, currentTimeMillis, null);
            } else {
                a.b("PageLoadTime", str, a.g(this.kdP).kfA, a.g(this.kdP).version, 1, currentTimeMillis, null);
            }
            a.a(this.kdP, 0);
        }
        if (a.j(this.kdP) && a.k(this.kdP) != null) {
            if ((a.k(this.kdP).Eg(d.Ew(a.b(this.kdP))) != null ? 1 : null) != null) {
                x.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
                a.l(this.kdP).J(1000, 1000);
            }
        }
        a.a(this.kdP, this.kdP.DS(str));
        super.a(webView, str);
    }

    public final m c(WebView webView, String str) {
        if (!a.j(this.kdP)) {
            return null;
        }
        m Eg;
        if (a.k(this.kdP) != null) {
            Eg = a.k(this.kdP).Eg(d.Ew(str));
        } else {
            Eg = null;
        }
        if (Eg == null) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s", new Object[]{str});
        if (a.g(this.kdP) != null) {
            a.b("RequestHook", str, a.g(this.kdP).kfA, a.g(this.kdP).version, 1, 0, null);
        }
        return Eg;
    }

    public final m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString()) || !a.j(this.kdP)) {
            return null;
        }
        m Eg;
        if (a.k(this.kdP) != null) {
            Eg = a.k(this.kdP).Eg(d.Ew(lVar.getUrl().toString()));
        } else {
            Eg = null;
        }
        if (Eg == null) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (a.g(this.kdP) != null) {
            a.b("RequestHook", lVar.getUrl().toString(), a.g(this.kdP).kfA, a.g(this.kdP).version, 1, 0, null);
        }
        return Eg;
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString()) || !a.j(this.kdP)) {
            return null;
        }
        m Eg;
        if (a.k(this.kdP) != null) {
            Eg = a.k(this.kdP).Eg(d.Ew(lVar.getUrl().toString()));
        } else {
            Eg = null;
        }
        if (Eg == null) {
            return null;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame())});
        if (a.g(this.kdP) != null) {
            a.b("RequestHook", lVar.getUrl().toString(), a.g(this.kdP).kfA, a.g(this.kdP).version, 1, 0, null);
        }
        return Eg;
    }
}
