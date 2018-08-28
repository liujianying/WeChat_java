package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;

class ChatFooter$5 implements OnClickListener {
    final /* synthetic */ ChatFooter qMv;

    ChatFooter$5(ChatFooter chatFooter) {
        this.qMv = chatFooter;
    }

    public final void onClick(View view) {
        this.qMv.cej();
        if (q.Hn().booleanValue() && this.qMv.qLJ != null) {
            this.qMv.qLJ.a(Boolean.valueOf(true), Boolean.valueOf(true));
        }
    }
}
