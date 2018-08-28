package com.tencent.xweb.xwalk;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.xweb.m;
import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.e.g;
import com.tencent.xweb.xwalk.e.h;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

class h$2 extends k {
    final /* synthetic */ h vFd;

    h$2(h hVar, XWalkView xWalkView) {
        this.vFd = hVar;
        super(xWalkView);
    }

    public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
        boolean b = this.vFd.fwL.b(this.vFd.vCX, str);
        Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + b + " url = " + str);
        return b;
    }

    public final void onLoadStarted(XWalkView xWalkView, String str) {
        this.vFd.fwL.f(this.vFd.vCX, str);
    }

    public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
        m a;
        m c;
        h hVar = new h(xWalkWebResourceRequest);
        Bundle bundle = hVar.vCS == null ? null : hVar.vCS.getBundle();
        if (bundle != null) {
            a = this.vFd.fwL.a(this.vFd.vCX, hVar, bundle);
        } else {
            a = null;
        }
        if (a == null) {
            a = this.vFd.fwL.a(this.vFd.vCX, hVar);
        }
        if (a == null) {
            c = this.vFd.fwL.c(this.vFd.vCX, xWalkWebResourceRequest.getUrl().toString());
        } else {
            c = a;
        }
        if (c != null) {
            return createXWalkWebResourceResponse(c.mMimeType, c.mEncoding, c.mInputStream, c.mStatusCode, c.mReasonPhrase, c.mResponseHeaders);
        }
        return null;
    }

    public final void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
        Log.i("XWWebView", "onReceivedError " + str2);
        super.onReceivedLoadError(xWalkView, i, str, str2);
        this.vFd.vEZ = true;
        this.vFd.fwL.a(this.vFd.vCX, i, str, str2);
        this.vFd.vES.loadDataWithBaseURL("file:///android_asset/", String.format("<html>\n<head>\n</head>\n<body>\n<p><b><font size=\"15\">\n\n\n网页无法打开</font></b></p>\n<p><font size=\"7\">位于<b>%s</b>的网页无法加载，因为:</font></p>\n<p><font size=\"7\">错误码:%s</font></p>\n\n</body>\n\n</html>", new Object[]{str2, str}), "text/html", "utf-8", null);
        e.b(str2, i, System.currentTimeMillis() - this.vFd.vDd, this.vFd.type);
    }

    public final void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
        Log.i("XWWebView", "onReceivedSslError " + sslError.getPrimaryError());
        this.vFd.fwL.a(this.vFd.vCX, new g(valueCallback), sslError);
    }

    public final void onProgressChanged(XWalkView xWalkView, int i) {
        Log.i("XWWebView", "onProgressChanged, progress = " + i);
        this.vFd.goJ.a(this.vFd.vCX, i);
    }

    public final void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
        super.onDocumentLoadedInFrame(xWalkView, j);
    }

    public final void onLoadFinished(XWalkView xWalkView, String str) {
        super.onLoadFinished(xWalkView, str);
    }

    public final void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
        super.onReceivedClientCertRequest(xWalkView, clientCertRequest);
    }

    public final void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
        if (xWalkWebResourceResponse.getStatusCode() == 302) {
            String str = (String) xWalkWebResourceResponse.getResponseHeaders().get("location");
            if (str == null || str.isEmpty()) {
                str = (String) xWalkWebResourceResponse.getResponseHeaders().get("Location");
            }
            if (str != null && str.trim().startsWith("weixin://")) {
                this.vFd.fwL.b(this.vFd.vCX, str, null);
                this.vFd.vES.postDelayed(new 1(this, str), 300);
            }
        } else if (xWalkWebResourceResponse.getStatusCode() >= 400) {
            Log.i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
            this.vFd.fwL.a(new h(xWalkWebResourceRequest), xWalkWebResourceResponse == null ? null : new m(xWalkWebResourceResponse.getMimeType(), xWalkWebResourceResponse.getEncoding(), xWalkWebResourceResponse.getStatusCode(), xWalkWebResourceResponse.getReasonPhrase(), xWalkWebResourceResponse.getResponseHeaders(), xWalkWebResourceResponse.getData()));
        }
        super.onReceivedResponseHeaders(xWalkView, xWalkWebResourceRequest, xWalkWebResourceResponse);
    }

    public final void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
        if (str == null || !str.startsWith("data:text/html;charset=utf-8")) {
            this.vFd.fwL.a(this.vFd.vCX, str, z);
        }
    }

    public final void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
        super.onReceivedHttpAuthRequest(xWalkView, xWalkHttpAuthHandler, str, str2);
    }
}
