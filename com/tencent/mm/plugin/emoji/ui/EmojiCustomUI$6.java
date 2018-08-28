package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c;

class EmojiCustomUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$6(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        EmojiCustomUI.a(this.ilG, c.ilR);
        return true;
    }
}
