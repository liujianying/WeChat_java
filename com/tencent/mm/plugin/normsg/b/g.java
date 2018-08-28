package com.tencent.mm.plugin.normsg.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.List;

public final class g {
    public static boolean lHd;

    static {
        lHd = false;
        long nanoTime = System.nanoTime();
        try {
            lHd = false;
            if (VERSION.SDK_INT < 21) {
                lHd = false;
            } else {
                Field declaredField = RecentTaskInfo.class.getDeclaredField("instanceId");
                declaredField.setAccessible(true);
                List recentTasks = ((ActivityManager) ad.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
                if (recentTasks == null || recentTasks.size() == 0) {
                    lHd = false;
                } else if (declaredField.getInt((RecentTaskInfo) recentTasks.get(0)) > 0) {
                    lHd = true;
                }
            }
            x.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[]{Boolean.valueOf(lHd), Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (Throwable th) {
            x.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[]{Boolean.valueOf(lHd), Long.valueOf(System.nanoTime() - nanoTime)});
        }
    }
}
