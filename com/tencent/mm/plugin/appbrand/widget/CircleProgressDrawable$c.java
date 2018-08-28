package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.e;
import android.view.animation.Interpolator;

class CircleProgressDrawable$c {
    public static final Interpolator gEM = e.b(gEO);
    private static final Path gEO;

    static {
        Path path = new Path();
        gEO = path;
        path.lineTo(0.5f, 0.0f);
        gEO.cubicTo(0.7f, 0.0f, 0.6f, 1.0f, 1.0f, 1.0f);
    }
}
