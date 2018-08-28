package com.tencent.tencentmap.mapsdk.a;

public final class oy$a {
    private double a = Double.POSITIVE_INFINITY;
    private double b = Double.NEGATIVE_INFINITY;
    private double c = Double.NaN;
    private double d = Double.NaN;

    public final oy$a a(ox oxVar) {
        this.a = Math.min(this.a, oxVar.a);
        this.b = Math.max(this.b, oxVar.a);
        double d = oxVar.b;
        if (Double.isNaN(this.c)) {
            this.c = d;
        } else {
            if (!a(d)) {
                if (oy.a(this.c, d) < oy.b(this.d, d)) {
                    this.c = d;
                }
            }
            return this;
        }
        this.d = d;
        return this;
    }

    private boolean a(double d) {
        if (this.c <= this.d) {
            if (this.c > d || d > this.d) {
                return false;
            }
            return true;
        } else if (this.c <= d || d <= this.d) {
            return true;
        } else {
            return false;
        }
    }

    public final oy a() {
        return new oy(new ox(this.a, this.c), new ox(this.b, this.d));
    }
}
