package com.tencent.mm.plugin.normsg.b;

import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static boolean lGW;

    static {
        lGW = false;
        long nanoTime = System.nanoTime();
        try {
            lGW = b.bjB();
            x.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[]{Boolean.valueOf(lGW), Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (Throwable th) {
            x.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[]{Boolean.valueOf(lGW), Long.valueOf(System.nanoTime() - nanoTime)});
        }
    }
}
