package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Message;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.d.b;

class FTSSOSHomeWebViewUI$b$b extends b {
    final /* synthetic */ FTSSOSHomeWebViewUI.b qeD;

    private FTSSOSHomeWebViewUI$b$b(FTSSOSHomeWebViewUI.b bVar) {
        this.qeD = bVar;
    }

    public final void enter() {
        super.enter();
        FTSSOSHomeWebViewUI.g(this.qeD.qeq, a.b.qfr);
        this.qeD.qeq.qdi.setBackgroundResource(R.e.white);
        this.qeD.qeq.qdj.jzo.clearFocus();
        this.qeD.qeq.qdJ.setVisibility(0);
        this.qeD.qeq.qdi.setPadding(this.qeD.qeq.qdX, 0, 0, 0);
        this.qeD.qeq.bXk().aQY();
        this.qeD.qeq.mPT.setVisibility(0);
        this.qeD.qeq.bXk().aQW();
        this.qeD.qeq.lAV.setVisibility(8);
        this.qeD.qeq.qdK.clear();
        this.qeD.qeq.mTX.setVisibility(0);
        this.qeD.qeq.jwW.setVisibility(8);
        this.qeD.qeq.qdP.setVisibility(8);
        this.qeD.qeq.qdj.setVoiceImageButtonVisibile(0);
        this.qeD.qeq.qdj.aQY();
        this.qeD.qeq.qdY;
        if (!this.qeD.qeq.qeb) {
            this.qeD.qeq.bXk().aQW();
        }
        this.qeD.qeq.neM.setVisibility(0);
        if (d.fR(23) && !com.tencent.mm.ui.statusbar.d.Af()) {
            this.qeD.qeq.Z(this.qeD.qeq.getResources().getColor(R.e.white), true);
        }
        this.qeD.qeq.titleView.setAlpha(0.0f);
        this.qeD.qeq.qdU.setVisibility(0);
        this.qeD.qeq.lAV.setAlpha(1.0f);
        LayoutParams layoutParams = (LayoutParams) this.qeD.qeq.qdi.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        if (this.qeD.qeq.qeb) {
            layoutParams.topMargin = 0;
        }
        layoutParams.width = -1;
        this.qeD.qeq.qdi.setLayoutParams(layoutParams);
        this.qeD.qeq.qdi.setY(0.0f);
        this.qeD.qeq.qdi.setX(0.0f);
        if (this.qeD.qeq.qeb) {
            this.qeD.qeq.qdi.setTranslationX(0.0f);
            this.qeD.qeq.qdi.setTranslationY(0.0f);
        }
        if (this.qeD.qeq.qeb && this.qeD.qeq.qec) {
            this.qeD.qeq.qdi.setVisibility(8);
            this.qeD.qeq.titleView.setAlpha(1.0f);
            this.qeD.qeq.mTX.setVisibility(0);
            this.qeD.qeq.titleView.setVisibility(0);
            this.qeD.qeq.titleView.setText(R.l.websearch_sos_home_hardcode_title);
        }
    }

    public final void exit() {
        super.exit();
    }

    public final boolean j(Message message) {
        switch (message.what) {
            case 0:
                this.qeD.qeq.bXk().aQY();
                break;
            case 2:
                if (!this.qeD.qeq.qeb) {
                    FTSSOSHomeWebViewUI.R(this.qeD.qeq);
                    this.qeD.qeq.qdR.setVisibility(8);
                    this.qeD.qeq.AU(0);
                    this.qeD.qeq.qdL.AZ(a.b.qfq);
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
                if (this.qeD.qeq.bXk().getEditText().hasFocus()) {
                    this.qeD.b(this.qeD.qeA);
                    h.mEJ.h(15521, new Object[]{Integer.valueOf(this.qeD.qeq.scene), Integer.valueOf(2), this.qeD.qeq.bXk().getInEditTextQuery(), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.qeD.qeq.qdD)});
                    break;
                }
                break;
        }
        return super.j(message);
    }

    public final String getName() {
        return "SearchNoFocusState";
    }
}
