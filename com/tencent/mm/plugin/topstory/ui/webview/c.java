package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.io.ByteArrayInputStream;

public final class c extends p {
    private bte ccA;
    private b oCA;

    public c(bte bte, b bVar) {
        this.ccA = bte;
        this.oCA = bVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        d.c(this.ccA, "pageStart", System.currentTimeMillis());
        x.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
        super.b(webView, str, bitmap);
    }

    public final void a(WebView webView, String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
        super.a(webView, str);
        d.c(this.ccA, "pageFinish", System.currentTimeMillis());
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[]{str});
        return super.b(webView, str);
    }

    public final m c(WebView webView, String str) {
        m Ow = Ow(str);
        if (Ow == null) {
            return super.c(webView, str);
        }
        return Ow;
    }

    public final m a(WebView webView, l lVar) {
        m Ow = Ow(lVar.getUrl().toString());
        if (Ow == null) {
            return super.a(webView, lVar);
        }
        return Ow;
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        m Ow = Ow(lVar.getUrl().toString());
        if (Ow == null) {
            return super.a(webView, lVar, bundle);
        }
        return Ow;
    }

    private m Ow(String str) {
        boolean z;
        m mVar = null;
        byte[] bArr;
        if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/app.html")) {
            bArr = this.oCA.oCt;
            this.oCA.oCt = null;
            if (bArr != null) {
                mVar = new m("text/html", "utf8", new ByteArrayInputStream(bArr));
                z = true;
            }
            z = false;
        } else if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/style.css")) {
            bArr = this.oCA.oCv;
            this.oCA.oCv = null;
            if (bArr != null) {
                mVar = new m("text/css", "utf8", new ByteArrayInputStream(bArr));
                z = true;
            }
            z = false;
        } else {
            if (str.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/build.js")) {
                bArr = this.oCA.oCu;
                this.oCA.oCu = null;
                if (bArr != null) {
                    mVar = new m("application/x-javascript", "utf8", new ByteArrayInputStream(bArr));
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            x.i("MicroMsg.TopStory.TopStoryWebViewClient", "tryToGetResourceFromCache useMemoryCache: %b url: %s", new Object[]{Boolean.valueOf(z), str});
        }
        return mVar;
    }
}
