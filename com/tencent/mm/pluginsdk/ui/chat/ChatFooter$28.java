package com.tencent.mm.pluginsdk.ui.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class ChatFooter$28 implements OnEditorActionListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$28(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4 && (i != 0 || !ChatFooter.h(this.qMv))) {
            return false;
        }
        ChatFooter.i(this.qMv).performClick();
        return true;
    }
}
