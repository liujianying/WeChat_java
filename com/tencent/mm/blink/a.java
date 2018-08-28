package com.tencent.mm.blink;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {
    public static final int[] cVN = new int[]{0, 1, 2};
    public static final int[] cVO = new int[]{3, 13, 23};
    public static final int[] cVP = new int[]{4, 14, 24};
    public static final int[] cVQ = new int[]{5, 15, 25};
    public static final int[] cVR = new int[]{6, 16, 26};
    public static final int[] cVS = new int[]{7, 17, 27};
    public static final int[] cVT = new int[]{8, 18, 28};
    public static final int[] cVU = new int[]{9, 19, 29};
    public static final int[] cVV = new int[]{63, 69, 75};
    public static final int[] cVW = new int[]{64, 70, 76};
    public static final int[] cVX = new int[]{65, 71, 77};
    public static final int[] cVY = new int[]{66, 72, 78};
    private static final ArrayList<long[]> cVZ = new ArrayList();
    private static long cWa = 0;
    private static boolean cWb = false;
    private static long cWc = 0;
    private static long cWd = 0;
    private static byte cWe = (byte) 0;

    public static void aB(long j) {
        j.aB(j);
    }

    public static void i(String str, long j) {
        j.i(str, j);
    }

    public static void ey(String str) {
        j.ey(str);
    }

    public static void i(long j, long j2) {
        cVZ.add(new long[]{709, j, j2});
    }

    public static void j(long j, long j2) {
        cVZ.add(new long[]{783, j, j2});
    }

    public static void xc() {
        cWa = System.currentTimeMillis();
    }

    public static void xd() {
        if (fl(1024)) {
            j(1, System.currentTimeMillis() - cWa);
            j(2, 1);
        }
    }

    public static void cR(String str) {
        if (fl(512) && ad.chW().equals(str)) {
            cWb = true;
            x.i("MicroMsg.BlinkStartup", "report this time");
        }
    }

    public static void vh() {
        fl(512);
    }

    public static void aC(long j) {
        if (System.currentTimeMillis() - j > 200) {
            fl(512);
            cWb = false;
        }
    }

    public static void xe() {
        fl(512);
        cWb = false;
    }

    public static void aD(long j) {
        cWc = j;
        cWd = j;
    }

    private static void a(int[] iArr, long j) {
        x.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        i((long) iArr[0], j);
        if (com.tencent.mm.f.a.lY) {
            i((long) iArr[1], j);
        } else {
            i((long) iArr[2], j);
        }
    }

    public static boolean xf() {
        if (cWb) {
            return fl(256);
        }
        return false;
    }

    private static boolean fl(int i) {
        if ((cWe & i) != 0) {
            return false;
        }
        cWe = (byte) (cWe | i);
        x.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", Integer.valueOf(i));
        return true;
    }

    private static void aE(long j) {
        if (j > 10000) {
            xe();
        }
    }

    public static void fm(int i) {
        if (cWd == 0) {
            x.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - cWd;
        switch (i) {
            case 1:
                if (fl(1)) {
                    a(cVO, currentTimeMillis);
                    cWd = System.currentTimeMillis();
                    return;
                }
                return;
            case 2:
                if (fl(2)) {
                    a(cVP, currentTimeMillis);
                    cWd = System.currentTimeMillis();
                    return;
                }
                return;
            case 3:
                if (fl(4)) {
                    a(cVQ, currentTimeMillis);
                    cWd = System.currentTimeMillis();
                    return;
                }
                return;
            case 4:
                if (fl(8)) {
                    a(cVR, currentTimeMillis);
                    cWd = System.currentTimeMillis();
                    return;
                }
                return;
            case 5:
                if (fl(16)) {
                    aE(currentTimeMillis);
                    a(cVS, currentTimeMillis);
                    cWd = System.currentTimeMillis();
                    return;
                }
                return;
            case 6:
                if (fl(32)) {
                    aE(currentTimeMillis);
                    a(cVT, currentTimeMillis);
                    cWd = System.currentTimeMillis();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void xg() {
        long currentTimeMillis = System.currentTimeMillis() - cWc;
        a(cVU, currentTimeMillis);
        if (currentTimeMillis <= 3000) {
            a(cVV, 1);
        } else if (currentTimeMillis > 3000 && currentTimeMillis <= 6000) {
            a(cVW, 1);
        } else if (currentTimeMillis <= 6000 || currentTimeMillis > 10000) {
            a(cVY, 1);
        } else {
            a(cVX, 1);
        }
        a(cVN, 1);
    }

    public static ArrayList<long[]> xh() {
        return cVZ;
    }
}
