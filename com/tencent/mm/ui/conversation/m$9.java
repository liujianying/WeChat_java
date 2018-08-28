package com.tencent.mm.ui.conversation;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class m$9 implements Runnable {
    final /* synthetic */ m urw;

    m$9(m mVar) {
        this.urw = mVar;
    }

    public final void run() {
        h.a(this.urw.bOb, this.urw.bOb.getString(R.l.notification_need_resend_dialog_prompt), "", this.urw.bOb.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.urw.bOb.getString(R.l.app_cancel), new 1(this), new 2(this));
    }
}
