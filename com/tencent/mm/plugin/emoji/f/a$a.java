package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public class a$a implements a {
    public a$a() {
        a.access$002(0);
    }

    public final boolean vD() {
        if (a.bB() >= 100) {
            a.access$002(0);
            x.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
            com.tencent.mm.storage.emotion.a aVar = i.aEA().igy;
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
            emojiGroupInfo.field_productID = com.tencent.mm.plugin.emoji.h.a.aGv();
            emojiGroupInfo.field_packName = "emoji_custom_all";
            emojiGroupInfo.field_type = EmojiGroupInfo.TYPE_SYSTEM;
            emojiGroupInfo.field_sort = 1;
            emojiGroupInfo.field_idx = 0;
            emojiGroupInfo.field_packType = 4;
            emojiGroupInfo.field_packFlag = 1;
            emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
            aVar.c(emojiGroupInfo);
            i.aEC().g(com.tencent.mm.plugin.emoji.h.a.aGv(), 7, a.bB(), "");
            a.aEI();
            return false;
        }
        i.aEC().g(com.tencent.mm.plugin.emoji.h.a.aGv(), 6, a.bB(), "");
        a.access$002(a.bB() + 2);
        return true;
    }
}
