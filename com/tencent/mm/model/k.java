package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    public static int GB() {
        if (g.Eg().Dx()) {
            int i;
            Cursor clJ = ((i) g.l(i.class)).FW().clJ();
            if (clJ == null || clJ.getCount() <= 0) {
                i = 0;
            } else {
                clJ.moveToFirst();
                i = clJ.getInt(0);
            }
            if (clJ == null) {
                return i;
            }
            clJ.close();
            return i;
        }
        x.w("MicroMsg.BottleConversationLogic", "get Bottle Total Conversation Unread, but has not set uin");
        return 0;
    }
}
