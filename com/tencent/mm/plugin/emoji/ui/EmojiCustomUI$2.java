package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;

class EmojiCustomUI$2 implements a {
    final /* synthetic */ String fRy;
    final /* synthetic */ EmojiCustomUI ilG;
    final /* synthetic */ int ilH;

    EmojiCustomUI$2(EmojiCustomUI emojiCustomUI, int i, String str) {
        this.ilG = emojiCustomUI;
        this.ilH = i;
        this.fRy = str;
    }

    public final void a(b bVar) {
        if (EmojiCustomUI.i(this.ilG) == null) {
            if (this.ilH == 0) {
                EmojiCustomUI.a(this.ilG, i.aEA().igx.c(this.fRy, "", EmojiGroupInfo.tcB, EmojiInfo.tcI, bVar.uCN, ""));
            } else {
                EmojiCustomUI.a(this.ilG, i.aEA().igx.c(this.fRy, "", EmojiGroupInfo.tcB, EmojiInfo.tcJ, bVar.uCN, ""));
            }
        }
        i.aEw().a(this.ilG.mController.tml, EmojiCustomUI.i(this.ilG), 1, q.GF());
        if (EmojiCustomUI.e(this.ilG) != null) {
            EmojiCustomUI.e(this.ilG).aFM();
            EmojiCustomUI.e(this.ilG).notifyDataSetChanged();
        }
    }

    public final void aFC() {
        h.a(this.ilG.mController.tml, this.ilG.mController.tml.getString(R.l.emoji_custom_gif_max_size_limit), "", this.ilG.mController.tml.getString(R.l.i_know_it), false, null);
    }
}
