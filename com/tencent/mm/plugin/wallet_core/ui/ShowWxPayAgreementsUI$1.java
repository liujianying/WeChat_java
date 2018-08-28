package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class ShowWxPayAgreementsUI$1 implements OnClickListener {
    final /* synthetic */ ShowWxPayAgreementsUI psI;

    ShowWxPayAgreementsUI$1(ShowWxPayAgreementsUI showWxPayAgreementsUI) {
        this.psI = showWxPayAgreementsUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(15236, Integer.valueOf(2));
        this.psI.setResult(-1);
        this.psI.finish();
    }
}
