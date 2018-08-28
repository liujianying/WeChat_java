package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BaseEmojiStoreUI$b implements OnMenuItemClickListener {
    final /* synthetic */ BaseEmojiStoreUI ikH;

    private BaseEmojiStoreUI$b(BaseEmojiStoreUI baseEmojiStoreUI) {
        this.ikH = baseEmojiStoreUI;
    }

    /* synthetic */ BaseEmojiStoreUI$b(BaseEmojiStoreUI baseEmojiStoreUI, byte b) {
        this(baseEmojiStoreUI);
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ikH.finish();
        return true;
    }
}
