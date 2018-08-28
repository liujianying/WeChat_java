package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.g.a.at;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;

class b$6 extends c<at> {
    final /* synthetic */ b ifh;

    b$6(b bVar) {
        this.ifh = bVar;
        this.sFo = at.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        at atVar = (at) bVar;
        int i = atVar.bIi.type;
        EmojiInfo emojiInfo;
        if (i == 0) {
            emojiInfo = atVar.bIi.bIk;
            if (emojiInfo != null && emojiInfo.cnv()) {
                atVar.bIj.bGZ = e.aDM().b(emojiInfo);
                if (!atVar.bIj.bGZ) {
                    h.mEJ.a(252, 8, 1, false);
                }
            }
        } else if (i == 1) {
            String str = atVar.bIi.bIl;
            if (!bi.oW(str)) {
                emojiInfo = i.aEA().igx.Zz(str);
                if (emojiInfo != null && emojiInfo.cnv()) {
                    atVar.bIj.bGZ = e.aDM().b(emojiInfo);
                    if (!atVar.bIj.bGZ) {
                        h.mEJ.a(252, 9, 1, false);
                    }
                }
            }
        }
        return false;
    }
}
