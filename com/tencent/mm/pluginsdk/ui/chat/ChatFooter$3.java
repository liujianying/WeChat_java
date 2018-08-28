package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class ChatFooter$3 implements OnClickListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$3(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final synchronized void onClick(View view) {
        String obj = ChatFooter.a(this.qMv).getText().toString();
        x.d("MicroMsg.ChatFooter", "send msg onClick");
        if (obj.trim().length() == 0 && obj.length() != 0) {
            x.d("MicroMsg.ChatFooter", "empty message cant be sent");
            if (ChatFooter.l(this.qMv) == null || !ChatFooter.l(this.qMv).isShowing()) {
                ChatFooter.a(this.qMv, h.i(this.qMv.getContext(), R.l.chatting_empty_message_cant_be_sent, R.l.app_tip));
            }
        } else if (ChatFooter.j(this.qMv) != null && ChatFooter.j(this.qMv).Gk(obj)) {
            ChatFooter.a(this.qMv).clearComposingText();
            ChatFooter.a(this.qMv).setText("");
        }
    }
}
