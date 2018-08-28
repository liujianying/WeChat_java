package com.tencent.mm.plugin.appbrand.g;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.util.Iterator;

class j$2 extends p {
    final /* synthetic */ j gdV;

    j$2(j jVar) {
        this.gdV = jVar;
    }

    public final void a(WebView webView, String str) {
        synchronized (j.a(this.gdV)) {
            Iterator it = j.a(this.gdV).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                j.b(this.gdV, (String) pair.first, (ValueCallback) pair.second);
            }
            j.a(this.gdV).clear();
            j.b(this.gdV);
        }
    }

    public final boolean b(WebView webView, String str) {
        return true;
    }
}
