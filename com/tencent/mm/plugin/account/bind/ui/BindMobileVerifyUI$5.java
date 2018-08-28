package com.tencent.mm.plugin.account.bind.ui;

import java.util.TimerTask;

class BindMobileVerifyUI$5 extends TimerTask {
    final /* synthetic */ BindMobileVerifyUI eHl;

    BindMobileVerifyUI$5(BindMobileVerifyUI bindMobileVerifyUI) {
        this.eHl = bindMobileVerifyUI;
    }

    public final void run() {
        if (BindMobileVerifyUI.c(this.eHl) != null) {
            BindMobileVerifyUI.d(this.eHl);
        }
    }
}
