package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ai;

public final class a {
    public static long a(ai aiVar, int i, long j) {
        if (aiVar == null) {
            return 0;
        }
        if (j == 0) {
            j = bi.VF();
        }
        switch (i) {
            case 2:
                return a(aiVar, j) | 4611686018427387904L;
            case 3:
                return a(aiVar, j) & -4611686018427387905L;
            case 4:
                return a(aiVar, j) & 4611686018427387904L;
            case 5:
                return a(aiVar, j) | 1152921504606846976L;
            case 6:
                return a(aiVar, j) & -1152921504606846977L;
            case 7:
                return a(aiVar, j) & 1152921504606846976L;
            default:
                return a(aiVar, j);
        }
    }

    public static long a(ai aiVar, long j) {
        return (aiVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }
}
