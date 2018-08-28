package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ChatFooter$11 implements b {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$11(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void ceh() {
        x.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(ChatFooter.b(this.qMv), "android.permission.RECORD_AUDIO", 80, "", "")), bi.cjd(), ChatFooter.b(this.qMv)});
        if (a.a(ChatFooter.b(this.qMv), "android.permission.RECORD_AUDIO", 80, "", "")) {
            int Lg = au.DF().Lg();
            if (Lg == 4 || Lg == 6) {
                ChatFooter.A(this.qMv);
            } else if (ChatFooter.l(this.qMv) == null || !ChatFooter.l(this.qMv).isShowing()) {
                ChatFooter.a(this.qMv, h.i(this.qMv.getContext(), R.l.voip_net_unavailable, R.l.app_tip));
            }
        }
    }
}
