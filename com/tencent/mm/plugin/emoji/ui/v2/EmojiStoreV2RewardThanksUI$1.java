package com.tencent.mm.plugin.emoji.ui.v2;

import android.os.Message;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class EmojiStoreV2RewardThanksUI$1 extends ag {
    final /* synthetic */ EmojiStoreV2RewardThanksUI iql;

    EmojiStoreV2RewardThanksUI$1(EmojiStoreV2RewardThanksUI emojiStoreV2RewardThanksUI) {
        this.iql = emojiStoreV2RewardThanksUI;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1001:
                String str = (String) message.obj;
                if (bi.oW(str) || !e.cn(str)) {
                    x.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                    return;
                }
                EmojiStoreV2RewardThanksUI.a(this.iql).setImageFilePath(str);
                EmojiStoreV2RewardThanksUI.a(this.iql).setScaleType(ScaleType.FIT_XY);
                if (EmojiStoreV2RewardThanksUI.b(this.iql) != null && EmojiStoreV2RewardThanksUI.b(this.iql).isRunning()) {
                    EmojiStoreV2RewardThanksUI.b(this.iql).stop();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
