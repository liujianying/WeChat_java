package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import com.tencent.xweb.util.e;
import org.xwalk.core.Log;

class e$1 extends WebViewClient {
    final /* synthetic */ e vDj;

    e$1(e eVar) {
        this.vDj = eVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.i("SysWebView", "shouldOverrideUrlLoading " + str);
        if (this.vDj.vCZ != null) {
            return this.vDj.vCZ.b(this.vDj.vCX, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.i("SysWebView", "onPageStarted " + str);
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.b(this.vDj.vCX, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
        this.vDj.vDd = System.currentTimeMillis();
        e.cIH();
        e.cIJ();
        if (this.vDj.vDe != null) {
            this.vDj.vDe.a(this.vDj.vCX, true);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        Log.i("SysWebView", "onPageFinished " + str);
        if (this.vDj.vDe != null) {
            this.vDj.vDe.a(this.vDj.vCX, false);
        }
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.a(this.vDj.vCX, str);
        } else {
            super.onPageFinished(webView, str);
        }
        e.gZ(System.currentTimeMillis() - this.vDj.vDd);
        e.ha(System.currentTimeMillis() - this.vDj.vDd);
    }

    public final void onLoadResource(WebView webView, String str) {
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.f(this.vDj.vCX, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.vDj.vCZ != null) {
            return c.a(this.vDj.vCZ.c(this.vDj.vCX, str));
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        m mVar = null;
        if (this.vDj.vCZ == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        Bundle bundle;
        c$e c_e = new c$e(webResourceRequest);
        if (c_e.vCS == null) {
            bundle = null;
        } else {
            bundle = c_e.vCS.getBundle();
        }
        if (bundle != null) {
            mVar = this.vDj.vCZ.a(this.vDj.vCX, c_e, bundle);
        }
        if (mVar == null) {
            mVar = this.vDj.vCZ.a(this.vDj.vCX, c_e);
        }
        return c.a(mVar);
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.bpf();
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.a(this.vDj.vCX, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.a(this.vDj.vCX, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
        e.cII();
        e.cIK();
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Log.i("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
        if (this.vDj.vCZ != null) {
            this.vDj.vCZ.a(this.vDj.vCX, new c$a(sslErrorHandler), sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Log.i("SysWebView", "onReceivedHttpError code:" + (VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : "Invalid"));
        if (this.vDj.vCZ != null) {
            p pVar = this.vDj.vCZ;
            c$e c_e = new c$e(webResourceRequest);
            m mVar = webResourceResponse == null ? null : VERSION.SDK_INT >= 21 ? new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData()) : new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
            pVar.a(c_e, mVar);
            return;
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }
}
