package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.launching.b;
import com.tencent.mm.plugin.appbrand.launching.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class k {
    static String uq(String str) {
        if (bi.oW(str)) {
            return "";
        }
        ComponentName componentName = new ComponentName(ad.getContext(), str);
        PackageManager packageManager = ad.getContext().getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (activityInfo == null) {
                return "";
            }
            return activityInfo.processName;
        } catch (NameNotFoundException e) {
            try {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, 128);
                if (serviceInfo == null) {
                    return "";
                }
                return serviceInfo.processName;
            } catch (NameNotFoundException e2) {
                return "";
            }
        }
    }

    static void a(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        x.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[]{appBrandInitConfig});
        b.c(appBrandInitConfig, appBrandStatObject);
        appBrandInitConfig.startTime = bi.VF();
        int b = e.b(context, appBrandInitConfig, appBrandStatObject);
        if (context instanceof Activity) {
            f.a((Activity) context, appBrandStatObject);
        }
        x.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[]{appBrandInitConfig});
        if (b == 1) {
            new d(appBrandInitConfig, appBrandStatObject).akB();
        }
        com.tencent.mm.plugin.appbrand.config.f aee = com.tencent.mm.plugin.appbrand.config.f.aee();
        String str = appBrandInitConfig.username;
        if (appBrandInitConfig != null && !bi.oW(appBrandInitConfig.appId)) {
            synchronized (aee.fqC) {
                aee.fqC.put(appBrandInitConfig.appId, appBrandInitConfig);
            }
            if (!bi.oW(str)) {
                synchronized (aee.fqD) {
                    aee.fqD.put(str, appBrandInitConfig.appId);
                }
            }
        }
    }
}
