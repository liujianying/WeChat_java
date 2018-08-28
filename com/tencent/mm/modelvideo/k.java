package com.tencent.mm.modelvideo;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class k {
    public static final String SU() {
        return g.Ei().dqp + "draft/";
    }

    public static final String nB(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return SU() + str;
    }

    public static final String nC(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return SU() + str + ".thumb";
    }
}
