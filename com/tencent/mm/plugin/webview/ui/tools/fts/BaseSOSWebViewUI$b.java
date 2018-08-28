package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.io.InputStream;

class BaseSOSWebViewUI$b extends a {
    final /* synthetic */ BaseSOSWebViewUI qdp;

    private BaseSOSWebViewUI$b(BaseSOSWebViewUI baseSOSWebViewUI) {
        this.qdp = baseSOSWebViewUI;
        super(baseSOSWebViewUI);
    }

    /* synthetic */ BaseSOSWebViewUI$b(BaseSOSWebViewUI baseSOSWebViewUI, byte b) {
        this(baseSOSWebViewUI);
    }

    public final void a(WebView webView, String str) {
        super.a(webView, str);
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[]{Integer.valueOf(this.qdp.scene), str});
        this.qdp.showOptionMenu(false);
        if (!(this.qdp.qdj == null || BaseSOSWebViewUI.m(this.qdp))) {
            BaseSOSWebViewUI.bXl();
            this.qdp.qdj.jzo.clearFocus();
            this.qdp.YC();
        }
        BaseSOSWebViewUI.n(this.qdp);
        this.qdp.bXh();
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        super.b(webView, str, bitmap);
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", new Object[]{str});
        this.qdp.showOptionMenu(false);
        if (this.qdp.qdj != null && !BaseSOSWebViewUI.m(this.qdp)) {
            BaseSOSWebViewUI.bXm();
            this.qdp.qdj.jzo.clearFocus();
            this.qdp.YC();
        }
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (!(lVar == null || lVar.getUrl() == null || !lVar.getUrl().toString().startsWith("weixin://fts"))) {
            m Ry = Ry(lVar.getUrl().toString());
            if (Ry != null) {
                return Ry;
            }
        }
        return super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar) {
        if (!(lVar == null || lVar.getUrl() == null || !lVar.getUrl().toString().startsWith("weixin://fts"))) {
            m Ry = Ry(lVar.getUrl().toString());
            if (Ry != null) {
                return Ry;
            }
        }
        return super.a(webView, lVar);
    }

    public final m c(WebView webView, String str) {
        if (str.startsWith("weixin://fts")) {
            m Ry = Ry(str);
            if (Ry != null) {
                return Ry;
            }
        }
        return super.c(webView, str);
    }

    private static m Ry(String str) {
        InputStream openRead;
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
        try {
            openRead = FileOp.openRead(Uri.parse(str).getQueryParameter("path"));
        } catch (Exception e) {
            openRead = null;
        }
        if (openRead != null) {
            return new m("image/*", "utf8", openRead);
        }
        return null;
    }
}
