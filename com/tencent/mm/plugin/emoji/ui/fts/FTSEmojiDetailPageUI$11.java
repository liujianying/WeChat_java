package com.tencent.mm.plugin.emoji.ui.fts;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class FTSEmojiDetailPageUI$11 implements c {
    final /* synthetic */ FTSEmojiDetailPageUI ioG;
    final /* synthetic */ List ioK;
    final /* synthetic */ List ioL;

    FTSEmojiDetailPageUI$11(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, List list, List list2) {
        this.ioG = fTSEmojiDetailPageUI;
        this.ioK = list;
        this.ioL = list2;
    }

    public final void a(l lVar) {
        lVar.setHeaderTitle((CharSequence) "");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioK.size()) {
                lVar.e(((Integer) this.ioK.get(i2)).intValue(), (CharSequence) this.ioL.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
