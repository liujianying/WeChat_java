package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI.c;
import com.tencent.mm.protocal.c.tq;
import com.tencent.mm.ui.y;
import java.util.LinkedList;

class EmojiStoreV2RewardUI$b extends BaseAdapter {
    final /* synthetic */ EmojiStoreV2RewardUI iqC;
    LinkedList<tq> iqd;

    EmojiStoreV2RewardUI$b(EmojiStoreV2RewardUI emojiStoreV2RewardUI) {
        this.iqC = emojiStoreV2RewardUI;
    }

    public final int getCount() {
        return this.iqd == null ? 0 : this.iqd.size();
    }

    /* renamed from: oT */
    public final tq getItem(int i) {
        if (i < 0 || i > getCount() || this.iqd == null) {
            return null;
        }
        return (tq) this.iqd.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = y.gq(this.iqC.mController.tml).inflate(R.i.emoji_store_v2_reward_item, null);
            cVar = new c(this.iqC, view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        tq oT = getItem(i);
        if (oT != null) {
            cVar.iqH.setVisibility(0);
            cVar.iqH.setText(oT.rxn + oT.jTh);
        } else {
            cVar.iqH.setVisibility(8);
        }
        return view;
    }
}
