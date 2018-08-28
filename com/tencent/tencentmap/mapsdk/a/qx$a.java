package com.tencent.tencentmap.mapsdk.a;

public final class qx$a {
    private double a = Double.POSITIVE_INFINITY;
    private double b = Double.NEGATIVE_INFINITY;
    private double c = Double.NaN;
    private double d = Double.NaN;

    private boolean a(double d) {
        return this.c <= this.d ? this.c <= d && d <= this.d : this.c <= d || d <= this.d;
    }

    public final qx$a a(qw qwVar) {
        this.a = Math.min(this.a, qwVar.b());
        this.b = Math.max(this.b, qwVar.b());
        double c = qwVar.c();
        if (Double.isNaN(this.c)) {
            this.c = c;
        } else {
            if (!a(c)) {
                if (qx.a(this.c, c) < qx.b(this.d, c)) {
                    this.c = c;
                }
            }
            return this;
        }
        this.d = c;
        return this;
    }

    public final qx a() {
        return new qx(new qw(this.a, this.c), new qw(this.b, this.d));
    }
}
