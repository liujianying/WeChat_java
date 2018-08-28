package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;
import java.util.List;

public final class rd {
    private boolean a = false;
    private boolean b = false;
    private final List<qw> c = new ArrayList();
    private boolean d = true;
    private int e = -16777216;
    private float f = 10.0f;
    private float g = 0.0f;
    private qq h;
    private float i = 0.0f;
    private int j = -983041;
    private float k = 90.0f;

    public final qq a() {
        return this.h;
    }

    public final rd a(float f) {
        if (f > 0.0f) {
            this.k = f;
        }
        return this;
    }

    public final rd a(int i) {
        this.j = i;
        return this;
    }

    public final rd a(qq qqVar) {
        if (qqVar != null) {
            this.h = qqVar;
        }
        return this;
    }

    public final rd a(Iterable<qw> iterable) {
        for (qw add : iterable) {
            this.c.add(add);
        }
        return this;
    }

    public final rd a(boolean z) {
        this.d = z;
        return this;
    }

    public final float b() {
        return this.i;
    }

    public final rd b(float f) {
        if (f > 0.0f) {
            this.i = f;
        }
        return this;
    }

    public final rd b(int i) {
        this.e = i;
        return this;
    }

    public final rd b(boolean z) {
        this.b = z;
        return this;
    }

    public final int c() {
        return this.j;
    }

    public final rd c(float f) {
        this.f = f;
        return this;
    }

    public final rd c(boolean z) {
        this.a = z;
        return this;
    }

    public final float d() {
        return this.k;
    }

    public final rd d(float f) {
        this.g = f;
        return this;
    }

    public final List<qw> e() {
        return this.c;
    }

    public final float f() {
        return this.f;
    }

    public final int g() {
        return this.e;
    }

    public final float h() {
        return this.g;
    }

    public final boolean i() {
        return this.d;
    }

    public final boolean j() {
        return this.a;
    }

    public final boolean k() {
        return this.b;
    }
}
