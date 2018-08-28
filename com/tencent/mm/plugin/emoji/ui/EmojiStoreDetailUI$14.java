package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n.d;

class EmojiStoreDetailUI$14 implements d {
    final /* synthetic */ EmojiStoreDetailUI inz;

    EmojiStoreDetailUI$14(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1000:
                k.a(this.inz.mController.tml, EmojiStoreDetailUI.b(this.inz).rwQ + this.inz.getString(R.l.emoji_store_source), EmojiStoreDetailUI.b(this.inz).rwR, EmojiStoreDetailUI.b(this.inz).jPG, EmojiStoreDetailUI.b(this.inz).rxj, EmojiLogic.zu(EmojiStoreDetailUI.a(this.inz)), 4);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.a(this.inz), ""});
                return;
            case 1001:
                k.cZ(this.inz.mController.tml);
                this.inz.mController.tml.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
                h.mEJ.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.a(this.inz), ""});
                return;
            default:
                return;
        }
    }
}
