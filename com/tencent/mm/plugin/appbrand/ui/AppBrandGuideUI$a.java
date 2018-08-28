package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class AppBrandGuideUI$a implements ActivityLifecycleCallbacks, f {
    public boolean guw = false;
    public String gux;

    public static Application ano() {
        return (Application) ad.getContext().getApplicationContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity instanceof AppBrandGuideUI) {
            this.guw = false;
        }
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
            this.guw = false;
        }
        if (g.Eg().Dx() && this.guw) {
            RunningTaskInfo am = bi.am(activity, activity.getTaskId());
            boolean z = (am == null || am.baseActivity == null) ? false : am.baseActivity.getClassName().endsWith(".LauncherUI") || !am.baseActivity.getClassName().contains(".AppBrandUI");
            if (z) {
                this.guw = false;
                activity.startActivity(new Intent(activity, AppBrandGuideUI.class));
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void an(String str, int i) {
        this.guw = false;
    }
}
