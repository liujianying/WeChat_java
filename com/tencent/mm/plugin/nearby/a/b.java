package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;

public final class b {
    public static final int lBl = 1;
    private static final /* synthetic */ int[] lBm = new int[]{lBl};

    public static boolean dV(String str, String str2) {
        ab abVar = new ab();
        abVar.dx(str2);
        abVar.setUsername(str);
        au.HU();
        ay FR = c.FR();
        x.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + abVar.field_username);
        if (!FR.Yi(abVar.field_username)) {
            FR.T(abVar);
        }
        au.HU();
        c.DT().set(143873, str);
        au.HU();
        c.DT().set(143874, Long.valueOf(bi.VE()));
        return true;
    }

    public static void bP(String str, int i) {
        au.HU();
        au.DF().a(new d(str, (int) bi.bG(bi.c((Long) c.DT().get(143874, Long.valueOf(0)))), i), 0);
    }

    public static void tP(int i) {
        au.HU();
        String oV = bi.oV((String) c.DT().get(143873, ""));
        if (!oV.equals("")) {
            au.HU();
            if (bi.bG(bi.c((Long) c.DT().get(143874, Long.valueOf(0)))) < 7200) {
                bP(oV, i);
            } else {
                IH(oV);
            }
        }
    }

    public static boolean biN() {
        au.HU();
        return bi.f((Integer) c.DT().get(143875, Integer.valueOf(0))) == 1;
    }

    public static void biO() {
        au.HU();
        c.DT().set(143875, Integer.valueOf(1));
    }

    public static void biP() {
        au.HU();
        c.DT().set(143875, Integer.valueOf(0));
    }

    public static void IH(String str) {
        au.HU();
        ay FR = c.FR();
        if (FR.Yi(str)) {
            FR.Ym(str);
        }
        bd.a(str, new 1());
        au.HU();
        c.DT().set(143873, "");
        au.HU();
        c.DT().set(143874, Long.valueOf(0));
        biP();
    }
}
