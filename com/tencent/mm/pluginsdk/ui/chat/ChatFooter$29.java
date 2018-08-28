package com.tencent.mm.pluginsdk.ui.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ChatFooter$29 implements OnTouchListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$29(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.qMv.setToSendTextColor(true);
        ChatFooter.a(this.qMv, 3);
        if (ChatFooter.j(this.qMv) != null) {
            ChatFooter.j(this.qMv).bcw();
        }
        ChatFooter.k(this.qMv);
        return false;
    }
}
