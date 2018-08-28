package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.model.s;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.q;
import com.tencent.mm.ui.v;

class s$a extends v {
    final /* synthetic */ s tQv;

    s$a(s sVar) {
        this.tQv = sVar;
    }

    public final void bHJ() {
        this.tQv.bAG.YC();
        if (s.hJ(this.tQv.bAG.getTalkerUserName())) {
            this.tQv.bAG.tTq.getContext().startActivity(new Intent(this.tQv.bAG.tTq.getContext(), ServiceNotifySettingsUI.class));
        } else if (((q) this.tQv.bAG.O(q.class)).cvD()) {
            s.a(this.tQv);
        } else if (!((c) this.tQv.bAG.O(c.class)).cuA()) {
            Intent intent = new Intent();
            intent.setClass(this.tQv.bAG.tTq.getContext(), SingleChatInfoUI.class);
            intent.putExtra("Single_Chat_Talker", this.tQv.bAG.getTalkerUserName());
            intent.putExtra("fromChatting", true);
            this.tQv.bAG.tTq.startActivity(intent);
        }
    }
}
