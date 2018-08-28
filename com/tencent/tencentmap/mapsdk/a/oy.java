package com.tencent.tencentmap.mapsdk.a;

public final class oy {
    public final ox a;
    public final ox b;

    public oy(ox oxVar, ox oxVar2) {
        this.a = oxVar;
        this.b = oxVar2;
    }

    public static a a() {
        return new a();
    }

    private static double c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oy)) {
            return false;
        }
        oy oyVar = (oy) obj;
        if (this.a.equals(oyVar.a) && this.b.equals(oyVar.b)) {
            return true;
        }
        return false;
    }

    static double a(double d, double d2) {
        return c(d, d2);
    }

    static double b(double d, double d2) {
        return d(d, d2);
    }
}
