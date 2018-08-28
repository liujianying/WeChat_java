package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.storage.c;

public final class a {
    public static boolean amT() {
        boolean z;
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100159");
        if (fJ.isValid() && "1".equals(fJ.ckq().get("isCloseWeappSearch"))) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return true;
    }
}
