package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;

class EmojiStoreDetailUI$18 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$18(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.inz, EmojiStoreV2RewardDetailUI.class);
        intent.putExtra("extra_id", EmojiStoreDetailUI.a(this.inz));
        intent.putExtra("extra_iconurl", EmojiStoreDetailUI.b(this.inz).jPG);
        intent.putExtra("extra_name", EmojiStoreDetailUI.b(this.inz).rwQ);
        if (EmojiStoreDetailUI.b(this.inz).rxl != null) {
            intent.putExtra("name", EmojiStoreDetailUI.b(this.inz).rxl.jPe);
        }
        this.inz.startActivity(intent);
    }
}
