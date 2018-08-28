package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.rtmp.TXLiveConstants;

class EmojiStoreV2SingleProductUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$9(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (EmojiStoreV2SingleProductUI.f(this.irx) == null || EmojiStoreV2SingleProductUI.f(this.irx).getVisibility() != 0) {
            this.irx.finish();
        } else {
            EmojiStoreV2SingleProductUI.f(this.irx).setVisibility(8);
            this.irx.showOptionMenu(TXLiveConstants.PUSH_EVT_CONNECT_SUCC, EmojiStoreV2SingleProductUI.g(this.irx));
            this.irx.setMMTitle(R.l.emoji_store_product_title);
        }
        return false;
    }
}
