package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class d {
    public static int lth = 0;
    public static int lti = 0;
    public static int ltj = 0;
    public static int ltk = 0;
    public static int ltl = 0;

    public static final void a(boolean z, long j, String str) {
        int i;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str});
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        h.mEJ.h(12725, new Object[]{Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(j), str});
    }

    public static final void a(boolean z, long j, String str, int i) {
        int i2;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, Integer.valueOf(i)});
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        h.mEJ.h(12725, new Object[]{Integer.valueOf(2), Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i)});
    }

    public static final void bfV() {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        h.mEJ.h(12722, new Object[]{Integer.valueOf(1)});
    }

    public static final void bfW() {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        h.mEJ.h(12722, new Object[]{Integer.valueOf(2)});
    }

    public static final void au(int i, String str) {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[]{Integer.valueOf(i), str});
        h.mEJ.h(12723, new Object[]{Integer.valueOf(i), str});
    }

    public static final void n(long j, String str) {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[]{Long.valueOf(j), str});
        h.mEJ.h(12726, new Object[]{Long.valueOf(j), str});
    }

    public static final void a(int i, boolean z, int i2, String str, int i3) {
        int i4;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3)});
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        h.mEJ.h(12727, new Object[]{Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(i3)});
    }

    public static final void o(long j, String str) {
        long j2 = j > 1000 ? j / 1000 : 1;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[]{Long.valueOf(j2), str});
        h.mEJ.h(12728, new Object[]{Long.valueOf(j2), str});
    }

    public static final void Hy(String str) {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[]{str, Integer.valueOf(lth), Integer.valueOf(lti), Integer.valueOf(ltj), Integer.valueOf(ltk), Integer.valueOf(ltl)});
        h.mEJ.h(12729, new Object[]{str, Integer.valueOf(lth), Integer.valueOf(lti), Integer.valueOf(ltj), Integer.valueOf(ltk), Integer.valueOf(ltl)});
        cU(9, lth);
        cU(10, ltl);
        cU(11, lti);
        cU(12, ltj);
        cU(13, ltk);
        lth = 0;
        lti = 0;
        ltj = 0;
        ltk = 0;
        ltl = 0;
    }

    public static final void f(String str, boolean z, boolean z2) {
        if (z && z2) {
            h.mEJ.h(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(1)});
        } else if (z) {
            h.mEJ.h(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(2)});
        } else if (z2) {
            h.mEJ.h(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(1)});
        } else {
            h.mEJ.h(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(2)});
        }
    }

    public static final void bfX() {
        h.mEJ.a(220, 0, 1, false);
    }

    public static final void gH(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(4);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        h.mEJ.b(arrayList, false);
    }

    public static final void bfY() {
        h.mEJ.a(220, 1, 1, false);
    }

    public static final void gI(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(6);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        h.mEJ.b(arrayList, false);
    }

    public static final void tg(int i) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(7);
        iDKey.SetValue((long) i);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(8);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        h.mEJ.b(arrayList, false);
    }

    private static void cU(int i, int i2) {
        h.mEJ.a(220, (long) i, (long) i2, false);
    }

    public static final void bfZ() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(1)});
    }

    public static final void bga() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(2)});
    }

    public static final void bgb() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(3)});
    }

    public static final void bgc() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(4)});
    }

    public static final void bgd() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(5)});
    }

    public static final void bge() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(6)});
    }

    public static final void bgf() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(7)});
    }

    public static final void bgg() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(8)});
    }

    public static final void bgh() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(9)});
    }

    public static final void bgi() {
        h.mEJ.h(14849, new Object[]{Integer.valueOf(10)});
    }
}
