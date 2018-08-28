package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;
import java.util.Collection;

class EmojiStoreV2SingleProductUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiStoreV2SingleProductUI irx;

    EmojiStoreV2SingleProductUI$13(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        this.irx = emojiStoreV2SingleProductUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (EmojiStoreV2SingleProductUI.f(this.irx) != null) {
            EmojiStoreV2SingleProductUI.f(this.irx).setVisibility(0);
            Collection arrayList = new ArrayList();
            arrayList.add(EmojiStoreV2SingleProductUI.l(this.irx));
            EmojiStoreV2SingleProductUI.m(this.irx).a(arrayList, EmojiStoreV2SingleProductUI.n(this.irx));
            this.irx.setMMTitle(R.l.emoji_store_seach_by_tag);
            this.irx.showOptionMenu(1001, false);
            h.mEJ.k(12788, "1");
        }
        return false;
    }
}
