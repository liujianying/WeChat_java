package com.tencent.tencentmap.mapsdk.a;

import java.io.File;

public final class su {
    private static int h = 0;
    private sl a;
    private final String b;
    private boolean c = true;
    private float d = Float.NEGATIVE_INFINITY;
    private boolean e = true;
    private rh f;
    private String g;

    public su(sl slVar, rg rgVar) {
        StringBuilder stringBuilder = new StringBuilder("TileOverlay_");
        int i = h;
        h = i + 1;
        this.b = stringBuilder.append(i).toString();
        this.a = slVar;
        this.g = sl.a().getPackageName() + File.separator + this.b;
        this.e = rgVar.d();
        this.f = rgVar.a();
        this.d = rgVar.b();
        this.c = rgVar.c();
    }

    public final float a() {
        return this.d;
    }

    public final void b() {
        this.a.g().a(this);
    }

    public final boolean c() {
        return this.c;
    }

    public final rh d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof su)) {
            return false;
        }
        return this.b.equals(((su) obj).b);
    }

    public final boolean f() {
        return this.e;
    }
}
