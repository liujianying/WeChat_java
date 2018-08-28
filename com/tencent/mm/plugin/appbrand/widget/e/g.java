package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mm.plugin.appbrand.compat.a.b.f;

public final class g {
    public static double gMF = 6378137.0d;
    final double gMG = (6.283185307179586d * gMF);

    public final f c(f fVar) {
        double adH = (fVar.adH() / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(fVar.adG()));
        return new f(adH * this.gMG, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.gMG);
    }
}
