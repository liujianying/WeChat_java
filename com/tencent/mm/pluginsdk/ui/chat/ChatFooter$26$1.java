package com.tencent.mm.pluginsdk.ui.chat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.26;

class ChatFooter$26$1 implements OnClickListener {
    final /* synthetic */ String qMy;
    final /* synthetic */ 26 qMz;

    ChatFooter$26$1(26 26, String str) {
        this.qMz = 26;
        this.qMy = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 1;
        boolean a = q.a(this.qMy, ChatFooter.d(this.qMz.qMv), true);
        ChatFooter chatFooter = this.qMz.qMv;
        if (!a) {
            i2 = 0;
        }
        ChatFooter.a(chatFooter, i2, this.qMy);
    }
}
