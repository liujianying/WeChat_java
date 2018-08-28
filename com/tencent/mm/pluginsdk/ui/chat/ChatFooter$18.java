package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;

class ChatFooter$18 implements OnClickListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$18(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void onClick(View view) {
        if (ChatFooter.I(this.qMv) != null) {
            ChatFooter.I(this.qMv).kS(false);
        }
    }
}
