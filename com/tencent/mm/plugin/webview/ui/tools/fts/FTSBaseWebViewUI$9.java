package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.plugin.websearch.api.o;

class FTSBaseWebViewUI$9 implements Runnable {
    final /* synthetic */ FTSBaseWebViewUI qdI;

    FTSBaseWebViewUI$9(FTSBaseWebViewUI fTSBaseWebViewUI) {
        this.qdI = fTSBaseWebViewUI;
    }

    public final void run() {
        if (FTSBaseWebViewUI.e(this.qdI) != null) {
            FTSBaseWebViewUI.f(this.qdI).a(this.qdI.getTotalQuery(), this.qdI.getInEditTextQuery(), this.qdI.bXp(), 0, null);
            if (!TextUtils.isEmpty(this.qdI.getInEditTextQuery())) {
                o.a(FTSBaseWebViewUI.g(this.qdI), this.qdI.bJK, this.qdI.bWr, this.qdI.getInEditTextQuery(), FTSBaseWebViewUI.h(this.qdI));
            }
        }
    }
}
