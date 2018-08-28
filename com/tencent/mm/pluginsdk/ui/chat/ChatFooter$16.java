package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.R;
import com.tencent.mm.bp.a;

class ChatFooter$16 implements Runnable {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$16(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void run() {
        if (ChatFooter.D(this.qMv) != null) {
            ChatFooter.D(this.qMv).dismiss();
            ChatFooter.E(this.qMv).setVisibility(0);
            ChatFooter.F(this.qMv).setVisibility(8);
            ChatFooter.G(this.qMv).setVisibility(8);
            ChatFooter.w(this.qMv).setVisibility(8);
            ChatFooter.v(this.qMv).setVisibility(0);
        }
        ChatFooter.r(this.qMv).setBackgroundDrawable(a.f(this.qMv.getContext(), R.g.record_shape_normal));
        ChatFooter.r(this.qMv).setText(R.l.chatfooter_presstorcd);
        ChatFooter.d(this.qMv, false);
        ChatFooter.c(this.qMv, false);
    }
}
