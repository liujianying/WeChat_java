package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends BroadcastReceiver {
    final /* synthetic */ e fjE;

    e$1(e eVar) {
        this.fjE = eVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            c.Em().H(new Runnable() {
                public final void run() {
                    e eVar = e$1.this.fjE;
                    Activity activity = (Activity) eVar.fjz.get();
                    if (activity != null) {
                        PackageManager packageManager = activity.getPackageManager();
                        ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                        RunningTaskInfo am = bi.am(activity, activity.getTaskId());
                        if (am != null) {
                            try {
                                ComponentName componentName = am.topActivity;
                                if (componentName != null && activityManager != null && packageManager != null) {
                                    ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                                    if (activityInfo != null) {
                                        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                            if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 150) && ((componentName.equals(runningAppProcessInfo.importanceReasonComponent) || runningAppProcessInfo.importanceReasonCode == 0) && runningAppProcessInfo.processName.equals(activityInfo.processName))) {
                                                eVar.acA();
                                                return;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = " + e);
                            }
                        }
                    }
                }
            });
        }
    }
}
