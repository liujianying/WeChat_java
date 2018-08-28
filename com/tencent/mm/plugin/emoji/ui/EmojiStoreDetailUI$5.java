package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;

class EmojiStoreDetailUI$5 implements OnCancelListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$5(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(EmojiStoreDetailUI.r(this.inz));
        EmojiStoreDetailUI.s(this.inz).setText(R.l.emoji_store_load_failed_network);
        EmojiStoreDetailUI.t(this.inz);
    }
}
