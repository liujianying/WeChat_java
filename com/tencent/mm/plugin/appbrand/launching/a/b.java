package com.tencent.mm.plugin.appbrand.launching.a;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.protocal.c.chh;
import com.tencent.mm.protocal.c.chx;

public final class b {
    public static chx b(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer == null || 2 != appBrandLaunchReferrer.fqE) {
            return null;
        }
        chx chx = new chx();
        chx.rbW = appBrandLaunchReferrer.appId;
        chx.jPK = appBrandLaunchReferrer.url;
        return chx;
    }

    public static chh c(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer == null || 1 != appBrandLaunchReferrer.fqE) {
            return null;
        }
        chh chh = new chh();
        chh.rQV = appBrandLaunchReferrer.appId;
        chh.rQO = appBrandLaunchReferrer.bJt;
        chh.sBk = appBrandLaunchReferrer.fqH;
        return chh;
    }
}
