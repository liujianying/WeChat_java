package com.tencent.mm.sdk.platformtools;

import java.util.HashSet;
import java.util.Set;

public final class af {
    private static Set<String> sGD = new HashSet();

    public static boolean Wp(String str) {
        if (Wr(str)) {
            x.d("MicroMsg.MMEntryLock", "locked-" + str);
            return false;
        }
        x.d("MicroMsg.MMEntryLock", "lock-" + str);
        return sGD.add(str);
    }

    public static void Wq(String str) {
        sGD.remove(str);
        x.d("MicroMsg.MMEntryLock", "unlock-" + str);
    }

    public static boolean Wr(String str) {
        return sGD.contains(str);
    }
}
