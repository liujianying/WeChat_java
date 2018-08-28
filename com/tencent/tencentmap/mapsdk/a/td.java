package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.tencentmap.mapsdk.a.tc.a;
import java.util.Comparator;

public final class td {
    private static final Comparator<td> m = new a((byte) 0);
    private final int a;
    private final int b;
    private final int c;
    private a d;
    private int e;
    private int f = 0;
    private rh g;
    private Bitmap h;
    private String i;
    private boolean j = true;
    private volatile boolean k = false;
    private su l;

    public td(rh rhVar, int i, int i2, int i3, int i4, int i5, a aVar) {
        this.g = rhVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = aVar;
        this.e = i5;
        this.f = i4;
    }

    public td(su suVar, int i, int i2, int i3) {
        this.g = suVar.d();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.l = suVar;
        this.i = suVar.e();
        this.j = suVar.f();
    }

    public static Comparator<td> k() {
        return m;
    }

    public final String a() {
        return this.i;
    }

    public final void a(Bitmap bitmap) {
        this.h = bitmap;
    }

    public final boolean a(Canvas canvas) {
        if ((this.l != null && !this.l.c()) || this.h == null || this.h.isRecycled()) {
            return false;
        }
        try {
            canvas.drawBitmap(this.h, 0.0f, 0.0f, null);
            return true;
        } catch (Exception e) {
            if (!(this.h == null || this.h.isRecycled())) {
                this.h.recycle();
            }
            this.h = null;
            return false;
        }
    }

    public final boolean a(su suVar) {
        return this.l == null ? false : this.l.equals(suVar);
    }

    public final byte[] a(boolean z, String str) {
        try {
            rf a;
            if (this.f == 7 && this.d == a.a) {
                a = this.g.a(this.a, this.b, this.c, this.d, new Object[]{Integer.valueOf(this.e), Integer.valueOf(this.f)});
            } else {
                a = this.g.a(this.a, this.b, this.c, this.d, new Object[]{Integer.valueOf(this.e), str, Boolean.valueOf(z)});
                if (a != null) {
                    return a.a();
                }
            }
            return a != null ? a.a() : null;
        } catch (Exception e) {
            new StringBuilder("get tile raises exception:").append(e.getMessage());
            return null;
        }
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final rh e() {
        return this.g;
    }

    public final Bitmap f() {
        return this.h;
    }

    public final boolean g() {
        return this.j;
    }

    public final void h() {
        this.k = true;
        if (!(this.h == null || this.h.isRecycled())) {
            this.h.recycle();
        }
        this.h = null;
    }

    public final boolean i() {
        return this.k;
    }

    public final float j() {
        return this.l != null ? this.l.a() : Float.NEGATIVE_INFINITY;
    }

    public final int l() {
        return this.e;
    }

    public final a m() {
        return this.d;
    }

    public final int n() {
        return this.f;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this.a);
        stringBuilder.append("_");
        stringBuilder.append(this.b);
        stringBuilder.append("_");
        stringBuilder.append(this.c);
        stringBuilder.append("_");
        stringBuilder.append(this.f);
        stringBuilder.append("_");
        stringBuilder.append(this.e);
        stringBuilder.append("_");
        stringBuilder.append(this.d);
        stringBuilder.append("_");
        stringBuilder.append(this.g.getClass().getCanonicalName());
        return stringBuilder.toString();
    }
}
