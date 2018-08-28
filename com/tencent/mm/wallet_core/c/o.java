package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    private static long hyD = 0;
    private static String pnl = "";
    private static String uXq = "";

    public static void setTimeStamp(String str) {
        pnl = str;
        hyD = System.currentTimeMillis() / 1000;
        uXq = bi.cjd().toString();
    }

    public static boolean cCZ() {
        long bG = bi.bG(hyD);
        x.d("MicroMsg.TimeStampHelper", "pass time " + bG);
        return bG > 300;
    }

    public static String cDa() {
        if (bi.oW(pnl) || b.chp()) {
            x.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[]{uXq, Boolean.valueOf(cCZ()), Long.valueOf(hyD)});
        }
        return pnl;
    }
}
