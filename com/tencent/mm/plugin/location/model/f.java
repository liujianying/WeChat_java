package com.tencent.mm.plugin.location.model;

import com.tencent.mm.pluginsdk.q;

public final class f {
    private static double fTY = -85.0d;
    private static double fTZ = -1000.0d;
    private static double fUa = -85.0d;
    private static double fUb = -1000.0d;

    public static double i(double d, double d2) {
        fUa = d;
        fUb = d2;
        double atan2 = (fTY == -85.0d || fTZ == -1000.0d) ? 0.0d : (Math.atan2(fUb - fTZ, fUa - fTY) * 180.0d) / 3.141592d;
        fTY = fUa;
        fTZ = fUb;
        return atan2;
    }

    public static boolean a(double d, double d2, double d3, double d4, int i, double d5) {
        if (i == 0) {
            if (d5 == 0.0d) {
                return false;
            }
            if (d5 <= 0.0d) {
                return false;
            }
        } else if (i != 1) {
            return false;
        } else {
            Object obj = (d2 == -85.0d || d == -1000.0d) ? null : (d3 == -1000.0d || d4 == -85.0d) ? null : q.c(d2, d, d4, d3) >= 5.0d ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static double o(int i, int i2, int i3, int i4) {
        return Math.sqrt((double) (((i - i3) * (i - i3)) + ((i2 - i4) * (i2 - i4))));
    }

    public static boolean t(double d) {
        return d >= 4.0d;
    }
}
