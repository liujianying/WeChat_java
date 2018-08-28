package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;

class e$1 implements Runnable {
    final /* synthetic */ e ift;

    e$1(e eVar) {
        this.ift = eVar;
    }

    public final void run() {
        ArrayList cnN = i.aEA().igx.cnN();
        if (cnN != null && cnN.size() > 0) {
            Iterator it = cnN.iterator();
            while (it.hasNext()) {
                EmojiInfo emojiInfo = (EmojiInfo) it.next();
                if (e.a(this.ift)) {
                    this.ift.c(emojiInfo, false);
                }
            }
        }
        if (e.a(this.ift)) {
            au.HU();
            c.DT().a(a.sPd, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
