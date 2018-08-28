package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiMineUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiMineUI imi;

    EmojiMineUI$1(EmojiMineUI emojiMineUI) {
        this.imi = emojiMineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.imi.finish();
        return true;
    }
}
