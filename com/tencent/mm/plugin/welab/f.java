package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.ab.v;
import com.tencent.mm.bk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.protocal.c.yr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class f {
    private static boolean DEBUG = false;
    private static boolean Sx = false;

    static /* synthetic */ void J(List list) {
        if (list == null || list.size() == 0) {
            x.w("MicroMsg.WelabUpdater", "No Exp");
            return;
        }
        List arrayList = new ArrayList();
        for (b a : list) {
            a RV = g.RV(ab.a(a));
            if (RV != null && RV.isValid()) {
                arrayList.add(RV);
                com.tencent.mm.plugin.welab.d.b.bYX().f(RV);
                e.n(RV.field_LabsAppId, 8, com.tencent.mm.plugin.welab.d.b.bYX().e(RV));
            }
        }
        x.i("MicroMsg.WelabUpdater", "save exp " + arrayList);
        b.bYI().qmM.cQ(arrayList);
    }

    static /* synthetic */ void cP(List list) {
        if (bi.cX(list)) {
            x.w("MicroMsg.WelabUpdater", "No expired Exp");
            return;
        }
        x.i("MicroMsg.WelabUpdater", "expired exp " + list);
        List arrayList = new ArrayList();
        for (Integer num : list) {
            a aVar = new a();
            aVar.field_expId = num.toString();
            b.bYI().qmM.b(aVar, new String[]{"expId"});
            if (!TextUtils.isEmpty(aVar.field_LabsAppId)) {
                aVar.field_Switch = 3;
                arrayList.add(aVar);
            }
        }
        b.bYI().qmM.cQ(arrayList);
    }

    static void P(boolean z, boolean z2) {
        x.i("MicroMsg.WelabUpdater", "tryToUpdate isUpgrade %s, isManualAuth %s ", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (g.Eg().Dx()) {
            if (!(DEBUG || z || z2)) {
                Object obj;
                Long l = (Long) g.Ei().DT().get(aa.a.sXf, null);
                long longValue = l == null ? 0 : l.longValue();
                int intValue;
                if (longValue == 0) {
                    hk(new Random().nextInt(86400));
                    Js();
                    Jt();
                    x.i("MicroMsg.WelabUpdater", "First update ignored. Next update: %d", new Object[]{Integer.valueOf(intValue)});
                    obj = 1;
                } else {
                    Integer num = (Integer) g.Ei().DT().get(aa.a.sXg, null);
                    intValue = (num == null || num.intValue() == 0) ? 86400 : num.intValue();
                    long j = (long) intValue;
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    String str = "MicroMsg.WelabUpdater";
                    String str2 = "Need Update: %b, Last Update Time: %d, Update Interval: %d, Current Time: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = Boolean.valueOf(currentTimeMillis > longValue + j);
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Long.valueOf(j);
                    objArr[3] = Long.valueOf(currentTimeMillis);
                    x.i(str, str2, objArr);
                    obj = currentTimeMillis > longValue + j ? 1 : null;
                }
                if (obj == null) {
                    x.v("MicroMsg.WelabUpdater", "No need to update");
                    return;
                }
            }
            if (Sx) {
                x.i("MicroMsg.WelabUpdater", "Updating");
                return;
            }
            Sx = true;
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIG = new yq();
            aVar.dIH = new yr();
            aVar.uri = "/cgi-bin/mmux-bin/getlabsinfo";
            aVar.dIF = 1816;
            com.tencent.mm.ab.b KT = aVar.KT();
            yq yqVar = (yq) KT.dID.dIL;
            Integer num2 = (Integer) g.Ei().DT().get(aa.a.sXh, null);
            yqVar.rEQ = num2 == null ? 0 : num2.intValue();
            yqVar.rER = bYK();
            yqVar.rES = (int) bi.VE();
            if (z) {
                yqVar.bWA |= 1;
            }
            if (z2) {
                yqVar.bWA |= 2;
            }
            x.i("MicroMsg.WelabUpdater", "update abtest: %s", new Object[]{ao(yqVar.rER)});
            v.a(KT, new 1());
            return;
        }
        x.i("MicroMsg.WelabUpdater", "Update aborted, Account not ready.");
    }

    private static String ao(LinkedList<uj> linkedList) {
        String str = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            uj ujVar = (uj) it.next();
            str = str2 + ujVar.rvu + ":" + ujVar.priority + "|";
        }
    }

    private static LinkedList<uj> bYK() {
        LinkedList<uj> linkedList = new LinkedList();
        try {
            for (a aVar : b.bYI().qmM.bYS()) {
                uj ujVar = new uj();
                ujVar.rvu = bi.getInt(aVar.field_expId, 0);
                ujVar.priority = aVar.field_prioritylevel;
                linkedList.add(ujVar);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WelabUpdater", e, "", new Object[0]);
        }
        return linkedList;
    }

    private static void Js() {
        g.Ei().DT().a(aa.a.sXf, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    private static void hk(int i) {
        int i2 = 0;
        if (i == 0) {
            i2 = 86400;
        } else if (i < 3600 || i > 129600) {
            i2 = new Random().nextInt(126000) + 3600;
        }
        g.Ei().DT().a(aa.a.sXg, Integer.valueOf(i2));
    }

    private static void Jt() {
        g.Ei().DT().lm(true);
    }
}
