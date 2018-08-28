package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.a.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e {
    public static final int[] jqK = new int[]{8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26};
    public static final a jqL = new a();
    public static String jqM = "";

    public static final void g(int i, long j, long j2) {
        if (d.b(i, jqK)) {
            g.Eg();
            long longValue = new o(a.Df()).longValue();
            if (d.qVO) {
                if (longValue % 100 != 1) {
                    return;
                }
            } else if (d.qVP && longValue % 10 != 1) {
                return;
            }
            String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[11];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Long.valueOf(j);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(jqL.jqN >= 1536 ? 1 : 0);
            objArr[5] = Long.valueOf(jqL.jqN);
            objArr[6] = Long.valueOf(jqL.jqO);
            objArr[7] = Long.valueOf(jqL.jqP);
            objArr[8] = Long.valueOf(jqL.jqQ);
            objArr[9] = Long.valueOf(jqL.jqR);
            objArr[10] = Long.valueOf(j2);
            x.v("MicroMsg.FTS.FTSReportApiLogic", "reportKVSearchTime: %d %s", Integer.valueOf(14175), String.format(str, objArr));
            f.mDy.k(14175, r0);
        }
    }

    public static void u(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 2) + 1;
            x.v("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(HardCoderJNI.SCENE_DECODE_PIC);
            iDKey.SetKey(i2);
            iDKey.SetValue((long) ((int) j));
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(HardCoderJNI.SCENE_DECODE_PIC);
            iDKey.SetKey(i2 + 1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            f.mDy.b(arrayList, false);
        }
    }

    public static void v(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 4) + 1;
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(HardCoderJNI.SCENE_GIF);
            iDKey.SetKey(i2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            if (j <= 100) {
                iDKey = new IDKey();
                iDKey.SetID(HardCoderJNI.SCENE_GIF);
                iDKey.SetKey(i2 + 1);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else if (j <= 500) {
                iDKey = new IDKey();
                iDKey.SetID(HardCoderJNI.SCENE_GIF);
                iDKey.SetKey(i2 + 2);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else {
                iDKey = new IDKey();
                iDKey.SetID(HardCoderJNI.SCENE_GIF);
                iDKey.SetKey(i2 + 3);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            }
            f.mDy.b(arrayList, false);
        }
    }

    public static void qd(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(146);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        if (i != 1) {
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(i);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else {
            iDKey = new IDKey();
            iDKey.SetID(146);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        f.mDy.b(arrayList, false);
    }

    public static final void qe(int i) {
        x.i("MicroMsg.FTS.FTSReportApiLogic", "reportCommonChatroom: %d %d", Integer.valueOf(14731), Integer.valueOf(i));
        f.mDy.h(14731, Integer.valueOf(i));
    }

    public static final void aPZ() {
        x.i("MicroMsg.FTS.FTSReportApiLogic", "reportIDKeyFTSData %d %d %d %d %d", Long.valueOf(jqL.jqN), Long.valueOf(jqL.jqO), Long.valueOf(jqL.jqP), Long.valueOf(jqL.jqR), Long.valueOf(jqL.jqQ));
        ArrayList arrayList = new ArrayList();
        d(arrayList, 0);
        if (jqL.jqN > 1536) {
            d(arrayList, 1);
        }
        if (jqL.jqO >= 10000) {
            d(arrayList, 2);
        }
        if (jqL.jqP >= 5000) {
            d(arrayList, 3);
        }
        if (jqL.jqR >= 10000) {
            d(arrayList, 4);
        }
        if (jqL.jqQ >= 1000000) {
            d(arrayList, 5);
        }
        f.mDy.b(arrayList, false);
    }

    private static final void d(ArrayList<IDKey> arrayList, int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(729);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
    }

    public static final void qf(int i) {
        x.i("MicroMsg.FTS.FTSReportApiLogic", "reportFTSVoiceResult 15375 %d", Integer.valueOf(i));
        f.mDy.h(15375, Integer.valueOf(i));
    }
}
