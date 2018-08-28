package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$5 implements f {
    final /* synthetic */ a unz;

    BizConversationUI$a$5(a aVar) {
        this.unz = aVar;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.BizConversationUI", "onItemDel object null");
            return;
        }
        a.b(this.unz, obj.toString());
    }
}
