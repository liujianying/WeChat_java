package com.tencent.mm.plugin.ext.b;

import com.tencent.mm.storage.bd;

public final class b {
    public static int P(bd bdVar) {
        if (bdVar.getType() == 34) {
            return 2;
        }
        if (bdVar.getType() != 1) {
            return 3;
        }
        return 1;
    }
}
