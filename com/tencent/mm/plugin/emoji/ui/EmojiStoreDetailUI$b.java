package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

class EmojiStoreDetailUI$b extends a {
    private ArrayList<EmojiInfo> inB;
    final /* synthetic */ EmojiStoreDetailUI inz;

    public EmojiStoreDetailUI$b(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
        super(emojiStoreDetailUI);
        this.inB = new ArrayList();
        this.inB = (ArrayList) i.aEA().igx.zk(com.tencent.mm.plugin.emoji.h.a.aGv());
    }

    public final int getCount() {
        return this.inB == null ? 0 : this.inB.size();
    }

    private EmojiInfo oO(int i) {
        return this.inB == null ? null : (EmojiInfo) this.inB.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        EmojiStoreDetailUI$c emojiStoreDetailUI$c;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(EmojiStoreDetailUI.p(this.inz)).inflate(R.i.emoji_store_detail_grid_item, null);
            emojiStoreDetailUI$c = new EmojiStoreDetailUI$c(this.inz, view);
            view.setTag(emojiStoreDetailUI$c);
        } else {
            emojiStoreDetailUI$c = (EmojiStoreDetailUI$c) view.getTag();
        }
        emojiStoreDetailUI$c.inC.setBackgroundResource(R.g.smiley_item_bg2);
        EmojiInfo oO = oO(i);
        o.Pj().a((bi.oW(oO.getContent()) ? oO.getName() : oO.getContent()).split("\\.")[0], emojiStoreDetailUI$c.inC, f.aDO());
        return view;
    }
}
