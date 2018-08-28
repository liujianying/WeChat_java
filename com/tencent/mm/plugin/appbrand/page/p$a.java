package com.tencent.mm.plugin.appbrand.page;

import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.platformtools.x;

class p$a {
    final /* synthetic */ p gnH;

    private p$a(p pVar) {
        this.gnH = pVar;
    }

    /* synthetic */ p$a(p pVar, byte b) {
        this(pVar);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final float getPixelRatio() {
        return this.gnH.mContext.getResources().getDisplayMetrics().density;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final float getWidth() {
        x.i("MicroMsg.AppBrandPageView", "DeviceInfoForSDK.getWidth view-width %d", new Object[]{Integer.valueOf(this.gnH.getContentView().getWidth())});
        return ((float) this.gnH.mContext.getResources().getDisplayMetrics().widthPixels) / getPixelRatio();
    }
}
