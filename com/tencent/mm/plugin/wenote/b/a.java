package com.tencent.mm.plugin.wenote.b;

import com.tencent.mm.model.c.c;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public static boolean caO() {
        int i;
        String str = (String) c.Jx().fJ("100352").ckq().get("Close");
        if (bi.oW(str)) {
            i = 0;
        } else {
            i = bi.getInt(str, 0);
        }
        return i == 0;
    }
}
