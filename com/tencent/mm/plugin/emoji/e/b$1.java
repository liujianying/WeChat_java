package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;

class b$1 extends c<sm> {
    final /* synthetic */ b ifh;

    b$1(b bVar) {
        this.ifh = bVar;
        this.sFo = sm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bd bdVar = ((sm) bVar).cdp.bGS;
        EmojiInfo Zy = i.aEA().igx.Zy(bdVar.field_imgPath);
        if (Zy != null) {
            if (Zy.field_type == EmojiInfo.tcI) {
                Cursor cursor = null;
                if (EmojiInfo.Dr(Zy.field_catalog)) {
                    cursor = i.aEA().igx.Du(Zy.field_catalog);
                } else if (Zy.field_catalog == EmojiInfo.tcD && Zy.getContent().length() > 0 && EmojiInfo.Dr(bi.getInt(Zy.getContent(), 0))) {
                    cursor = i.aEA().igx.Du(bi.getInt(Zy.getContent(), 0));
                }
                if (cursor != null) {
                    int eF = bi.eF(cursor.getCount() - 1, 0);
                    Zy = new EmojiInfo();
                    cursor.moveToPosition(eF);
                    Zy.d(cursor);
                    cursor.close();
                }
                bdVar.eq(Zy.Xh());
                bdVar.eC(0);
                an YJ = an.YJ(bdVar.field_content);
                YJ.enG = false;
                bdVar.setStatus(1);
                bdVar.setContent(YJ.clN());
                au.HU();
                com.tencent.mm.model.c.FT().a(bdVar.field_msgId, bdVar);
            }
            i.aEw().a(bdVar.field_talker, Zy, bdVar);
        }
        return false;
    }
}
