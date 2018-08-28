package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ao$1 implements d {
    final /* synthetic */ ao tTj;

    ao$1(ao aoVar) {
        this.tTj = aoVar;
    }

    public final void n(String str, long j) {
        x.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + str + " time " + j);
        if (s.hC(au.getNotification().xQ())) {
            h.a(this.tTj.bAG.tTq.getContext(), false, str, this.tTj.bAG.tTq.getMMResources().getString(R.l.voice_reminder_dialog_title), this.tTj.bAG.tTq.getMMResources().getString(R.l.voice_reminder_dialog_check), this.tTj.bAG.tTq.getMMResources().getString(R.l.voice_reminder_dialog_ignore), new 1(this, j), null);
        }
    }
}
