package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import com.tencent.mm.plugin.appbrand.r.b.b.a;
import com.tencent.mm.pluginsdk.q;

public final class e {
    private static double fTY = -85.0d;
    private static double fTZ = -1000.0d;
    private static double fUa = -85.0d;
    private static double fUb = -1000.0d;

    public static boolean a(double d, double d2, double d3, double d4, a aVar, double d5) {
        if (aVar == a.GPS) {
            if (d5 == 0.0d) {
                return false;
            }
            if (d5 <= 0.0d) {
                return false;
            }
        } else if (aVar != a.NETWORK) {
            return false;
        } else {
            Object obj = (d2 == -85.0d || d == -1000.0d) ? null : (d3 == -1000.0d || d4 == -85.0d) ? null : q.c(d2, d, d4, d3) >= 5.0d ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static double i(double d, double d2) {
        fUa = d;
        fUb = d2;
        double atan2 = (fTY == -85.0d || fTZ == -1000.0d) ? 0.0d : (Math.atan2(fUb - fTZ, fUa - fTY) * 180.0d) / 3.141592d;
        fTY = fUa;
        fTZ = fUb;
        return atan2;
    }
}
