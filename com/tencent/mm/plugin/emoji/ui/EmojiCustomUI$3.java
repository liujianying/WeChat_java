package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiCustomUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$3(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ilG.finish();
        return true;
    }
}
