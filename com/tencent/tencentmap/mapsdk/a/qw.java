package com.tencent.tencentmap.mapsdk.a;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class qw implements Cloneable {
    private static DecimalFormat a = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    private final double b;
    private final double c;

    public qw(double d, double d2) {
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.b = a(((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d);
        } else {
            this.b = a(d2);
        }
        this.c = a(Math.max(-85.0d, Math.min(85.0d, d)));
    }

    private static double a(double d) {
        return Double.parseDouble(a.format(d));
    }

    /* renamed from: a */
    public final qw clone() {
        return new qw(this.c, this.b);
    }

    public final double b() {
        return this.c;
    }

    public final double c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return Double.doubleToLongBits(this.c) == Double.doubleToLongBits(qwVar.c) && Double.doubleToLongBits(this.b) == Double.doubleToLongBits(qwVar.b);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.c);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.c + "," + this.b + ")";
    }
}
