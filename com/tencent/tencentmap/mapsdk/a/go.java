package com.tencent.tencentmap.mapsdk.a;

import android.view.animation.Interpolator;

public abstract class go implements Cloneable {
    float a;
    Class<?> b;
    boolean c = false;
    private Interpolator d = null;

    public abstract Object a();

    /* renamed from: d */
    public abstract go clone();

    public static go a(float f, double d) {
        return new a(f, d);
    }

    public static go a(float f) {
        return new a(f);
    }

    public static go a(float f, Object obj) {
        return new b(f, obj);
    }

    public static go b(float f) {
        return new b(f, null);
    }

    public float b() {
        return this.a;
    }

    public Interpolator c() {
        return this.d;
    }

    public void a(Interpolator interpolator) {
        this.d = interpolator;
    }
}
