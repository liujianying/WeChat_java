package com.tencent.mm.plugin.appbrand.task;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e$i;
import java.util.List;

final class b extends f {
    b() {
        super(AppBrandInToolsUI.class, null);
    }

    final void amU() {
        ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Intent intent;
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if ((ad.getPackageName() + ":tools").equals(runningAppProcessInfo.processName)) {
                        if (runningAppProcessInfo.importance == 100) {
                            return;
                        }
                        intent = new Intent();
                        intent.setComponent(new ComponentName(e$i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                        ad.getContext().sendBroadcast(intent);
                    }
                }
                intent = new Intent();
                intent.setComponent(new ComponentName(e$i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                ad.getContext().sendBroadcast(intent);
            }
        }
    }
}
