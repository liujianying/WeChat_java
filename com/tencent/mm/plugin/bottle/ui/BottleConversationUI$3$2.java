package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.model.bd.a;
import com.tencent.mm.plugin.bottle.ui.BottleConversationUI.3;

class BottleConversationUI$3$2 implements a {
    final /* synthetic */ 3 hld;

    BottleConversationUI$3$2(3 3) {
        this.hld = 3;
    }

    public final boolean Ip() {
        return BottleConversationUI.f(this.hld.hlc);
    }

    public final void Io() {
        if (BottleConversationUI.g(this.hld.hlc) != null) {
            BottleConversationUI.g(this.hld.hlc).dismiss();
            BottleConversationUI.a(this.hld.hlc, null);
        }
    }
}
