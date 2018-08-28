package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.d.b;

class FTSSOSHomeWebViewUI$b$c extends b {
    final /* synthetic */ FTSSOSHomeWebViewUI.b qeD;

    private FTSSOSHomeWebViewUI$b$c(FTSSOSHomeWebViewUI.b bVar) {
        this.qeD = bVar;
    }

    public final void enter() {
        super.enter();
        this.qeD.qeq.qdi.setPadding(FTSSOSHomeWebViewUI.M(this.qeD.qeq), 0, 0, 0);
        this.qeD.qeq.bXk().aQY();
        this.qeD.qeq.mPT.setVisibility(0);
        this.qeD.qeq.bXk().aQW();
        this.qeD.qeq.lAV.setVisibility(8);
        FTSSOSHomeWebViewUI.b(this.qeD.qeq).setVisibility(0);
        FTSSOSHomeWebViewUI.c(this.qeD.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.q(this.qeD.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.S(this.qeD.qeq).setVisibility(8);
        this.qeD.qeq.qdj.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.O(this.qeD.qeq).setVisibility(0);
        this.qeD.qeq.qdj.setVoiceImageButtonVisibile(0);
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 0:
                if (this.qeD.qeq.getTotalQuery().length() > 0) {
                    this.qeD.qeq.bXk().aQY();
                    this.qeD.qeq.bXk().jzo.clearFocus();
                    FTSSOSHomeWebViewUI.z(this.qeD.qeq).clear();
                    this.qeD.b(this.qeD.qeB);
                    break;
                }
                break;
            case 2:
                if (!this.qeD.qeq.qeb) {
                    FTSSOSHomeWebViewUI.R(this.qeD.qeq);
                    FTSSOSHomeWebViewUI.S(this.qeD.qeq).setVisibility(8);
                    FTSSOSHomeWebViewUI.d(this.qeD.qeq, 0);
                    FTSSOSHomeWebViewUI.T(this.qeD.qeq).AZ(a.b.qfq);
                    FTSSOSHomeWebViewUI.g(this.qeD.qeq, a.b.qfq);
                    break;
                }
                this.qeD.qeq.finish();
                break;
            case 5:
                if (this.qeD.qeq.bXk().getEditText().hasFocus()) {
                    this.qeD.b(this.qeD.qeA);
                    h.mEJ.h(15521, new Object[]{Integer.valueOf(this.qeD.qeq.scene), Integer.valueOf(2), this.qeD.qeq.bXk().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.qeD.qeq.qdD)});
                    break;
                }
                break;
            case 9:
                this.qeD.b(this.qeD.qez);
                break;
            case 10:
                if (this.qeD.qeq.getTotalQuery().length() > 0) {
                    this.qeD.b(this.qeD.qeB);
                    break;
                }
                break;
        }
        return super.j(message);
    }

    public final String getName() {
        return "SearchWithFocusNoResultState";
    }
}
