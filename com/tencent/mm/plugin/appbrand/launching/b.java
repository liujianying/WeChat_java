package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public final class b {
    public static void c(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        String str = appBrandInitConfig.appId;
        int i = appBrandInitConfig.fig;
        appBrandInitConfig.fqy = com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b.anT();
        appBrandInitConfig.aea();
        boolean ar = e.abg().ar(appBrandInitConfig.username, appBrandInitConfig.fig);
        if (e.abh().aq(appBrandInitConfig.username, appBrandInitConfig.fig)) {
            appBrandStatObject.gqK = 1;
        } else if (ar) {
            appBrandStatObject.gqK = 2;
        } else {
            appBrandStatObject.gqK = 3;
        }
    }
}
