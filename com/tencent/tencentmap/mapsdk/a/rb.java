package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.List;

public final class rb {
    private int a = -16777216;
    private int b = -16777216;
    private final List<qw> c = new ArrayList();
    private float d = 10.0f;
    private boolean e = true;
    private float f = 0.0f;

    public final rb a(float f) {
        this.d = f;
        return this;
    }

    public final rb a(int i) {
        this.a = i;
        return this;
    }

    public final rb a(Iterable<qw> iterable) {
        for (qw add : iterable) {
            this.c.add(add);
        }
        return this;
    }

    public final rb a(boolean z) {
        this.e = z;
        return this;
    }

    public final List<qw> a() {
        return this.c;
    }

    public final float b() {
        return this.d;
    }

    public final rb b(float f) {
        this.f = f;
        return this;
    }

    public final rb b(int i) {
        this.b = i;
        return this;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public final float e() {
        return this.f;
    }

    public final boolean f() {
        return this.e;
    }
}
