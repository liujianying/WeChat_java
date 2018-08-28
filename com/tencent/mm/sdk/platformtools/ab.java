package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class ab {
    public static b cWE;
    private static int sGq;
    public static Map<Integer, ab> sGs = new HashMap();
    private static boolean sGu = false;
    public static boolean sGv;
    private final boolean dGv;
    public long dkB = 0;
    public final int sGr;
    private final a sGt;
    public long ts = 0;

    public static void a(b bVar) {
        sGu = true;
        cWE = bVar;
    }

    protected final void finalize() {
        SO();
        super.finalize();
    }

    public ab(a aVar) {
        Assert.assertTrue("bumper not initialized", sGu);
        this.sGt = aVar;
        this.dGv = true;
        if (sGq >= 8192) {
            sGq = 0;
        }
        int i = sGq + 1;
        sGq = i;
        this.sGr = i;
    }

    public static long chU() {
        sGv = false;
        List linkedList = new LinkedList();
        Set<Integer> hashSet = new HashSet();
        hashSet.addAll(sGs.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            ab abVar = (ab) sGs.get(num);
            if (abVar != null) {
                long bI = bi.bI(abVar.ts);
                if (bI < 0) {
                    bI = 0;
                }
                if (bI > abVar.dkB) {
                    if (abVar.sGt.vD() && abVar.dGv) {
                        j = abVar.dkB;
                    } else {
                        linkedList.add(num);
                    }
                    abVar.ts = bi.VG();
                } else if (abVar.dkB - bI < j) {
                    j = abVar.dkB - bI;
                }
            }
            j = j;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            sGs.remove(linkedList.get(i));
        }
        if (!(sGv || j != Long.MAX_VALUE || cWE == null)) {
            cWE.cancel();
            x.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public final void SO() {
        sGs.remove(Integer.valueOf(this.sGr));
    }

    public static boolean fY(long j) {
        long j2;
        x.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j);
        long j3 = Long.MAX_VALUE;
        Iterator it = sGs.entrySet().iterator();
        while (true) {
            j2 = j3;
            if (!it.hasNext()) {
                break;
            }
            ab abVar = (ab) ((Entry) it.next()).getValue();
            if (abVar != null) {
                long bI = bi.bI(abVar.ts);
                if (bI < 0) {
                    bI = 0;
                }
                if (bI > abVar.dkB) {
                    j3 = abVar.dkB;
                } else if (abVar.dkB - bI < j2) {
                    j2 = abVar.dkB - bI;
                }
            }
            j3 = j2;
        }
        return j2 > j;
    }
}
