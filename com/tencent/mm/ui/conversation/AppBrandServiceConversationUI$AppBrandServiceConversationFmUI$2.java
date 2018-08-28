package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2 implements f {
    final /* synthetic */ AppBrandServiceConversationFmUI umW;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$2(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.umW = appBrandServiceConversationFmUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
            return;
        }
        AppBrandServiceConversationFmUI.access$800(this.umW, obj.toString());
    }
}
