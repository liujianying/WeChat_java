package com.tencent.mm.plugin.emoji.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.ui.EmojiSortUI.3;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

class EmojiSortUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiSortUI imq;

    EmojiSortUI$2(EmojiSortUI emojiSortUI) {
        this.imq = emojiSortUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (ao.isConnected(ad.getContext())) {
            EmojiSortUI emojiSortUI = this.imq;
            emojiSortUI.getString(R.l.app_tip);
            emojiSortUI.eEX = h.a(emojiSortUI, emojiSortUI.getString(R.l.app_waiting), true, new 3(emojiSortUI));
            List arrayList = new ArrayList();
            if (!(EmojiSortUI.b(this.imq) == null || EmojiSortUI.b(this.imq).idD == null)) {
                for (EmojiGroupInfo emojiGroupInfo : EmojiSortUI.b(this.imq).idD) {
                    arrayList.add(emojiGroupInfo.field_productID);
                }
            }
            EmojiSortUI.a(this.imq, new s(arrayList, 2));
            au.DF().a(EmojiSortUI.c(this.imq), 0);
        } else {
            EmojiSortUI.a(this.imq);
        }
        return true;
    }
}
