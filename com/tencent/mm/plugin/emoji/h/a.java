package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    public static boolean aFS() {
        return i.aEA().igy.cne();
    }

    public static boolean d(ts tsVar) {
        return tsVar == null ? false : zT(tsVar.rem);
    }

    public static boolean b(EmojiGroupInfo emojiGroupInfo) {
        return emojiGroupInfo == null ? false : zT(emojiGroupInfo.field_productID);
    }

    public static boolean zT(String str) {
        return str == null ? false : str.equals(aGv());
    }

    public static final String aGv() {
        return EmojiGroupInfo.tcy;
    }
}
