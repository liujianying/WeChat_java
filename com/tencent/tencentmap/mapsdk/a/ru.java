package com.tencent.tencentmap.mapsdk.a;

public final class ru {
    private double a = Double.MIN_VALUE;
    private double b = Double.MIN_VALUE;

    public ru(double d, double d2) {
        b(d);
        a(d2);
    }

    public final double a() {
        return this.a;
    }

    public final void a(double d) {
        this.a = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d));
    }

    public final double b() {
        return this.b;
    }

    public final void b(double d) {
        this.b = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.hashCode() != hashCode()) {
            return false;
        }
        if (!(obj instanceof ru)) {
            return false;
        }
        ru ruVar = (ru) obj;
        return Double.doubleToLongBits(ruVar.b) == Double.doubleToLongBits(this.b) && Double.doubleToLongBits(ruVar.a) == Double.doubleToLongBits(this.a);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.a);
        return ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + ((((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32))) + 31) * 31);
    }
}
