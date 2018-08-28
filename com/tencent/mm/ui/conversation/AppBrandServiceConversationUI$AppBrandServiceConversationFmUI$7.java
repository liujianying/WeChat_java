package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$7 implements c {
    final /* synthetic */ AppBrandServiceConversationFmUI umW;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$7(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.umW = appBrandServiceConversationFmUI;
    }

    public final int cl(View view) {
        return AppBrandServiceConversationFmUI.access$300(this.umW).getPositionForView(view);
    }
}
