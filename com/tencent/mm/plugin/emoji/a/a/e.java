package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.protocal.c.ts;

public final class e {
    public static boolean a(ts tsVar) {
        if (tsVar == null) {
            return false;
        }
        return cs(tsVar.rwV, 1);
    }

    public static boolean b(ts tsVar) {
        if (!(tsVar == null ? false : cs(tsVar.rwU, 4))) {
            if (!(tsVar == null ? false : cs(tsVar.rwU, 8))) {
                return false;
            }
        }
        return true;
    }

    public static boolean oK(int i) {
        return cs(i, 4) || cs(i, 8);
    }

    public static boolean cs(int i, int i2) {
        return (i & i2) == i2;
    }
}
