package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic.ICallBack;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p implements ICallBack {
    private static long ese = 0;
    private static int esf = 0;
    private final String TAG = "IPxxCallback";

    public final String getUplodLogExtrasInfo() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Device:").append(d.qVI).append(" ").append(d.qVJ).append("\n");
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public final void setNewDnsDebugHostInfo(String str, int i) {
        MMLogic.setNewDnsDebugHost(str, String.valueOf(i));
    }

    public final String getCrashFilePath(int i) {
        String str = e.duP + "crash_" + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis() - (((long) i) * 86400000))) + ".txt";
        return com.tencent.mm.a.e.cn(str) ? str : null;
    }

    public final void recoverLinkAddrs() {
        MMLogic.recoverLinkAddrs();
    }

    public final void uploadLogResponse(long j, long j2) {
        int i = 100;
        int i2 = 0;
        x.i("IPxxCallback", "ipxx progress totalSize:%d uploadSize:%d lastPercent:%d ", new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(esf)});
        long VE = bi.VE();
        if (VE - 1 >= ese) {
            ese = VE;
            if (j2 >= 0 && j > 0 && j2 < j) {
                i2 = (int) ((100 * j2) / j);
            }
            if (i2 <= 100) {
                i = i2;
            }
            if (esf > i) {
                i = esf;
            }
            esf = i;
            iK(i);
        }
    }

    public final void uploadLogFail() {
        esf = 0;
        iK(-1);
    }

    public final void uploadLogSuccess() {
        esf = 0;
        iK(100);
    }

    private static void iK(int i) {
        try {
            t UZ = aa.UZ();
            if (UZ.ess != null) {
                try {
                    UZ.ess.es(i);
                } catch (Throwable e) {
                    x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bi.i(e)});
                }
            }
        } catch (Throwable e2) {
            x.e("IPxxCallback", "exception:%s", new Object[]{bi.i(e2)});
        }
    }
}
