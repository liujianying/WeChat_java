package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.sdk.d;

class af$2 implements Runnable {
    final /* synthetic */ af pMC;
    final /* synthetic */ WebView pMD;
    final /* synthetic */ WebView pME;

    af$2(af afVar, WebView webView, WebView webView2) {
        this.pMC = afVar;
        this.pMD = webView;
        this.pME = webView2;
    }

    public final void run() {
        try {
            if (WebView.getTbsCoreVersion(ad.getContext()) == 0) {
                h.mEJ.h(15367, new Object[]{Integer.valueOf(1)});
            } else if (d.canOpenWebPlus(ad.getContext())) {
                x.i("WebSearchXWeb", "begin check use sys webview");
                if (af.b(this.pMD) > af.b(this.pME)) {
                    h.mEJ.h(15367, new Object[]{Integer.valueOf(2)});
                    af.b(this.pMC, true);
                } else {
                    h.mEJ.h(15367, new Object[]{Integer.valueOf(3)});
                    af.b(this.pMC, false);
                }
                x.i("WebSearchXWeb", "end  check use sys webview, isUseSysWebview %b", new Object[]{Boolean.valueOf(af.a(this.pMC))});
                af.b(this.pMC).edit().putBoolean("isUseSysWebview", af.a(this.pMC)).commit();
            } else {
                h.mEJ.h(15367, new Object[]{Integer.valueOf(1)});
            }
        } catch (Exception e) {
            x.e("WebSearchXWeb", "", new Object[]{e});
        }
    }
}
