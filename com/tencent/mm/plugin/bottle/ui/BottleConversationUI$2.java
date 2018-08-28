package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class BottleConversationUI$2 implements d {
    final /* synthetic */ BottleConversationUI hlc;

    BottleConversationUI$2(BottleConversationUI bottleConversationUI) {
        this.hlc = bottleConversationUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        BottleConversationUI.a(this.hlc, BottleConversationUI.e(this.hlc));
    }
}
