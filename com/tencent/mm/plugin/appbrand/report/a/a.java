package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class a {
    public static String d(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer == null) {
            return null;
        }
        String str = "";
        if (1 == appBrandLaunchReferrer.fqE || 3 == appBrandLaunchReferrer.fqE) {
            return appBrandLaunchReferrer.appId;
        }
        if (2 == appBrandLaunchReferrer.fqE) {
            return appBrandLaunchReferrer.url;
        }
        return str;
    }
}
