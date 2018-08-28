package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;

public class ty {
    private sl a;
    private si b;

    public ty(sl slVar) {
        this.a = slVar;
        this.b = slVar.b();
    }

    public double a(qw qwVar, qw qwVar2) {
        return rv.a(qwVar, qwVar2);
    }

    public float a(double d, double d2) {
        return this.b.a(d, d2);
    }

    public float a(float f) {
        return this.b.a(f);
    }

    public Point a(qw qwVar) {
        PointF a = this.b.a(qwVar);
        return new Point((int) a.x, (int) a.y);
    }

    public qw a(Point point) {
        return this.b.a(point.x, point.y);
    }

    public rj a() {
        int width = this.a.c().getWidth();
        int height = this.a.c().getHeight();
        qw a = a(new Point(0, 0));
        qw a2 = a(new Point(width, 0));
        qw a3 = a(new Point(0, height));
        qw a4 = a(new Point(width, height));
        return new rj(a3, a4, a, a2, qx.a().a(a3).a(a4).a(a).a(a2).a());
    }

    public int b() {
        qx e = a().e();
        return (int) ((e.c().b() * 1000000.0d) - (e.b().b() * 1000000.0d));
    }

    public int c() {
        qx e = a().e();
        return (int) ((e.c().c() * 1000000.0d) - (e.b().c() * 1000000.0d));
    }

    public float d() {
        return this.b.f();
    }
}
