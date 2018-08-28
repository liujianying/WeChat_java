package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$3 implements c {
    final /* synthetic */ a unz;

    BizConversationUI$a$3(a aVar) {
        this.unz = aVar;
    }

    public final int cl(View view) {
        return a.d(this.unz).getPositionForView(view);
    }
}
