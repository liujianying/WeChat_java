package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;

class a$a extends b {
    final /* synthetic */ a qfR;

    public a$a(a aVar, MMWebView mMWebView) {
        this.qfR = aVar;
        super(mMWebView);
    }

    protected final void a(WebView webView, String str, Bitmap bitmap) {
        x.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = " + str);
        this.qfR.jJI.qfW.bXJ();
        this.qfR.qfN.kdL.b(webView, str, bitmap);
    }

    protected final void e(WebView webView, String str) {
        x.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s", new Object[]{str});
        this.dEn.setVisibility(0);
        this.qfR.qfN.kdL.a(webView, str);
        this.qfR.qfN.onDestroy();
        this.qfR.jJI.qfW.bXK();
    }

    protected final void a(d dVar, e eVar) {
        this.qfR.qcA = dVar;
    }

    protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
        x.i("MicroMsg.GameFloatWebView", "jsapi ready");
        this.qfR.qfM = dVar;
    }

    protected final void a(f fVar) {
        x.i("MicroMsg.GameFloatWebView", "jsloader ready");
        this.qfR.qfP = fVar;
    }

    protected final boolean Rm(String str) {
        return this.qfR.qfN.DS(str);
    }

    protected final void Do(String str) {
        if (this.qfR.qfN.aVm()) {
            this.dEn.loadUrl(str);
        } else {
            super.Do(str);
        }
    }

    public final boolean RB(String str) {
        return super.RB(str);
    }

    protected final void RC(String str) {
        try {
            x.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", new Object[]{str});
            this.qfR.CK.removeView(this.dEn);
        } catch (Exception e) {
        }
    }

    protected final void bXH() {
        if (VERSION.SDK_INT >= 11) {
            this.dEn.removeJavascriptInterface("MicroMsg");
            this.dEn.removeJavascriptInterface("JsApi");
        }
        try {
            this.dEn.setWebChromeClient(null);
            this.dEn.setWebViewClient(null);
            this.dEn.setOnTouchListener(null);
            this.dEn.setOnLongClickListener(null);
            this.dEn.setVisibility(8);
            this.dEn.removeAllViews();
            this.dEn.clearView();
        } catch (Exception e) {
            x.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", new Object[]{e.getMessage()});
        }
        try {
            this.dEn.destroy();
        } catch (Exception e2) {
            x.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
        }
    }

    protected final k aks() {
        return this.qfR.qfQ;
    }

    public final m c(WebView webView, String str) {
        m c = this.qfR.qfN.kdL.c(webView, str);
        return c != null ? c : super.c(webView, str);
    }

    public final m a(WebView webView, l lVar) {
        m a = this.qfR.qfN.kdL.a(webView, lVar);
        return a != null ? a : super.a(webView, lVar);
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        m a = this.qfR.qfN.kdL.a(webView, lVar, bundle);
        return a != null ? a : super.a(webView, lVar, bundle);
    }
}
