package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SnsTimeLineUI$24 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$24(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        h.a(this.odw, this.odw.getString(j.notification_need_resend_dialog_prompt), "", this.odw.getString(j.notification_need_resend_dialog_prompt_resend_now), this.odw.getString(j.app_cancel), new 1(this), new 2(this));
    }
}
