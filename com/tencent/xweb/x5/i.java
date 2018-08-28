package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.c.f;
import com.tencent.xweb.e;

public final class i implements f {
    c vDK = new c();
    b vDL = new b();
    WebView vDM;

    public i(WebView webView) {
        this.vDM = webView;
    }

    public final void w(String str, Bitmap bitmap) {
        this.vDK.b(this.vDM, str, bitmap);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
        this.vDL.cJi();
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
