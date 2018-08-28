package com.tencent.tencentmap.mapsdk.a;

public final class rt$a {
    private double a = Double.MAX_VALUE;
    private double b = -1.7976931348623157E308d;
    private double c = Double.MAX_VALUE;
    private double d = -1.7976931348623157E308d;

    public final rt$a a(ru ruVar) {
        this.a = Math.min(this.a, ruVar.a());
        this.b = Math.max(this.b, ruVar.a());
        this.d = Math.max(this.d, ruVar.b());
        this.c = Math.min(this.c, ruVar.b());
        return this;
    }
}
