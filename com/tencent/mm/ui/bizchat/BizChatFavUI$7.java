package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizChatFavUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ BizChatFavUI tEG;

    BizChatFavUI$7(BizChatFavUI bizChatFavUI) {
        this.tEG = bizChatFavUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tEG.finish();
        return true;
    }
}
