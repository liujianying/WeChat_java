package com.tencent.mm.booter;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    public static boolean xG() {
        try {
            au.HU();
            ai.d((Long) c.DT().get(66817, null));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e, "", new Object[0]);
        }
        if (ai.bG(0) * 1000 > 1800000) {
            return true;
        }
        return false;
    }
}
