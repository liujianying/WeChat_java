package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class ChatFooter$10 implements a {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$10(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void bbF() {
        ChatFooter.z(this.qMv);
        ChatFooter.c(this.qMv).setVisibility(0);
        ChatFooter.r(this.qMv).setVisibility(8);
        ChatFooter.a(this.qMv, true);
        ChatFooter.b(this.qMv, R.g.chatting_setmode_voice_btn);
        if (ChatFooter.i(this.qMv) != null) {
            ChatFooter.i(this.qMv).performClick();
        }
    }

    public final void gp(boolean z) {
        ChatFooter.z(this.qMv);
        ChatFooter.c(this.qMv).setVisibility(0);
        ChatFooter.r(this.qMv).setVisibility(8);
        ChatFooter.b(this.qMv, R.g.chatting_setmode_voice_btn);
        if (ChatFooter.a(this.qMv) != null) {
            this.qMv.setToSendTextColor(z);
        }
    }

    public final void apK() {
        ChatFooter.z(this.qMv);
        ChatFooter.c(this.qMv).setVisibility(0);
        ChatFooter.r(this.qMv).setVisibility(8);
        ChatFooter.a(this.qMv, true);
        ChatFooter.b(this.qMv, R.g.chatting_setmode_voice_btn);
        ChatFooter.a(this.qMv).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        ChatFooter.a(this.qMv).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        ChatFooter.z(this.qMv);
        ChatFooter.c(this.qMv).setVisibility(0);
        ChatFooter.r(this.qMv).setVisibility(8);
        ChatFooter.a(this.qMv, true);
        ChatFooter.b(this.qMv, R.g.chatting_setmode_voice_btn);
        try {
            ChatFooter.a(this.qMv).abr(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChatFooter", e, "", new Object[0]);
        }
    }
}
