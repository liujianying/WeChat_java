package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.xweb.c.f;
import com.tencent.xweb.e;

public final class d implements f {
    WebViewClient vCT = new WebViewClient();
    WebChromeClient vCU = new WebChromeClient();
    WebView vCV;

    public d(WebView webView) {
        this.vCV = webView;
    }

    public final void w(String str, Bitmap bitmap) {
        this.vCT.onPageStarted(this.vCV, str, bitmap);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
    }

    public final boolean a(String str, String str2, com.tencent.xweb.f fVar) {
        return false;
    }

    public final boolean b(String str, String str2, com.tencent.xweb.f fVar) {
        return false;
    }

    public final boolean a(String str, String str2, String str3, e eVar) {
        return false;
    }
}
