package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.c;

public final class k {
    public static boolean abE() {
        if (!g.Eg().Dx()) {
            return false;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100310");
        return fJ.isValid() && bi.getInt((String) fJ.ckq().get("shouldUsePatch"), 0) == 1;
    }

    public static boolean abF() {
        if (!g.Eg().Dx()) {
            return false;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100342");
        return fJ.isValid() && bi.getInt((String) fJ.ckq().get("shouldUsePatch"), 0) == 1;
    }

    public static boolean abG() {
        if (!g.Eg().Dx()) {
            return false;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100320");
        return fJ.isValid() && bi.getInt((String) fJ.ckq().get("isOpenModule"), 0) > 0;
    }

    public static boolean abH() {
        if (!g.Eg().Dx()) {
            return false;
        }
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100399");
        return fJ.isValid() && bi.getInt((String) fJ.ckq().get("isUseNewPackageLogic"), 0) > 0;
    }
}
