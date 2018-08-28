package com.tencent.mm.app.plugin;

import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    public static boolean vy() {
        if (!d.QS("translate")) {
            return false;
        }
        String value = g.AT().getValue("TranslateMsgOff");
        if (bi.oW(value)) {
            return true;
        }
        if (bi.WU(value) == 0) {
            return true;
        }
        return false;
    }

    public static boolean vz() {
        if (!d.QS("translate")) {
            return false;
        }
        String value = g.AT().getValue("ReTranslateSwitch");
        if (bi.oW(value)) {
            return true;
        }
        if (bi.WU(value) == 0) {
            return true;
        }
        return false;
    }
}
