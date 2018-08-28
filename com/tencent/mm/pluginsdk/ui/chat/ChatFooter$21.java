package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.sdk.platformtools.x;

class ChatFooter$21 implements Runnable {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$21(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void run() {
        if (this.qMv.ceH()) {
            x.i("changelcai", "isScrolling!! pass this event!");
        } else {
            ChatFooter.a(this.qMv, 1);
        }
    }
}
