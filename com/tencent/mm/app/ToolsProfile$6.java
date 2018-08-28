package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.app.ToolsProfile.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

class ToolsProfile$6 implements ActivityLifecycleCallbacks {
    final /* synthetic */ ToolsProfile bzj;
    private int bzk = 0;
    private Set<Activity> bzl = new HashSet();

    ToolsProfile$6(ToolsProfile toolsProfile) {
        this.bzj = toolsProfile;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.bzk++;
        this.bzl.add(activity);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.bzk--;
        x.d("MicroMsg.ToolsProfile", "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[]{Integer.valueOf(this.bzk)});
        if (this.bzk == 0) {
            a.vf();
            x.i("MicroMsg.ToolsProfile", "onActivityDestroyed, xwebCanReboot = %b", new Object[]{Boolean.valueOf(WebView.getCanReboot())});
            if (WebView.getCanReboot()) {
                Process.killProcess(Process.myPid());
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        this.bzl.remove(activity);
        a.vg();
    }

    public final void onActivityResumed(Activity activity) {
        if (!this.bzl.contains(activity)) {
            a.access$100();
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
