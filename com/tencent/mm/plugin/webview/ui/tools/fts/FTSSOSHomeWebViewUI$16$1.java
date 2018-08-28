package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.16;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class FTSSOSHomeWebViewUI$16$1 implements Runnable {
    final /* synthetic */ int ewz;
    final /* synthetic */ Bundle qah;
    final /* synthetic */ 16 qer;

    FTSSOSHomeWebViewUI$16$1(16 16, int i, Bundle bundle) {
        this.qer = 16;
        this.ewz = i;
        this.qah = bundle;
    }

    public final void run() {
        boolean z = false;
        if (FTSSOSHomeWebViewUI.k(this.qer.qeq) != null) {
            Map hashMap = new HashMap();
            hashMap.put("isHomePage", "0");
            if (this.ewz == 0) {
                hashMap.put("isHomePage", "1");
            } else if (this.ewz == 1) {
                hashMap.put("isMostSearchBiz", this.qah.getString("isMostSearchBiz", "0"));
            } else {
                hashMap.put("isHomePage", "0");
            }
            if (!bi.oW(this.qer.qeq.getTotalQuery())) {
                hashMap.put("query", this.qer.qeq.getTotalQuery());
            }
            z = FTSSOSHomeWebViewUI.l(this.qer.qeq).a(this.qah.getString("scene", "0"), this.qah.getString("type", "0"), this.qah.getString("isSug", "0"), this.qah.getString("isLocalSug", "0"), this.qer.qeq.getSessionId(), hashMap, null);
            if (!TextUtils.isEmpty(this.qer.qeq.getInEditTextQuery())) {
                o.a(this.qer.qeq.scene, this.qer.qeq.bJK, this.qer.qeq.bWr, this.qer.qeq.getInEditTextQuery(), this.qer.qeq.qdD);
            }
        }
        if (z) {
            this.qer.qeq.bXk().setHint(FTSSOSHomeWebViewUI.f(this.qer.qeq, this.ewz));
            ad.c(this.ewz, this.qer.qeq.qdC, FTSSOSHomeWebViewUI.m(this.qer.qeq), FTSSOSHomeWebViewUI.a(this.qer.qeq).bXy());
            FTSSOSHomeWebViewUI.a(this.qer.qeq).Dd(7);
        }
    }
}
