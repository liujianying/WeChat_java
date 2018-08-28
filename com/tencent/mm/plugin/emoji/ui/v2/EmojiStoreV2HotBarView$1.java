package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class EmojiStoreV2HotBarView$1 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2HotBarView ipO;

    EmojiStoreV2HotBarView$1(EmojiStoreV2HotBarView emojiStoreV2HotBarView) {
        this.ipO = emojiStoreV2HotBarView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.ipO.getContext(), EmojiStoreV2RankUI.class);
        this.ipO.getContext().startActivity(intent);
    }
}
