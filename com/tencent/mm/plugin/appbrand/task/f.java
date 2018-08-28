package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedHashMap;
import java.util.List;

class f {
    final String gtP;
    final Class gtQ;
    private final Class gtR;
    final LinkedHashMap<String, Integer> gtS = new LinkedHashMap();
    final LinkedHashMap<String, AppBrandRemoteTaskController> gtT = new LinkedHashMap();

    f(Class cls, Class cls2) {
        this.gtP = cls.getName();
        this.gtQ = cls;
        this.gtR = cls2;
    }

    final void Fo() {
        if (this.gtR != null) {
            Intent intent = new Intent();
            intent.setClass(ad.getContext(), this.gtR);
            ad.getContext().sendBroadcast(intent);
        }
    }

    void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        this.gtS.put(str, Integer.valueOf(i));
        this.gtT.put(str, appBrandRemoteTaskController);
    }

    void vu(String str) {
        this.gtS.remove(str);
        this.gtT.remove(str);
    }

    void amU() {
        if (this.gtS.isEmpty()) {
            ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
            PackageManager packageManager = ad.getContext().getPackageManager();
            if (activityManager != null && packageManager != null) {
                try {
                    String str = packageManager.getActivityInfo(new ComponentName(ad.getContext(), this.gtQ), 128).processName;
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.processName.equals(str)) {
                                Process.killProcess(runningAppProcessInfo.pid);
                                return;
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    final AppBrandRemoteTaskController vE(String str) {
        return (AppBrandRemoteTaskController) this.gtT.get(str);
    }
}
