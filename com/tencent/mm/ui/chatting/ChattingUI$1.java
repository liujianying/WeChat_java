package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class ChattingUI$1 implements Runnable {
    final /* synthetic */ ChattingUI tLZ;

    ChattingUI$1(ChattingUI chattingUI) {
        this.tLZ = chattingUI;
    }

    public final void run() {
        h.a(this.tLZ, this.tLZ.getString(R.l.notification_need_resend_dialog_prompt), "", this.tLZ.getString(R.l.notification_need_resend_dialog_prompt_resend_now), this.tLZ.getString(R.l.app_cancel), new 1(this), new 2(this));
    }
}
