package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ToolsProfile$a {
    private static final AtomicInteger bzm = new AtomicInteger(0);

    public static boolean isLocked() {
        if (bzm.get() <= 0) {
            Object obj;
            ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
            if (activityManager != null) {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (((h) g.Ef().DM()).dox.equals(runningAppProcessInfo.processName)) {
                            obj = (runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE || runningAppProcessInfo.importanceReasonCode == 1 || runningAppProcessInfo.importanceReasonCode == 2) ? 1 : null;
                            if (obj != null) {
                                obj = 1;
                                if (obj == null) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    static void vf() {
        x.i("MicroMsg.ToolsProcessLocker", "clearLock, beforeReset %d", new Object[]{Integer.valueOf(bzm.getAndSet(0))});
    }
}
