package com.tencent.mm.pluginsdk.ui.chat;

import android.os.Message;
import com.tencent.mm.compatible.a.a.a;

class ChatFooter$19 implements a {
    final /* synthetic */ boolean gnO;
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$19(ChatFooter chatFooter, boolean z) {
        this.qMv = chatFooter;
        this.gnO = z;
    }

    public final void run() {
        Message message = new Message();
        message.what = 1002;
        message.obj = Boolean.valueOf(this.gnO);
        ChatFooter.H(this.qMv).sendMessage(message);
    }
}
