package com.tencent.mm.plugin.bottle.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BottleConversationUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ BottleConversationUI hlc;

    BottleConversationUI$9(BottleConversationUI bottleConversationUI) {
        this.hlc = bottleConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hlc.finish();
        return true;
    }
}
