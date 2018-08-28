package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(f fVar) {
        super(fVar);
    }

    public final synchronized void notifyDataSetChanged() {
        List<EmojiGroupInfo> cnt = i.aEA().igy.cnt();
        boolean aFS = a.aFS();
        this.mItemList = new ArrayList();
        x.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (EmojiGroupInfo cnc : cnt) {
            ts cnc2 = cnc.cnc();
            f fVar = new f(cnc2);
            if (a.d(cnc2) && aFS) {
                this.iev.put(cnc2.rem, new ao(cnc2.rem));
            }
            fVar.setStatus(9);
            this.mItemList.add(fVar);
        }
    }

    public final void clear() {
        super.clear();
    }

    public final void aDF() {
    }
}
