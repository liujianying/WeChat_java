package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import com.tencent.smtt.utils.t;
import java.io.InputStream;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class ad extends WebViewClient {
    private static String c = null;
    private WebViewClient a;
    private WebView b;

    private static class g extends WebResourceResponse {
        android.webkit.WebResourceResponse a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.a = webResourceResponse;
        }

        public InputStream getData() {
            return this.a.getData();
        }

        public String getEncoding() {
            return this.a.getEncoding();
        }

        public String getMimeType() {
            return this.a.getMimeType();
        }

        public String getReasonPhrase() {
            return this.a.getReasonPhrase();
        }

        public Map<String, String> getResponseHeaders() {
            return this.a.getResponseHeaders();
        }

        public int getStatusCode() {
            return this.a.getStatusCode();
        }

        public void setData(InputStream inputStream) {
            this.a.setData(inputStream);
        }

        public void setEncoding(String str) {
            this.a.setEncoding(str);
        }

        public void setMimeType(String str) {
            this.a.setMimeType(str);
        }

        public void setResponseHeaders(Map<String, String> map) {
            this.a.setResponseHeaders(map);
        }

        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    ad(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.a = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.b.a(webView);
        this.a.doUpdateVisitedHistory(this.b, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onFormResubmission(this.b, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        this.b.a(webView);
        this.a.onLoadResource(this.b, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (c == null) {
            t a = t.a();
            if (a != null) {
                a.a(true);
                c = Boolean.toString(true);
            }
        }
        this.b.a(webView);
        WebView webView2 = this.b;
        webView2.a++;
        this.a.onPageFinished(this.b, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.d();
        if (!(TbsShareManager.mHasQueryed || this.b.getContext() == null || !TbsShareManager.isThirdPartyApp(this.b.getContext()))) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new ae(this)).start();
        }
        if (this.b.getContext() != null && !TbsLogReport.a(this.b.getContext()).e()) {
            TbsLogReport.a(this.b.getContext()).a(true);
            TbsLogReport.a(this.b.getContext()).b();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.a.onPageStarted(this.b, str, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, i, str, str2);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        this.b.a(webView);
        com.tencent.smtt.export.external.interfaces.WebResourceRequest fVar = webResourceRequest != null ? new f(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new af(this, webResourceError);
        }
        this.a.onReceivedError(this.b, fVar, webResourceError2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        this.b.a(webView);
        this.a.onScaleChanged(this.b, f, f2);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onTooManyRedirects(this.b, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (webResourceRequest == null) {
            return null;
        }
        boolean z = false;
        if (VERSION.SDK_INT >= 24) {
            Object a = q.a(webResourceRequest, "isRedirect");
            if (a instanceof Boolean) {
                z = ((Boolean) a).booleanValue();
            }
        }
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, new e(this, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
        int statusCode = shouldInterceptRequest.getStatusCode();
        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
        if (statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            return webResourceResponse;
        }
        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        return webResourceResponse;
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str);
        return shouldInterceptRequest != null ? new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData()) : null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return this.a.shouldOverrideUrlLoading(this.b, str);
    }
}
