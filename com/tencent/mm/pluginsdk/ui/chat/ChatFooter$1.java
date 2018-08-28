package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.pluginsdk.ui.chat.m.a;

class ChatFooter$1 implements a {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$1(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void clear() {
        ChatFooter chatFooter = this.qMv;
        if (chatFooter.kXF != null) {
            chatFooter.kXF.setText("");
        }
    }
}
