package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class EmojiStoreV2RewardDetailUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2RewardDetailUI iqc;

    EmojiStoreV2RewardDetailUI$3(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
        this.iqc = emojiStoreV2RewardDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.iqc.finish();
        return false;
    }
}
