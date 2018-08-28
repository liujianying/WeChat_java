package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiSortUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiSortUI imq;

    EmojiSortUI$1(EmojiSortUI emojiSortUI) {
        this.imq = emojiSortUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.imq.finish();
        return true;
    }
}
