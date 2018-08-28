package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;
import junit.framework.Assert;

public final class ae implements d {
    public final void a(Context context, String str, String str2, String str3, int i, String str4) {
        if (!bi.oW(str3)) {
            if (bi.oW(str3) || bi.oW(str2)) {
                x.e("MicroMsg.WeAppLauncher", "targetAppId %s referrerAppId %s, Null Or Nil");
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1055;
            appBrandStatObject.bGG = p.encode(bi.oV(str)) + ":" + str2;
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.appId = str2;
            appBrandLaunchReferrer.fqE = 2;
            appBrandLaunchReferrer.url = str;
            AppBrandLaunchProxyUI.a(context, null, str3, str4, i, -1, appBrandStatObject, appBrandLaunchReferrer, null);
            Assert.assertTrue(true);
        }
    }

    public final void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject) {
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i, i2, appBrandStatObject, null, null);
    }

    public final void a(Context context, String str, String str2, int i, int i2, String str3, AppBrandStatObject appBrandStatObject, String str4) {
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        switch (appBrandStatObject.scene) {
            case 1020:
            case 1035:
            case 1043:
                appBrandLaunchReferrer.fqE = 5;
                break;
            case 1036:
            case 1069:
                appBrandLaunchReferrer.fqE = 4;
                break;
            case 1055:
                appBrandLaunchReferrer.fqE = 2;
                break;
        }
        appBrandLaunchReferrer.appId = str4;
        AppBrandLaunchProxyUI.a(context, str, str2, str3, i, i2, appBrandStatObject, appBrandLaunchReferrer, null);
    }

    public final void a(Context context, String str, String str2, boolean z, a aVar) {
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1036;
        appBrandStatObject.bGG = bi.oV(aVar.appId) + ":" + bi.oV(p.encode(aVar.url));
        appBrandStatObject.cbB = z ? 2 : 1;
        if (z) {
            str2 = str;
        }
        appBrandStatObject.cbC = str2;
        LaunchParamsOptional launchParamsOptional = null;
        if (!bi.oW(aVar.dyY)) {
            launchParamsOptional = new LaunchParamsOptional();
            launchParamsOptional.dFy = str;
            launchParamsOptional.dzR = aVar.dyY;
        }
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.fqE = 4;
        appBrandLaunchReferrer.appId = aVar.appId;
        AppBrandLaunchProxyUI.a(context, aVar.dyS, aVar.dyT, aVar.dyR, aVar.dyZ, aVar.dza, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
    }
}
