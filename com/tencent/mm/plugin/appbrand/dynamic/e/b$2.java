package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.util.Iterator;

class b$2 extends p {
    final /* synthetic */ b fwN;

    b$2(b bVar) {
        this.fwN = bVar;
    }

    public final void a(WebView webView, String str) {
        synchronized (b.a(this.fwN)) {
            Iterator it = b.a(this.fwN).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                b.b(this.fwN, (String) pair.first, (ValueCallback) pair.second);
            }
            b.a(this.fwN).clear();
            b.b(this.fwN);
        }
    }

    public final boolean b(WebView webView, String str) {
        return true;
    }
}
