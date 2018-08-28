package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.util.Iterator;

class b$2 extends p {
    final /* synthetic */ b fBh;

    b$2(b bVar) {
        this.fBh = bVar;
    }

    public final m c(WebView webView, String str) {
        return sT(str);
    }

    public final m a(WebView webView, l lVar) {
        return sT(lVar.getUrl().toString());
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        return sT(lVar.getUrl().toString());
    }

    private static m sT(String str) {
        if ("wagame://WAGameVConsole.html".equals(str)) {
            return WxaCommLibRuntimeReader.qK("WAGameVConsole.html");
        }
        return null;
    }

    public final void a(WebView webView, String str) {
        b.a(this.fBh);
        if (b.b(this.fBh) != null && !b.b(this.fBh).isEmpty()) {
            Iterator it = b.b(this.fBh).iterator();
            while (it.hasNext()) {
                b.a(this.fBh, (String) it.next());
            }
        }
    }
}
