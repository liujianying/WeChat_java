package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.17;
import java.util.Map;

class FTSSOSHomeWebViewUI$17$1 implements Runnable {
    final /* synthetic */ Bundle qah;
    final /* synthetic */ Map qes;
    final /* synthetic */ 17 qet;

    FTSSOSHomeWebViewUI$17$1(17 17, Bundle bundle, Map map) {
        this.qet = 17;
        this.qah = bundle;
        this.qes = map;
    }

    public final void run() {
        boolean a;
        if (this.qet.qeq.pNV != null) {
            a = this.qet.qeq.pNV.a(this.qah.getString("type", "0"), this.qah.getString("isMostSearchBiz", "0"), this.qah.getString("isSug", "0"), this.qah.getString("scene", "0"), this.qah.getString("isLocalSug", "0"), this.qet.qeq.getTotalQuery(), this.qet.qeq.getInEditTextQuery(), this.qet.qeq.bXp(), this.qet.qeq.bXi(), this.qet.qeq.qel, this.qes);
        } else {
            a = false;
        }
        if (a) {
            this.qet.qeq.bXk().setHint(this.qet.qeq.AV(0));
            this.qet.qeq.qdW.Dd(7);
        }
    }
}
