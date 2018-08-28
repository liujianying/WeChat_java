package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;

public final class sa extends rw {
    private float d;
    private Point e;

    public final void a(float f) {
        this.d = f;
    }

    public final void a(Point point) {
        this.e = point;
    }

    public final void a(sl slVar) {
        if (this.e != null) {
            slVar.c().a((double) this.d, new PointF((float) this.e.x, (float) this.e.y), this.a, this.c);
            return;
        }
        slVar.c().a((double) this.d, this.a, this.c);
    }
}
