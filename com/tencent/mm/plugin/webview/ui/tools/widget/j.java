package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class j extends i {
    d qkY;
    private k qkZ;

    public j(MMWebView mMWebView, d dVar) {
        this(mMWebView, dVar, null);
    }

    public j(MMWebView mMWebView, d dVar, Bundle bundle) {
        super(mMWebView, false, bundle);
        this.qkY = null;
        this.qkZ = null;
        this.qkY = dVar;
    }

    protected final k aks() {
        if (this.qkZ == null) {
            this.qkZ = new 1(this);
        }
        return this.qkZ;
    }

    protected final void a(WebView webView, String str, Bitmap bitmap) {
        super.a(webView, str, bitmap);
        if (this.qkY instanceof e) {
            ((e) this.qkY).Jo();
        }
    }

    protected final void e(WebView webView, String str) {
        super.e(webView, str);
        if (this.qkY instanceof e) {
            ((e) this.qkY).Jp();
        }
    }
}
