package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.d.b;

class FTSSOSHomeWebViewUI$b$d extends b {
    final /* synthetic */ FTSSOSHomeWebViewUI.b qeD;

    private FTSSOSHomeWebViewUI$b$d(FTSSOSHomeWebViewUI.b bVar) {
        this.qeD = bVar;
    }

    public final void enter() {
        super.enter();
        FTSSOSHomeWebViewUI.L(this.qeD.qeq).setVisibility(0);
        this.qeD.qeq.qdi.setPadding(0, 0, 0, 0);
        FTSSOSHomeWebViewUI.S(this.qeD.qeq).setVisibility(8);
        this.qeD.qeq.qdj.setVoiceImageButtonVisibile(8);
        FTSSOSHomeWebViewUI.i(this.qeD.qeq);
        this.qeD.qeq.bXk().aQX();
        FTSSOSHomeWebViewUI.b(this.qeD.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.c(this.qeD.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.q(this.qeD.qeq).setVisibility(8);
        FTSSOSHomeWebViewUI.O(this.qeD.qeq).setVisibility(0);
        if (!this.qeD.qeq.bXk().jzo.hasFocus()) {
            this.qeD.qeq.bXk().aQU();
            this.qeD.qeq.showVKB();
        }
        if (d.fR(23) && !com.tencent.mm.ui.statusbar.d.Af()) {
            FTSSOSHomeWebViewUI.i(this.qeD.qeq, this.qeD.qeq.getResources().getColor(R.e.white));
        }
        if (!TextUtils.isEmpty(this.qeD.qeq.getInEditTextQuery())) {
            this.qeD.qeq.bXk().jfw.setVisibility(0);
        }
    }

    public final void exit() {
        super.exit();
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 0:
            case 11:
                if (this.qeD.qeq.getTotalQuery().length() > 0) {
                    this.qeD.b(this.qeD.qeB);
                    break;
                }
                break;
            case 2:
                if (!this.qeD.qeq.qeb) {
                    FTSSOSHomeWebViewUI.R(this.qeD.qeq);
                    FTSSOSHomeWebViewUI.S(this.qeD.qeq).setVisibility(8);
                    FTSSOSHomeWebViewUI.d(this.qeD.qeq, 0);
                    FTSSOSHomeWebViewUI.I(this.qeD.qeq).AZ(a.b.qfq);
                    FTSSOSHomeWebViewUI.g(this.qeD.qeq, a.b.qfq);
                    break;
                }
                this.qeD.qeq.finish();
                break;
            case 3:
            case 4:
                this.qeD.b(this.qeD.qez);
                break;
            case 5:
                if (!this.qeD.qeq.bXk().getEditText().hasFocus()) {
                    this.qeD.b(this.qeD.qeC);
                    break;
                }
                h.mEJ.h(15521, new Object[]{Integer.valueOf(this.qeD.qeq.scene), Integer.valueOf(2), this.qeD.qeq.bXk().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.qeD.qeq.qdD)});
                break;
        }
        return super.j(message);
    }

    public final String getName() {
        return "SearchWithFocusState";
    }
}
