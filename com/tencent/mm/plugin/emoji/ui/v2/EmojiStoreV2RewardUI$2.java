package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2RewardUI$2 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2RewardUI iqC;

    EmojiStoreV2RewardUI$2(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.iqC = emojiStoreV2RewardUI;
    }

    public final void onClick(View view) {
        if (EmojiStoreV2RewardUI.d(this.iqC) != null) {
            tq oT = EmojiStoreV2RewardUI.d(this.iqC).oT(0);
            if (EmojiStoreV2RewardUI.e(this.iqC).getText() != null) {
                oT.rxn = EmojiStoreV2RewardUI.e(this.iqC).getText().toString();
                EmojiStoreV2RewardUI.a(this.iqC, EmojiStoreV2RewardUI.f(this.iqC), oT);
                return;
            }
            x.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mRewardInputView is null");
            return;
        }
        x.w("MicroMsg.emoji.EmojiStoreV2RewardUI", "mAdapter is null.");
    }
}
