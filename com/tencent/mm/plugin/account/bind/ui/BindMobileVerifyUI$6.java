package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.plugin.account.a$h;

class BindMobileVerifyUI$6 implements Runnable {
    final /* synthetic */ BindMobileVerifyUI eHl;

    BindMobileVerifyUI$6(BindMobileVerifyUI bindMobileVerifyUI) {
        this.eHl = bindMobileVerifyUI;
    }

    public final void run() {
        BindMobileVerifyUI.e(this.eHl);
        BindMobileVerifyUI.a(this.eHl, Integer.valueOf(BindMobileVerifyUI.e(this.eHl).intValue() - 1));
        if (BindMobileVerifyUI.e(this.eHl).intValue() > 0) {
            BindMobileVerifyUI.c(this.eHl).setText(this.eHl.getResources().getQuantityString(a$h.mobileverify_send_code_tip, BindMobileVerifyUI.e(this.eHl).intValue(), new Object[]{BindMobileVerifyUI.e(this.eHl)}));
            return;
        }
        BindMobileVerifyUI.c(this.eHl).setText(this.eHl.getResources().getQuantityString(a$h.mobileverify_send_code_tip, 0, new Object[]{Integer.valueOf(0)}));
        BindMobileVerifyUI.f(this.eHl);
    }
}
