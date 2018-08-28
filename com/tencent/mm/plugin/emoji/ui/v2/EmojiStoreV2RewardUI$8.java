package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;

class EmojiStoreV2RewardUI$8 implements OnCancelListener {
    final /* synthetic */ EmojiStoreV2RewardUI iqC;

    EmojiStoreV2RewardUI$8(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.iqC = emojiStoreV2RewardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(EmojiStoreV2RewardUI.k(this.iqC));
    }
}
