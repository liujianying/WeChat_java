package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum i {
    ;
    
    private static volatile long flB;
    private static volatile ako flC;
    private static final Set<b> flD = null;

    static {
        flD = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void a(b bVar) {
        if (bVar != null) {
            flD.add(bVar);
        }
    }

    public static void b(b bVar) {
        if (bVar != null) {
            flD.remove(bVar);
        }
    }

    public static boolean acO() {
        return true;
    }

    public static boolean acP() {
        switch (3.flJ[acQ().ordinal()]) {
            case 2:
                return true;
            case 3:
                if (acR()) {
                    return true;
                }
                return flC != null && flC.gTo >= flC.rNl;
            default:
                return false;
        }
    }

    public static boolean refresh() {
        flC = null;
        flB = 0;
        if (a.flK == acQ()) {
            return false;
        }
        PBool pBool = new PBool();
        PBool pBool2 = new PBool();
        pBool.value = false;
        pBool2.value = false;
        al alVar = new al(Looper.getMainLooper(), new 1(pBool2, pBool), false);
        long toMillis = TimeUnit.SECONDS.toMillis(20);
        alVar.J(toMillis, toMillis);
        c.OB().b((a) com.tencent.mm.plugin.appbrand.r.c.br(new 2(pBool, pBool2)), false);
        return true;
    }

    static a acQ() {
        int i = 0;
        if (!g.Eg().Dx()) {
            return a.flK;
        }
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100215");
        if (fJ.isValid()) {
            int i2 = bi.getInt((String) fJ.ckq().get("isOpenNewNearEntry"), 0);
            a[] values = a.values();
            int length = values.length;
            while (i < length) {
                a aVar = values[i];
                if (aVar.value == i2) {
                    return aVar;
                }
                i++;
            }
        }
        return a.flK;
    }

    static boolean acR() {
        return g.Ei().DT().getBoolean(aa.a.sTR, false);
    }

    static void acS() {
        g.Ei().DT().a(aa.a.sTR, Boolean.valueOf(true));
    }

    public static ako acT() {
        return flC;
    }

    public static boolean acU() {
        long VE = bi.VE();
        long j = (!g.Eg().Dx() || flC == null) ? 0 : flB;
        return VE >= j;
    }

    public static void acV() {
        flC = null;
    }
}
