package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;

public final class ts {
    public static tr a() {
        return new tr(new sb());
    }

    public static tr a(float f) {
        sd sdVar = new sd();
        sdVar.a(f);
        return new tr(sdVar);
    }

    public static tr a(float f, float f2) {
        rz rzVar = new rz();
        rzVar.a(f);
        rzVar.b(f2);
        return new tr(rzVar);
    }

    public static tr a(float f, Point point) {
        return new tr(rv.a(f, point));
    }

    public static tr a(qs qsVar) {
        return new tr(rv.a(qsVar));
    }

    public static tr a(qw qwVar) {
        return new tr(rv.a(qs.a().a(qwVar).a()));
    }

    public static tr a(qw qwVar, float f) {
        return new tr(rv.a(qs.a().a(qwVar).a(f).a()));
    }

    public static tr a(qx qxVar, int i) {
        return new tr(rv.a(qxVar, 0, 0, i));
    }

    public static tr a(qx qxVar, int i, int i2, int i3) {
        return new tr(rv.a(qxVar, i, i2, i3));
    }

    public static tr b() {
        return new tr(new sc());
    }

    public static tr b(float f) {
        return new tr(rv.a(f, null));
    }
}
