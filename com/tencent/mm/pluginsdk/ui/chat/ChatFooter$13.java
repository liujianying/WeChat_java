package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.mm.pluginsdk.ui.chat.n.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatFooter$13 implements a {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$13(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void bXG() {
        ChatFooter.B(this.qMv);
    }

    public final void RA(String str) {
        if (ChatFooter.j(this.qMv) != null) {
            ChatFooter.j(this.qMv).Gk(str);
        } else {
            x.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
        }
        ChatFooter.C(this.qMv).reset();
    }

    public final void ki(boolean z) {
        if (z) {
            if (this.qMv.qLK != null) {
                x.d("MicroMsg.ChatFooter", "onVoiceStart start");
                this.qMv.qLK.h(Boolean.valueOf(true));
            }
        } else if (this.qMv.qLK != null) {
            x.d("MicroMsg.ChatFooter", "onVoiceStart end");
            this.qMv.qLK.h(Boolean.valueOf(false));
        }
    }
}
