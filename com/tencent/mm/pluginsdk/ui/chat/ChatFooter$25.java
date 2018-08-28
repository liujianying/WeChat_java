package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.R;

class ChatFooter$25 implements OnFocusChangeListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$25(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            ChatFooter.c(this.qMv).setBackground(this.qMv.getResources().getDrawable(R.g.input_bar_bg_active));
        } else {
            ChatFooter.c(this.qMv).setBackground(this.qMv.getResources().getDrawable(R.g.input_bar_bg_normal));
        }
    }
}
