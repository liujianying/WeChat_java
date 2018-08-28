package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static a dkX = null;

    public interface a {
        void a(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int[] iArr, int i9, int i10, int i11, int i12, int i13, long j2, int[] iArr2, int[] iArr3);

        void a(int i, long j, int i2, int i3, int i4);

        void a(int i, long j, int i2, long j2, long j3);

        void reportIDKey(boolean z, int i, int i2, boolean z2);
    }

    public static void a(a aVar) {
        int i;
        int i2 = (int) (aVar.dkw - aVar.dkg);
        int i3 = HardCoderJNI.hcEnable ? 1 : 0;
        int i4 = HardCoderJNI.isHCEnable() ? 1 : 0;
        int isRunning = HardCoderJNI.isRunning();
        int i5 = i2 - aVar.delay <= 0 ? 1 : 0;
        int i6 = aVar.scene;
        long j = aVar.dkf;
        int i7 = aVar.dkc;
        int i8 = aVar.dkd;
        int[] iArr = aVar.dkn;
        int i9 = (int) (aVar.dkh - aVar.startTime);
        int i10 = aVar.dkr;
        int i11 = 0;
        if (aVar.dkt != null) {
            i11 = (int) (0 + aVar.dkt.dlh);
        }
        if (aVar.dku != null) {
            i = (int) (((long) i11) + aVar.dku.dlh);
        } else {
            i = i11;
        }
        int i12 = HardCoderJNI.TICK_RATE;
        long j2 = aVar.dks;
        int[] iArr2 = aVar.dkl;
        int[] iArr3 = aVar.dkm;
        StringBuilder stringBuilder = new StringBuilder();
        if (iArr != null) {
            for (int i13 : iArr) {
                stringBuilder.append(i13 + "#");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (iArr2 != null) {
            for (int i14 : iArr2) {
                stringBuilder2.append(i14 + "#");
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        if (iArr3 != null) {
            for (int i15 : iArr3) {
                stringBuilder3.append(i15 + "#");
            }
        }
        if (aVar.dke != 0 && HardCoderJNI.hcDebug) {
            x.i("MicroMsg.HardCoderReporter", "[oneliang]performance report,hash:%s,threadId:%s,enable:%s, speedUp:%s,engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", Integer.valueOf(aVar.hashCode()), Integer.valueOf(aVar.dke), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(isRunning), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j), Integer.valueOf(aVar.dkj), Integer.valueOf(i7), Integer.valueOf(aVar.dkk), Integer.valueOf(i8), stringBuilder.toString(), Integer.valueOf(i9), Integer.valueOf(i2), Integer.valueOf(i10), Integer.valueOf(i), Integer.valueOf(i12), Long.valueOf(j2), stringBuilder2.toString(), stringBuilder3.toString());
        }
        if (dkX != null) {
            dkX.a(aVar.dke, i3, i4, isRunning, i5, i6, j, i7, i8, iArr, i9, i2, i10, i, i12, j2, iArr2, iArr3);
        }
    }

    public static void a(int i, long j, int i2, int i3, int i4) {
        if (dkX != null) {
            dkX.a(i, j, i2, i3, i4);
        }
    }

    public static void a(com.tencent.mm.hardcoder.b.a aVar) {
        if (dkX != null) {
            dkX.a(aVar.scene, aVar.dkf, aVar.type, aVar.dkA, aVar.dkB);
        }
    }

    public static void reportIDKey(boolean z, int i, int i2, boolean z2) {
        if (dkX != null) {
            dkX.reportIDKey(z, i, i2, z2);
        }
    }

    public static void a(a aVar) {
        if (dkX == null) {
            x.i("MicroMsg.HardCoderReporter", "hardcoder setReporter[%s], stack[%s]", aVar, bi.cjd());
            dkX = aVar;
        }
    }
}
