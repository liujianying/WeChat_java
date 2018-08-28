package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.util.e;
import com.tencent.xweb.x5.g.a;
import com.tencent.xweb.x5.g.b;
import org.xwalk.core.Log;

class j$2 extends c {
    final /* synthetic */ j vDW;

    j$2(j jVar) {
        this.vDW = jVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.i("X5WebView", "shouldOverrideUrlLoading " + str);
        if (this.vDW.vCZ != null) {
            return this.vDW.vCZ.b(this.vDW.vCX, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.i("X5WebView", "onPageStarted " + str);
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.b(this.vDW.vCX, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
        this.vDW.vDd = System.currentTimeMillis();
        e.cIH();
        e.cIL();
    }

    public final void onPageFinished(WebView webView, String str) {
        Log.i("X5WebView", "onPageFinished " + str);
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.a(this.vDW.vCX, str);
        } else {
            super.onPageFinished(webView, str);
        }
        e.gZ(System.currentTimeMillis() - this.vDW.vDd);
        e.hb(System.currentTimeMillis() - this.vDW.vDd);
    }

    public final void onLoadResource(WebView webView, String str) {
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.f(this.vDW.vCX, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.vDW.vCZ != null) {
            return a.b(this.vDW.vCZ.c(this.vDW.vCX, str));
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.vDW.vCZ == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return a.b(this.vDW.vCZ.a(this.vDW.vCX, new b(webResourceRequest)));
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        if (this.vDW.vCZ == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest, bundle);
        }
        return a.b(this.vDW.vCZ.a(this.vDW.vCX, new b(webResourceRequest), bundle));
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.bpf();
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.a(this.vDW.vCX, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.a(this.vDW.vCX, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
        e.cII();
        e.cIM();
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Log.i("X5WebView", "onReceivedSslError " + sslError.getPrimaryError());
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.a(this.vDW.vCX, new a(sslErrorHandler), sslError != null ? new android.net.http.SslError(sslError.getPrimaryError(), sslError.getCertificate()) : null);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Log.i("X5WebView", "onReceivedHttpError code:" + webResourceResponse.getStatusCode());
        if (this.vDW.vCZ != null) {
            this.vDW.vCZ.a(new b(webResourceRequest), g.a(webResourceResponse));
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }
}
