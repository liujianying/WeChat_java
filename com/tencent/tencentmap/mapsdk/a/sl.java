package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tencentmap.mapsdk.a.rv.a;
import com.tencent.tencentmap.mapsdk.a.td.1;
import com.tencent.tencentmap.mapsdk.a.tz.j;

public final class sl implements a, se.a {
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 0;
    public static int f = 0;
    public static int g = 0;
    public static int h = 0;
    private static volatile Context i;
    private static boolean x = true;
    private static volatile String z = re.a(re.b);
    private boolean A = false;
    private boolean B = false;
    private rr C;
    private rk D;
    private tw j;
    private sf k;
    private sh l;
    private sm m;
    private 1 n;
    private tq o;
    private sg p;
    private si q;
    private sf$1 r;
    private volatile tb s;
    private ta t;
    private int u = 1;
    private j v = null;
    private boolean w = false;
    private Rect y = null;

    public sl(tw twVar) {
        i = twVar.getContext().getApplicationContext();
        te.a().a(i);
        sy.a().a(i);
        sk.a().a(i);
        sn.l();
        this.j = twVar;
        this.r = new sf$1(this);
        this.s = new tb(this);
        this.p = new sg(this);
        this.q = new si(this);
        this.t = new ta(this);
        this.k = new sf(this);
        this.l = new sh(this);
        this.m = new sm(this);
        this.n = new 1(this);
        this.o = new tq(this);
        this.q.a();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        twVar.addView(this.l, layoutParams);
        twVar.addView(this.t, layoutParams);
        twVar.addView(this.s, layoutParams);
        this.r.b(1);
        this.r.a(true);
        this.r.c(0);
        this.D = new rk();
        this.D.a();
        new rv(i, this).a();
        new se(i, this).a();
    }

    public static Context a() {
        return i;
    }

    public static void e(boolean z) {
        x = false;
    }

    public static void n() {
    }

    public static boolean p() {
        return x;
    }

    public static String q() {
        return z;
    }

    private rr s() {
        ru[] b = this.q.b();
        ru b2 = this.l.b();
        float c = this.q.d().c();
        if (this.C == null) {
            this.C = new rr(b2, b, c);
        } else {
            this.C.a(b2, b, c);
        }
        return this.C;
    }

    public final void a(int i) {
        this.u = i;
        a(false, false);
    }

    public final void a(Bitmap bitmap) {
        if (this.s != null) {
            this.s.a(bitmap);
            this.s.invalidate();
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.r.d(bundle.getBoolean("ANIMATION_ENABLED", true));
            this.r.b(bundle.getBoolean("SCROLL_ENABLED", true));
            this.r.c(bundle.getBoolean("ZOOM_ENABLED", true));
            this.r.b(bundle.getInt("LOGO_POSITION", 0));
            this.r.c(bundle.getInt("SCALEVIEW_POSITION", 0));
            this.r.a(bundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
            this.l.b(bundle.getDouble("ZOOM", this.l.c()), false, null);
            Double valueOf = Double.valueOf(bundle.getDouble("CENTERX", Double.NaN));
            Double valueOf2 = Double.valueOf(bundle.getDouble("CENTERY", Double.NaN));
            if (!valueOf.isNaN() && !valueOf2.isNaN()) {
                this.l.a(new ru(valueOf.doubleValue(), valueOf2.doubleValue()));
            }
        }
    }

    public final void a(j jVar) {
        a(jVar, null);
    }

    public final void a(j jVar, Rect rect) {
        this.v = jVar;
        this.y = rect;
        sz.a(this.l, 1);
        if (this.w) {
            o();
            return;
        }
        this.l.a(true);
        a(false, false);
    }

    public final void a(boolean z) {
        if (z) {
            a(false, false);
        }
    }

    public final void a(boolean z, boolean z2) {
        this.w = false;
        if (this.p != null) {
            this.p.a(s());
        }
        this.n.a(z, z2);
        this.j.f();
        this.j.postInvalidate();
    }

    public final si b() {
        return this.q;
    }

    public final void b(int i) {
        if (this.s != null) {
            this.s.a(i);
            this.s.invalidate();
            if (this.t.getVisibility() == 0) {
                this.t.invalidate();
            }
        }
    }

    public final void b(Bitmap bitmap) {
        this.j.post(new 2(this, bitmap));
    }

    public final void b(Bundle bundle) {
        bundle.putBoolean("ANIMATION_ENABLED", this.r.k());
        bundle.putBoolean("SCROLL_ENABLED", this.r.h());
        bundle.putBoolean("ZOOM_ENABLED", this.r.i());
        bundle.putInt("LOGO_POSITION", this.r.j());
        bundle.putInt("SCALEVIEW_POSITION", this.r.f());
        bundle.putBoolean("SCALE_CONTROLL_ENABLED", this.r.g());
        bundle.putDouble("ZOOM", this.l.c());
        bundle.putDouble("CENTERX", this.l.b().b());
        bundle.putDouble("CENTERY", this.l.b().a());
    }

    public final void b(boolean z) {
        if (z) {
            this.p.a();
        }
        sg.a(sn.j());
        this.p.a(s());
        a(false, false);
    }

    public final sh c() {
        return this.l;
    }

    public final void c(int i) {
        if (this.t != null && this.t.getVisibility() == 0) {
            this.t.a(i);
            this.t.invalidate();
        }
    }

    public final void c(boolean z) {
        if (z) {
            this.t.setVisibility(0);
            this.t.d();
            return;
        }
        ta.b();
        ta.c();
        this.t.setVisibility(8);
    }

    public final tw d() {
        return this.j;
    }

    protected final void d(boolean z) {
        this.w = z;
    }

    public final sf e() {
        return this.k;
    }

    public final sf$1 f() {
        return this.r;
    }

    protected final void f(boolean z) {
        this.A = z;
    }

    public final 1 g() {
        return this.n;
    }

    public final void g(boolean z) {
        if (z != this.B) {
            this.B = z;
            a(false, false);
        }
    }

    public final sm h() {
        return this.m;
    }

    public final tq i() {
        return this.o;
    }

    public final void j() {
        this.t.e();
    }

    public final void k() {
        this.t.d();
    }

    public final int l() {
        return this.u;
    }

    public final void m() {
        this.t.a();
        this.s.a();
        this.k.b();
        this.j.g();
        this.j.removeAllViews();
        this.n.a();
        this.p.b();
        sk.a().b();
        te.a().c();
        new 1(this).start();
        System.gc();
    }

    protected final void o() {
        if (this.v != null) {
            this.j.setDrawingCacheEnabled(true);
            this.j.buildDrawingCache();
            Bitmap createBitmap = this.y == null ? Bitmap.createBitmap(this.j.getDrawingCache()) : Bitmap.createBitmap(this.j.getDrawingCache(), this.y.left, this.y.top, this.y.width(), this.y.height());
            this.j.destroyDrawingCache();
            this.v.a(createBitmap);
            if (this.A) {
                sz.a(this.l, 2);
            }
        }
    }

    public final boolean r() {
        return this.B;
    }
}
