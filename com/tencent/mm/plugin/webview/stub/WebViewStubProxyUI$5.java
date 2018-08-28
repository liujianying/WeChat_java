package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;

class WebViewStubProxyUI$5 implements e {
    final /* synthetic */ WebViewStubProxyUI pUE;

    WebViewStubProxyUI$5(WebViewStubProxyUI webViewStubProxyUI) {
        this.pUE = webViewStubProxyUI;
    }

    public final IBinder asBinder() {
        return null;
    }

    public final boolean As(int i) {
        WebViewStubProxyUI.a(this.pUE).As(i);
        return false;
    }

    public final boolean c(int i, Bundle bundle) {
        WebViewStubProxyUI.a(this.pUE).c(i, bundle);
        return false;
    }

    public final boolean a(c cVar) {
        WebViewStubProxyUI.a(this.pUE).a(cVar);
        return false;
    }

    public final boolean a(String str, String str2, Bundle bundle, boolean z) {
        x.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
        this.pUE.pUx = WebViewStubProxyUI.QL(str2);
        final String str3 = str;
        final String str4 = str2;
        final Bundle bundle2 = bundle;
        final boolean z2 = z;
        this.pUE.runOnUiThread(new Runnable() {
            public final void run() {
                h.Bh(WebViewStubProxyUI.b(WebViewStubProxyUI$5.this.pUE)).a(null, null, null);
                WebViewStubProxyUI$5.this.pUE.finish();
                try {
                    WebViewStubProxyUI.a(WebViewStubProxyUI$5.this.pUE).a(str3, str4, bundle2, z2);
                } catch (Exception e) {
                    x.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                }
            }
        });
        return false;
    }

    public final String bVl() {
        return WebViewStubProxyUI.a(this.pUE).bVl();
    }

    public final String getCurrentUrl() {
        return WebViewStubProxyUI.a(this.pUE).getCurrentUrl();
    }

    public final String bVm() {
        return WebViewStubProxyUI.a(this.pUE).bVm();
    }

    public final void jV(boolean z) {
        WebViewStubProxyUI.a(this.pUE).jV(z);
    }

    public final void jW(boolean z) {
        WebViewStubProxyUI.a(this.pUE).jW(z);
    }

    public final void q(int i, Bundle bundle) {
        WebViewStubProxyUI.a(this.pUE).q(i, bundle);
    }

    public final void bVn() {
        WebViewStubProxyUI.a(this.pUE).bVn();
    }

    public final void P(Bundle bundle) {
        WebViewStubProxyUI.a(this.pUE).P(bundle);
    }

    public final void QM(String str) {
        WebViewStubProxyUI.a(this.pUE).QM(str);
    }

    public final void bVo() {
        if (WebViewStubProxyUI.a(this.pUE) != null) {
            WebViewStubProxyUI.a(this.pUE).bVo();
        }
    }

    public final void e(String str, String str2, int i, int i2) {
    }

    public final void fo(String str, String str2) {
        WebViewStubProxyUI.a(this.pUE).fo(str, str2);
    }

    public final Bundle g(int i, Bundle bundle) {
        return WebViewStubProxyUI.a(this.pUE).g(i, bundle);
    }

    public final void Q(Bundle bundle) {
        WebViewStubProxyUI.a(this.pUE).Q(bundle);
    }

    public final void jX(boolean z) {
        WebViewStubProxyUI.a(this.pUE).jX(z);
    }

    public final void fp(String str, String str2) {
        WebViewStubProxyUI.a(this.pUE).fp(str, str2);
    }
}
