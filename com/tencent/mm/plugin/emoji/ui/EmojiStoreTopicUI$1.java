package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreTopicUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreTopicUI inJ;

    EmojiStoreTopicUI$1(EmojiStoreTopicUI emojiStoreTopicUI) {
        this.inJ = emojiStoreTopicUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
        if (bi.oW(EmojiStoreTopicUI.a(this.inJ)) || bi.oW(EmojiStoreTopicUI.b(this.inJ))) {
            x.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
        } else {
            EmojiStoreTopicUI.c(this.inJ);
        }
        return true;
    }
}
