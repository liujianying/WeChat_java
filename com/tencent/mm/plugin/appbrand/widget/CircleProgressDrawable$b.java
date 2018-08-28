package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Path;
import android.support.v4.view.b.e;
import android.view.animation.Interpolator;

class CircleProgressDrawable$b {
    public static final Interpolator gEM = e.b(gEN);
    private static final Path gEN;

    static {
        Path path = new Path();
        gEN = path;
        path.cubicTo(0.2f, 0.0f, 0.1f, 1.0f, 0.5f, 1.0f);
        gEN.lineTo(1.0f, 1.0f);
    }
}
