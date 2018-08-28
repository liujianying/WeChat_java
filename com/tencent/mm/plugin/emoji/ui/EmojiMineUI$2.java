package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EmojiMineUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EmojiMineUI imi;

    EmojiMineUI$2(EmojiMineUI emojiMineUI) {
        this.imi = emojiMineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ArrayList cnt = i.aEA().igy.cnt();
        List arrayList = new ArrayList();
        Iterator it = cnt.iterator();
        while (it.hasNext()) {
            EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
            if (emojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
                arrayList.add(emojiGroupInfo);
            }
        }
        if (arrayList.size() <= 1) {
            h.i(this.imi.mController.tml, R.l.emoji_cant_sort_tip, R.l.app_tip);
        } else if (ao.isConnected(ad.getContext())) {
            Intent intent = new Intent();
            intent.setClass(this.imi, EmojiSortUI.class);
            this.imi.startActivity(intent);
        } else {
            EmojiMineUI.a(this.imi);
        }
        return true;
    }
}
