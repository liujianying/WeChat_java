package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class BottleConversationUI$4 implements c {
    final /* synthetic */ BottleConversationUI hlc;

    BottleConversationUI$4(BottleConversationUI bottleConversationUI) {
        this.hlc = bottleConversationUI;
    }

    public final int cl(View view) {
        return BottleConversationUI.c(this.hlc).getPositionForView(view);
    }
}
