package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2RewardUI$1 extends ag {
    final /* synthetic */ EmojiStoreV2RewardUI iqC;

    EmojiStoreV2RewardUI$1(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.iqC = emojiStoreV2RewardUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                if (bi.oW(str) || !e.cn(str)) {
                    x.i("MicroMsg.emoji.EmojiStoreV2RewardUI", "path is null or file no exists");
                    return;
                }
                EmojiStoreV2RewardUI.a(this.iqC).setImageFilePath(str);
                EmojiStoreV2RewardUI.a(this.iqC).setScaleType(ScaleType.FIT_XY);
                if (EmojiStoreV2RewardUI.b(this.iqC) != null && EmojiStoreV2RewardUI.b(this.iqC).isRunning()) {
                    EmojiStoreV2RewardUI.b(this.iqC).stop();
                    return;
                }
                return;
            case 1002:
                EmojiStoreV2RewardUI.c(this.iqC);
                return;
            default:
                return;
        }
    }
}
