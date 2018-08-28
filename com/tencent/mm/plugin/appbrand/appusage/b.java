package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.g.a.pk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.j.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public enum b {
    ;
    
    public static final c<pk> fkZ = null;

    static {
        fkZ = new 1();
    }

    public static boolean acE() {
        if (!g.Eg().Dx()) {
            return false;
        }
        if (com.tencent.mm.k.g.AT().getInt("WeAppForbiddenSwitch", 0) == 1) {
            x.i("MicroMsg.AppBrandEntranceLogic", "showInFindMore, WeAppForbiddenSwitch == 1, not show");
            return false;
        } else if (acJ() || j.acX()) {
            return true;
        } else {
            return false;
        }
    }

    public static void acF() {
        if (g.Eg().Dx()) {
            if (acG()) {
                e eVar = e.fma;
                e.a("", 0, 2, 1);
            }
            g.Ei().DT().a(a.sTL, Boolean.valueOf(false));
        }
    }

    static boolean acG() {
        if (g.Eg().Dx()) {
            return ((Boolean) g.Ei().DT().get(a.sTL, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    static void jI(int i) {
        boolean z = true;
        if (g.Eg().Dx()) {
            boolean z2;
            com.tencent.mm.storage.x DT = g.Ei().DT();
            if ((i & 2) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            e(z2, "");
            a aVar = a.sTz;
            if ((i & 1) <= 0) {
                z = false;
            }
            DT.a(aVar, Boolean.valueOf(z));
        }
    }

    private static void e(boolean z, String str) {
        if (g.Eg().Dx()) {
            boolean z2;
            Boolean bool = (Boolean) g.Ei().DT().get(a.sTA, null);
            if (bool == null || bool.booleanValue() || !z) {
                z2 = false;
            } else {
                g.Ei().DT().a(a.sTL, Boolean.valueOf(true));
                e eVar = e.fma;
                e.a("", 0, 1, 1);
                z2 = true;
            }
            g.Ei().DT().a(a.sTA, Boolean.valueOf(z));
            if (z2) {
                AppBrandGuideUI.a aaY = com.tencent.mm.plugin.appbrand.app.e.aaY();
                if (aaY != null) {
                    aaY.guw = true;
                    aaY.gux = str;
                }
            }
        }
    }

    static void rk(String str) {
        e(true, str);
    }

    public static boolean acH() {
        if (g.Eg().Dx()) {
            return ((Boolean) g.Ei().DT().get(a.sTA, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    public static boolean acI() {
        if (g.Eg().Dx()) {
            return ((Boolean) g.Ei().DT().get(a.sTz, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }

    public static boolean acJ() {
        return acI() || acH();
    }
}
