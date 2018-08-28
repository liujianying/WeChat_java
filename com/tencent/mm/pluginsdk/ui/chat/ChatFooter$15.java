package com.tencent.mm.pluginsdk.ui.chat;

class ChatFooter$15 implements Runnable {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$15(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void run() {
        ChatFooter.v(this.qMv).setVisibility(0);
    }
}
