package com.tencent.mm.ui.bizchat;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$20 implements c {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$20(a aVar) {
        this.tEC = aVar;
    }

    public final int cl(View view) {
        return a.j(this.tEC).getPositionForView(view);
    }
}
