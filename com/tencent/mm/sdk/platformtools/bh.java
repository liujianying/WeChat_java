package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;

public final class bh {
    private static long sJA;
    private static long sJB;
    private static final File sJC;
    private static final File sJD;
    private static long sJm;
    private static long sJn;
    private static long sJo;
    private static long sJp;
    private static long sJq;
    private static long sJr;
    private static long sJs;
    private static long sJt;
    private static long sJu;
    private static long sJv;
    private static long sJw;
    private static long sJx;
    private static long sJy;
    private static long sJz;

    static {
        File file = null;
        File file2 = new File("/proc/" + Process.myPid() + "/net/dev");
        if (!file2.isFile()) {
            file2 = null;
        }
        sJC = file2;
        file2 = new File("/proc/net/xt_qtaguid/stats");
        if (file2.isFile()) {
            file = file2;
        }
        sJD = file;
    }

    public static long ciN() {
        return sJw > 0 ? sJw : 0;
    }

    public static long ciO() {
        return sJx > 0 ? sJx : 0;
    }

    public static long ciP() {
        return sJu > 0 ? sJu : 0;
    }

    public static long ciQ() {
        return sJv > 0 ? sJv : 0;
    }

    public static long ciR() {
        return sJA > 0 ? sJA : 0;
    }

    public static long ciS() {
        return sJB > 0 ? sJB : 0;
    }

    public static long ciT() {
        return sJy > 0 ? sJy : 0;
    }

    public static long ciU() {
        return sJz > 0 ? sJz : 0;
    }

    public static void reset() {
        sJm = -1;
        sJn = -1;
        sJo = -1;
        sJp = -1;
        sJr = -1;
        sJq = -1;
        sJt = -1;
        sJs = -1;
        update();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void update() {
        /*
        r20 = 0;
        r18 = 0;
        r4 = 0;
        r16 = 0;
        r12 = 0;
        r10 = 0;
        r14 = 0;
        r8 = 0;
        r3 = 0;
        r2 = sJC;	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        if (r2 == 0) goto L_0x01cf;
    L_0x0015:
        r6 = new java.util.Scanner;	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r2 = sJC;	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r6.<init>(r2);	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r6.nextLine();	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r6.nextLine();	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r2 = r16;
    L_0x0024:
        r7 = r6.hasNext();	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        if (r7 == 0) goto L_0x00a0;
    L_0x002a:
        r7 = r6.nextLine();	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r16 = "[ :\t]+";
        r0 = r16;
        r16 = r7.split(r0);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r7 = 0;
        r7 = r16[r7];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r7 = r7.length();	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        if (r7 != 0) goto L_0x0089;
    L_0x0040:
        r7 = 1;
    L_0x0041:
        r17 = r7 + 0;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r22 = "lo";
        r0 = r17;
        r1 = r22;
        r17 = r0.equals(r1);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        if (r17 != 0) goto L_0x0024;
    L_0x0052:
        r17 = r7 + 0;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r22 = "rmnet";
        r0 = r17;
        r1 = r22;
        r17 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        if (r17 != 0) goto L_0x0074;
    L_0x0063:
        r17 = r7 + 0;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r22 = "ccmni";
        r0 = r17;
        r1 = r22;
        r17 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        if (r17 == 0) goto L_0x008b;
    L_0x0074:
        r17 = r7 + 9;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r22 = java.lang.Long.parseLong(r17);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r20 = r20 + r22;
        r7 = r7 + 1;
        r7 = r16[r7];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r16 = java.lang.Long.parseLong(r7);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r18 = r18 + r16;
        goto L_0x0024;
    L_0x0089:
        r7 = 0;
        goto L_0x0041;
    L_0x008b:
        r17 = r7 + 9;
        r17 = r16[r17];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r22 = java.lang.Long.parseLong(r17);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r4 = r4 + r22;
        r7 = r7 + 1;
        r7 = r16[r7];	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r16 = java.lang.Long.parseLong(r7);	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r2 = r2 + r16;
        goto L_0x0024;
    L_0x00a0:
        r6.close();	 Catch:{ Exception -> 0x0324, all -> 0x031f }
        r6 = 0;
        r16 = sJm;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x00cb;
    L_0x00ac:
        sJm = r20;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newMobileTx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17[r22] = r23;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.x.v(r7, r0, r1);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
    L_0x00cb:
        r16 = sJn;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x00f2;
    L_0x00d3:
        sJn = r18;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newMobileRx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r18);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17[r22] = r23;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.x.v(r7, r0, r1);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
    L_0x00f2:
        r16 = sJo;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x0119;
    L_0x00fa:
        sJo = r4;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newWifiTx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17[r22] = r23;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.x.v(r7, r0, r1);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
    L_0x0119:
        r16 = sJp;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x0140;
    L_0x0121:
        sJp = r2;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "fix loss newWifiRx %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17 = r0;
        r22 = 0;
        r23 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17[r22] = r23;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.x.v(r7, r0, r1);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
    L_0x0140:
        r16 = sJp;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = r2 - r16;
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x016b;
    L_0x014a:
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "minu %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17 = r0;
        r22 = 0;
        r24 = sJp;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r24 = r2 - r24;
        r23 = java.lang.Long.valueOf(r24);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17[r22] = r23;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.x.v(r7, r0, r1);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
    L_0x016b:
        r16 = sJo;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = r4 - r16;
        r22 = 0;
        r7 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1));
        if (r7 >= 0) goto L_0x0196;
    L_0x0175:
        r7 = "MicroMsg.SDK.TrafficStats";
        r16 = "minu %d";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17 = r0;
        r22 = 0;
        r24 = sJo;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r24 = r4 - r24;
        r23 = java.lang.Long.valueOf(r24);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r17[r22] = r23;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.x.v(r7, r0, r1);	 Catch:{ Exception -> 0x0327, all -> 0x031f }
    L_0x0196:
        r16 = sJm;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x0225;
    L_0x019c:
        r16 = sJm;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = r20 - r16;
    L_0x01a0:
        sJu = r16;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = sJn;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x0229;
    L_0x01a8:
        r16 = sJn;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = r18 - r16;
    L_0x01ac:
        sJv = r16;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = sJo;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x022c;
    L_0x01b4:
        r16 = sJo;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = r4 - r16;
    L_0x01b8:
        sJw = r16;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = sJp;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r7 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1));
        if (r7 < 0) goto L_0x022f;
    L_0x01c0:
        r16 = sJp;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r16 = r2 - r16;
    L_0x01c4:
        sJx = r16;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        sJm = r20;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        sJn = r18;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        sJo = r4;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        sJp = r2;	 Catch:{ Exception -> 0x0327, all -> 0x031f }
        r3 = r6;
    L_0x01cf:
        r2 = sJD;	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        if (r2 == 0) goto L_0x032d;
    L_0x01d3:
        r7 = android.os.Process.myUid();	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r6 = new java.util.Scanner;	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r2 = sJD;	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r6.<init>(r2);	 Catch:{ Exception -> 0x0304, all -> 0x0317 }
        r6.nextLine();	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r2 = r8;
        r4 = r14;
    L_0x01e3:
        r8 = r6.hasNext();	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        if (r8 == 0) goto L_0x023f;
    L_0x01e9:
        r8 = r6.nextLine();	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r9 = "[ :\\t]+";
        r8 = r8.split(r9);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r9 = 3;
        r9 = r8[r9];	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        if (r9 != r7) goto L_0x01e3;
    L_0x01fd:
        r9 = 1;
        r9 = r8[r9];	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r14 = 5;
        r14 = r8[r14];	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r14 = java.lang.Long.parseLong(r14);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r16 = 7;
        r8 = r8[r16];	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r16 = java.lang.Long.parseLong(r8);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = "rmnet";
        r8 = r9.startsWith(r8);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        if (r8 != 0) goto L_0x0221;
    L_0x0218:
        r8 = "ccmni";
        r8 = r9.startsWith(r8);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        if (r8 == 0) goto L_0x0232;
    L_0x0221:
        r10 = r10 + r14;
        r12 = r12 + r16;
        goto L_0x01e3;
    L_0x0225:
        r16 = r20;
        goto L_0x01a0;
    L_0x0229:
        r16 = r18;
        goto L_0x01ac;
    L_0x022c:
        r16 = r4;
        goto L_0x01b8;
    L_0x022f:
        r16 = r2;
        goto L_0x01c4;
    L_0x0232:
        r8 = "lo";
        r8 = r9.equals(r8);	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        if (r8 != 0) goto L_0x01e3;
    L_0x023b:
        r2 = r2 + r14;
        r4 = r4 + r16;
        goto L_0x01e3;
    L_0x023f:
        r8 = sJr;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x0249;
    L_0x0247:
        sJr = r10;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
    L_0x0249:
        r8 = sJq;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x0253;
    L_0x0251:
        sJq = r12;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
    L_0x0253:
        r8 = sJt;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x025d;
    L_0x025b:
        sJt = r2;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
    L_0x025d:
        r8 = sJs;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r14 = 0;
        r7 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r7 >= 0) goto L_0x0267;
    L_0x0265:
        sJs = r4;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
    L_0x0267:
        r8 = sJq;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x02fa;
    L_0x026d:
        r8 = sJq;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = r12 - r8;
    L_0x0271:
        sJy = r8;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = sJr;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x02fd;
    L_0x0279:
        r8 = sJr;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = r10 - r8;
    L_0x027d:
        sJz = r8;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = sJs;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r7 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0300;
    L_0x0285:
        r8 = sJs;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = r4 - r8;
    L_0x0289:
        sJA = r8;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = sJt;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r7 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r7 < 0) goto L_0x0302;
    L_0x0291:
        r8 = sJt;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        r8 = r2 - r8;
    L_0x0295:
        sJB = r8;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        sJq = r12;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        sJr = r10;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        sJs = r4;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
        sJt = r2;	 Catch:{ Exception -> 0x032a, all -> 0x031f }
    L_0x029f:
        if (r6 == 0) goto L_0x02a4;
    L_0x02a1:
        r6.close();
    L_0x02a4:
        r2 = "MicroMsg.SDK.TrafficStats";
        r3 = "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d, wxWifi rx/tx=%d/%d wxMobile rx/tx=%d/%d";
        r4 = 8;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = sJx;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = sJw;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = sJv;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 3;
        r6 = sJu;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 4;
        r6 = sJB;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 5;
        r6 = sJA;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 6;
        r6 = sJz;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 7;
        r6 = sJy;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        return;
    L_0x02fa:
        r8 = r12;
        goto L_0x0271;
    L_0x02fd:
        r8 = r10;
        goto L_0x027d;
    L_0x0300:
        r8 = r4;
        goto L_0x0289;
    L_0x0302:
        r8 = r2;
        goto L_0x0295;
    L_0x0304:
        r2 = move-exception;
    L_0x0305:
        r4 = "MicroMsg.SDK.TrafficStats";
        r5 = "Failed retrieving TrafficStats.";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0321 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r2, r5, r6);	 Catch:{ all -> 0x0321 }
        if (r3 == 0) goto L_0x02a4;
    L_0x0313:
        r3.close();
        goto L_0x02a4;
    L_0x0317:
        r2 = move-exception;
        r6 = r3;
    L_0x0319:
        if (r6 == 0) goto L_0x031e;
    L_0x031b:
        r6.close();
    L_0x031e:
        throw r2;
    L_0x031f:
        r2 = move-exception;
        goto L_0x0319;
    L_0x0321:
        r2 = move-exception;
        r6 = r3;
        goto L_0x0319;
    L_0x0324:
        r2 = move-exception;
        r3 = r6;
        goto L_0x0305;
    L_0x0327:
        r2 = move-exception;
        r3 = r6;
        goto L_0x0305;
    L_0x032a:
        r2 = move-exception;
        r3 = r6;
        goto L_0x0305;
    L_0x032d:
        r6 = r3;
        goto L_0x029f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.bh.update():void");
    }
}
