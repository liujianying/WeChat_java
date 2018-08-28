package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SingleChatInfoUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SingleChatInfoUI tqo;

    SingleChatInfoUI$4(SingleChatInfoUI singleChatInfoUI) {
        this.tqo = singleChatInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tqo.finish();
        return true;
    }
}
