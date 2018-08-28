package com.tencent.mm.plugin.emoji.ui.fts;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class FTSEmojiDetailPageUI$3 implements d {
    final /* synthetic */ FTSEmojiDetailPageUI ioG;

    FTSEmojiDetailPageUI$3(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        this.ioG = fTSEmojiDetailPageUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                FTSEmojiDetailPageUI.h(this.ioG);
                return;
            case 2:
                FTSEmojiDetailPageUI.g(this.ioG);
                return;
            default:
                return;
        }
    }
}
