package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static int onC = -1;
    private static int onD = -1;

    public static void xO(int i) {
        onC = i;
    }

    public static void bFd() {
        if (onC == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        h.mEJ.h(12925, new Object[]{Integer.valueOf(onC)});
    }

    public static void bFe() {
        if (onC == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        h.mEJ.h(12926, new Object[]{Integer.valueOf(onC)});
    }

    public static void c(int i, int i2, int i3, String str) {
        if (onC == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        h.mEJ.h(13413, new Object[]{Integer.valueOf(onC), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }

    public static void bFf() {
        onD = (int) (System.currentTimeMillis() / 1000);
    }

    public static void xP(int i) {
        if (onD == -1) {
            x.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            return;
        }
        h.mEJ.h(12927, new Object[]{Integer.valueOf(onD), Integer.valueOf(i)});
        onC = -1;
    }

    public static boolean bFg() {
        return onC >= 0;
    }

    public static void dK(int i, int i2) {
        x.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        h.mEJ.h(14381, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void dL(int i, int i2) {
        int i3;
        switch (i2) {
            case 4:
                i3 = 1;
                break;
            case 5:
                i3 = 3;
                break;
            case 9:
                i3 = 2;
                break;
            case 10:
                i3 = 4;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 0;
                    break;
                }
            case 1001:
                i3 = 5;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            x.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[]{Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1)});
            h.mEJ.a(672, (long) i3, 1, false);
        }
    }

    public static void xQ(int i) {
        x.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[]{Integer.valueOf(3), Integer.valueOf(i), bi.i(new Throwable())});
        Map hashMap = new HashMap();
        hashMap.put("sceneType", "3");
        hashMap.put("scene", String.valueOf(i));
        h.mEJ.c("Soter", "Fingerprint pay add authentication task failed: " + r0, hashMap);
    }
}
