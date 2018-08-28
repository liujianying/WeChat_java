package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.HashMap;

class t$6 extends p {
    final /* synthetic */ t goK;

    t$6(t tVar) {
        this.goK = tVar;
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.i("MicroMsg.AppBrandWebView", "onPageStarted, url = %s", new Object[]{str});
        t.a(this.goK, false);
    }

    public final void a(WebView webView, String str) {
        x.i("MicroMsg.AppBrandWebView", "onPageFinished, url = %s", new Object[]{str});
        if (!t.c(this.goK)) {
            t.a(this.goK, true);
            t.a(this.goK, System.currentTimeMillis());
            t.d(this.goK);
        }
    }

    public final boolean b(WebView webView, String str) {
        x.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
        return true;
    }

    public final void a(WebView webView, h hVar, SslError sslError) {
        x.e("MicroMsg.AppBrandWebView", "SSL Error, Page URL: %s, Code %d", new Object[]{this.goK.getPagePath(), Integer.valueOf(sslError.getPrimaryError())});
        t.a(this.goK, hVar, sslError);
    }

    private m ve(String str) {
        m mVar = null;
        int i = (t.b(this.goK) == null || !t.b(this.goK).fcM.alp()) ? 0 : 1;
        if (str.startsWith(t.e(this.goK))) {
            m qK;
            if ((t.f(this.goK) || i != 0) && str.equals(t.g(this.goK))) {
                qK = WxaCommLibRuntimeReader.qK("WAPageFrame.html");
            } else {
                qK = ao.c(t.b(this.goK), str.replaceFirst(t.e(this.goK), ""));
            }
            if (qK == null) {
                x.e("MicroMsg.AppBrandWebView", "getAppResourceResponse %s not found", new Object[]{str});
                mVar = new m("image/*", "utf-8", 404, "Not Found", new HashMap(), new ByteArrayInputStream(new byte[0]));
            } else {
                mVar = qK;
            }
        } else if (str.startsWith("wxfile://")) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(t.a(this.goK), str);
            if (itemByLocalId != null) {
                try {
                    mVar = new m(itemByLocalId.mimeType, "utf-8", new FileInputStream(itemByLocalId.dDG));
                } catch (Throwable e) {
                    x.e("MicroMsg.AppBrandWebView", "tryInterceptWebViewRequest with localId(%s), exp = %s", new Object[]{str, bi.i(e)});
                }
            }
        } else {
            mVar = ao.c(t.b(this.goK), str);
        }
        if (!(mVar == null || mVar.mStatusCode == 404)) {
            mVar.setStatusCodeAndReasonPhrase(200, "Ok");
            mVar.mResponseHeaders = new HashMap();
        }
        if (!(str.startsWith("http") && mVar == null)) {
            String str2 = "MicroMsg.AppBrandWebView";
            String str3 = "tryInterceptWebViewRequest, reqURL = %s, response.code = %d";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (mVar == null) {
                i = -1;
            } else {
                i = mVar.mStatusCode;
            }
            objArr[1] = Integer.valueOf(i);
            x.i(str2, str3, objArr);
        }
        return mVar;
    }

    public final m c(WebView webView, String str) {
        if (bi.oW(str)) {
            return null;
        }
        return ve(str);
    }

    public final m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return null;
        }
        return ve(lVar.getUrl().toString());
    }

    public final m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bi.oW(lVar.getUrl().toString())) {
            return null;
        }
        return ve(lVar.getUrl().toString());
    }

    public final void a(WebView webView, int i, String str, String str2) {
        x.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", new Object[]{Integer.valueOf(i), str, str2});
    }

    public final void a(l lVar, m mVar) {
        Uri url = lVar.getUrl();
        String uri = url == null ? "null" : url.toString();
        x.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", new Object[]{uri, mVar.mMimeType, Integer.valueOf(mVar.mStatusCode)});
    }
}
