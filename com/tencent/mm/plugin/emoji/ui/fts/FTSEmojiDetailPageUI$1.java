package com.tencent.mm.plugin.emoji.ui.fts;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FTSEmojiDetailPageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ FTSEmojiDetailPageUI ioG;

    FTSEmojiDetailPageUI$1(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.ioG = fTSEmojiDetailPageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ioG.finish();
        return false;
    }
}
