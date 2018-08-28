package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;

class EmojiStoreV2TabView$1 implements OnClickListener {
    final /* synthetic */ EmojiStoreV2TabView irR;

    EmojiStoreV2TabView$1(EmojiStoreV2TabView emojiStoreV2TabView) {
        this.irR = emojiStoreV2TabView;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (EmojiStoreV2TabView.a(this.irR) != null) {
            EmojiStoreV2TabView.a(this.irR).oV(intValue);
        }
    }
}
