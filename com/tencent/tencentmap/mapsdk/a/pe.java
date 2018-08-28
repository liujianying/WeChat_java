package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.List;

public class pe {
    private final List<ox> a = new ArrayList();
    private float b = 1.0f;
    private int c = -16777216;
    private int d = kh.l;
    private int e = 0;
    private boolean f = true;
    private boolean g = false;
    private String h = "";
    private int i = -16777216;
    private Typeface j = Typeface.DEFAULT;
    private int k = Integer.MAX_VALUE;
    private int l = 1;
    private int m = -1;

    public void a(Iterable<ox> iterable) {
        if (this.a != null) {
            this.a.clear();
            if (iterable != null) {
                b((Iterable) iterable);
            }
        }
    }

    public pe b(Iterable<ox> iterable) {
        if (iterable != null) {
            for (ox add : iterable) {
                this.a.add(add);
            }
        }
        return this;
    }

    public pe a(float f) {
        if (f < 0.0f) {
            this.b = 1.0f;
        } else {
            this.b = f;
        }
        return this;
    }

    public pe a(int i) {
        this.c = i;
        return this;
    }

    public pe b(int i) {
        this.d = i;
        return this;
    }

    public pe c(int i) {
        this.e = i;
        return this;
    }

    public pe a(boolean z) {
        this.f = z;
        return this;
    }

    public List<ox> a() {
        return this.a;
    }

    public float b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public float e() {
        return (float) this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String g() {
        return this.h;
    }
}
