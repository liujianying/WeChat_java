package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.g.a.nb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ChatFooter$17 extends c<nb> {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$17(ChatFooter chatFooter) {
        this.qMv = chatFooter;
        this.sFo = nb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (ChatFooter.H(this.qMv) != null) {
            ChatFooter.H(this.qMv).post(new 1(this));
        }
        return false;
    }
}
