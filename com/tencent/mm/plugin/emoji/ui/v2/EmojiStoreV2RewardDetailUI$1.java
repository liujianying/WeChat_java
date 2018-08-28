package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class EmojiStoreV2RewardDetailUI$1 extends ag {
    final /* synthetic */ EmojiStoreV2RewardDetailUI iqc;

    EmojiStoreV2RewardDetailUI$1(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
        this.iqc = emojiStoreV2RewardDetailUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                if (EmojiStoreV2RewardDetailUI.a(this.iqc) != null) {
                    EmojiStoreV2RewardDetailUI.a(this.iqc).setVisibility(8);
                    return;
                }
                return;
            case 1002:
                if (EmojiStoreV2RewardDetailUI.a(this.iqc) != null) {
                    EmojiStoreV2RewardDetailUI.a(this.iqc).setVisibility(0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
