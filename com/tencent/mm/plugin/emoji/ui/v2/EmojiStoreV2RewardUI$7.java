package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.sdk.platformtools.bi;

class EmojiStoreV2RewardUI$7 implements i {
    final /* synthetic */ String dat;
    final /* synthetic */ EmojiStoreV2RewardUI iqC;
    final /* synthetic */ String iqD;

    EmojiStoreV2RewardUI$7(EmojiStoreV2RewardUI emojiStoreV2RewardUI, String str, String str2) {
        this.iqC = emojiStoreV2RewardUI;
        this.iqD = str;
        this.dat = str2;
    }

    public final void a(String str, Bitmap bitmap, Object... objArr) {
        if (!bi.oW(str) && str.equalsIgnoreCase(this.iqD)) {
            Message message = new Message();
            message.what = 1001;
            message.obj = this.dat;
            EmojiStoreV2RewardUI.j(this.iqC).sendMessage(message);
        }
    }
}
