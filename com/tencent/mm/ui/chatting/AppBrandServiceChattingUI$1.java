package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class AppBrandServiceChattingUI$1 implements Runnable {
    final /* synthetic */ AppBrandServiceChattingUI tGI;

    AppBrandServiceChattingUI$1(AppBrandServiceChattingUI appBrandServiceChattingUI) {
        this.tGI = appBrandServiceChattingUI;
    }

    public final void run() {
        h.a(this.tGI, this.tGI.getString(R.l.notification_need_resend_dialog_prompt), "", this.tGI.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.tGI.getString(R.l.app_cancel), new 1(this), new 2(this));
    }
}
