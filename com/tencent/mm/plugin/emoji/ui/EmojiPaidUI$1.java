package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiPaidUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiPaidUI imk;

    EmojiPaidUI$1(EmojiPaidUI emojiPaidUI) {
        this.imk = emojiPaidUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        EmojiPaidUI.a(this.imk);
        return true;
    }
}
