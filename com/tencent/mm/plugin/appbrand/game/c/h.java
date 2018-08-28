package com.tencent.mm.plugin.appbrand.game.c;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ad;

public final class h {
    public int fBZ = Integer.MAX_VALUE;

    public final int a(MemoryInfo memoryInfo) {
        if (this.fBZ == Integer.MAX_VALUE || memoryInfo == null) {
            return Integer.MAX_VALUE;
        }
        return b(memoryInfo) - this.fBZ;
    }

    public static int b(MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return 0;
        }
        return memoryInfo.getTotalPss() / 1024;
    }

    public static MemoryInfo agu() {
        MemoryInfo[] processMemoryInfo = ((ActivityManager) ad.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            return null;
        }
        return processMemoryInfo[0];
    }
}
