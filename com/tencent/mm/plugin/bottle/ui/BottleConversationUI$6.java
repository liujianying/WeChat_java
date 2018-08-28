package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class BottleConversationUI$6 implements f {
    final /* synthetic */ BottleConversationUI hlc;

    BottleConversationUI$6(BottleConversationUI bottleConversationUI) {
        this.hlc = bottleConversationUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.Bottle.BottleConversationUI", "onItemDel object null");
        } else {
            BottleConversationUI.a(this.hlc, obj.toString());
        }
    }
}
