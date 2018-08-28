package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.report.service.h;

class EmojiStoreDetailUI$17 implements OnClickListener {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$17(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.inz, EmojiStoreV2RewardUI.class);
        intent.putExtra("extra_id", EmojiStoreDetailUI.a(this.inz));
        intent.putExtra("extra_name", EmojiStoreDetailUI.b(this.inz).rwQ);
        if (!(EmojiStoreDetailUI.b(this.inz) == null || EmojiStoreDetailUI.b(this.inz).rxl == null)) {
            intent.putExtra("name", EmojiStoreDetailUI.b(this.inz).rxl.jPe);
        }
        intent.putExtra("scene", EmojiStoreDetailUI.c(this.inz));
        intent.putExtra("pageType", 1);
        intent.putExtra("searchID", EmojiStoreDetailUI.d(this.inz));
        this.inz.startActivity(intent);
        h.mEJ.h(12738, new Object[]{EmojiStoreDetailUI.a(this.inz), Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.c(this.inz)), Integer.valueOf(0)});
    }
}
