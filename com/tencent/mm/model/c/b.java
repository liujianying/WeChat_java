package com.tencent.mm.model.c;

import com.tencent.mm.ab.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.a;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class b {
    private static boolean Sx = false;

    static /* synthetic */ void J(List list) {
        if (bi.cX(list)) {
            x.w("MicroMsg.ABTestUpdater", "No expired Exp");
            return;
        }
        d Jx = c.Jx();
        if (!bi.cX(list)) {
            for (Integer num : list) {
                if (num != null) {
                    c cVar = new c();
                    cVar.field_expId = String.valueOf(num);
                    Jx.a(cVar, new String[]{"expId"});
                }
            }
        }
        com.tencent.mm.storage.b Jy = c.Jy();
        if (!bi.cX(list)) {
            for (Integer num2 : list) {
                if (num2 != null) {
                    a aVar = new a();
                    aVar.field_expId = String.valueOf(num2);
                    Jy.a(aVar, new String[]{"expId"});
                }
            }
        }
    }

    static /* synthetic */ void K(List list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.ABTestUpdater", "No Exp");
            return;
        }
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (com.tencent.mm.bk.b a : list) {
            a.a ja = a.ja(ab.a(a));
            linkedList.addAll(ja.dEw);
            linkedList2.addAll(ja.dEx);
        }
        c.Jx().j(linkedList, 0);
        c.Jy().j(linkedList2, 1);
    }

    static void Jq() {
        int i = 1;
        if (g.Eg().Dx()) {
            Long l = (Long) g.Ei().DT().get(aa.a.sQz, null);
            long longValue = l == null ? 0 : l.longValue();
            int intValue;
            if (longValue == 0) {
                hk(new Random().nextInt(86400));
                Js();
                Jt();
                x.i("MicroMsg.ABTestUpdater", "First update ignored. Next update: %d", new Object[]{Integer.valueOf(intValue)});
            } else {
                Integer num = (Integer) g.Ei().DT().get(aa.a.sQA, null);
                intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                long j = (long) intValue;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String str = "MicroMsg.ABTestUpdater";
                String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Long.valueOf(j);
                objArr[3] = Long.valueOf(currentTimeMillis);
                x.i(str, str2, objArr);
                if (currentTimeMillis <= longValue + j) {
                    i = 0;
                }
            }
            if (i == 0) {
                x.v("MicroMsg.ABTestUpdater", "No need to update");
                return;
            } else if (Sx) {
                x.i("MicroMsg.ABTestUpdater", "Updating");
                return;
            } else {
                update();
                return;
            }
        }
        x.i("MicroMsg.ABTestUpdater", "Update aborted, Account not ready.");
    }

    static void Jr() {
        if (!g.Eg().Dx()) {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit aborted, Account not ready.");
        } else if (Sx) {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, Already Updating");
        } else {
            x.i("MicroMsg.ABTestUpdater", "UpdateWithoutIntervalLimit, before do update");
            update();
        }
    }

    private static void update() {
        Sx = true;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new yq();
        aVar.dIH = new yr();
        aVar.uri = "/cgi-bin/mmux-bin/getabtest";
        aVar.dIF = 1801;
        com.tencent.mm.ab.b KT = aVar.KT();
        yq yqVar = (yq) KT.dID.dIL;
        Integer num = (Integer) g.Ei().DT().get(aa.a.sQy, null);
        yqVar.rEQ = num == null ? 0 : num.intValue();
        yqVar.rER = c.Jx().cko();
        yqVar.rER.addAll(c.Jy().cko());
        String str = "MicroMsg.ABTestUpdater";
        String str2 = "update abtest: %s";
        Object[] objArr = new Object[1];
        LinkedList linkedList = yqVar.rER;
        String str3 = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str4 = str3;
            if (it.hasNext()) {
                uj ujVar = (uj) it.next();
                str3 = str4 + ujVar.rvu + ":" + ujVar.priority + "|";
            } else {
                objArr[0] = str4;
                x.i(str, str2, objArr);
                v.a(KT, new 1(), true);
                return;
            }
        }
    }

    private static void Js() {
        g.Ei().DT().a(aa.a.sQz, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    private static void hk(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.Ei().DT().a(aa.a.sQA, Integer.valueOf(i2));
    }

    private static void Jt() {
        g.Ei().DT().lm(true);
    }
}
