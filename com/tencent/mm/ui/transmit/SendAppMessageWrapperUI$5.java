package com.tencent.mm.ui.transmit;

import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class SendAppMessageWrapperUI$5 implements a {
    final /* synthetic */ SendAppMessageWrapperUI uEK;

    SendAppMessageWrapperUI$5(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        this.uEK = sendAppMessageWrapperUI;
    }

    public final void a(boolean z, String str, int i) {
        this.uEK.setResult(-1);
        this.uEK.finish();
        ReportUtil.a(this.uEK, ReportUtil.c(this.uEK.getIntent().getExtras(), 0));
    }
}
