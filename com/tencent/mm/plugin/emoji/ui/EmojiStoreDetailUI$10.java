package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.emoji.f.g;

class EmojiStoreDetailUI$10 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$10(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        EmojiStoreDetailUI.a(this.inz, new g(EmojiStoreDetailUI.a(this.inz), EmojiStoreDetailUI.B(this.inz), EmojiStoreDetailUI.C(this.inz)));
        EmojiStoreDetailUI.D(this.inz);
        EmojiStoreDetailUI.a(this.inz, 6);
        EmojiStoreDetailUI.g(this.inz);
    }
}
