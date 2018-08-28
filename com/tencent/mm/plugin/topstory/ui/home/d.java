package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.a;
import com.tencent.mm.plugin.topstory.ui.webview.b;
import com.tencent.mm.plugin.topstory.ui.webview.c;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;

public final class d {
    private bte ozF;
    private b ozG;
    private TopStoryWebView ozH;
    private com.tencent.mm.plugin.topstory.ui.webview.d ozI;
    boolean ozJ = false;

    public final void a(bte bte) {
        if (!this.ozJ) {
            this.ozJ = true;
            com.tencent.mm.plugin.topstory.ui.d.c(bte, "startCreateWB", System.currentTimeMillis());
            this.ozF = bte;
            this.ozG = new b();
            Runnable aVar = new a(this.ozG, (byte) 0);
            aVar.oCx = "";
            e.post(aVar, "TopStory.LoadHtmlDataFromSdcardTask");
            this.ozG.a(bte, false);
            this.ozH = new TopStoryWebView(ad.getContext());
            a aVar2 = new a();
            c cVar = new c(bte, this.ozG);
            this.ozI = new com.tencent.mm.plugin.topstory.ui.webview.d(this.ozH, bte, this.ozG);
            this.ozH.a(aVar2, cVar);
            this.ozH.addJavascriptInterface(this.ozI, "topStoryJSApi");
            byte[] bArr = this.ozG.oCt;
            if (bArr != null) {
                this.ozH.loadDataWithBaseURL(bte.url, new String(bArr), "text/html", "utf-8", null);
                this.ozG.oCt = null;
                com.tencent.mm.plugin.topstory.ui.d.c(bte, "endCreateWBWithLoadData", System.currentTimeMillis());
                return;
            }
            this.ozH.loadUrl(bte.url);
            com.tencent.mm.plugin.topstory.ui.d.c(bte, "endCreateWBWithLoadURL", System.currentTimeMillis());
        }
    }

    public final void a(b bVar) {
        bVar.a(this.ozG, this.ozH, this.ozI, this.ozF);
        this.ozG = null;
        this.ozH = null;
        this.ozI = null;
        this.ozF = null;
        this.ozJ = false;
    }
}
