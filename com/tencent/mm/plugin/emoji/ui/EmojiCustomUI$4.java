package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c;
import com.tencent.mm.plugin.report.service.h;

class EmojiCustomUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiCustomUI ilG;

    EmojiCustomUI$4(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        EmojiCustomUI.a(this.ilG, c.ilS);
        h.mEJ.h(11596, new Object[]{Integer.valueOf(1)});
        return true;
    }
}
