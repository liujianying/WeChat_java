package com.tencent.tencentmap.mapsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.tencentmap.mapsdk.a.tw.a;

public final class sr {
    private static int a = 0;
    private static qq b;
    private Animation A;
    private int B = 25;
    private Object C;
    private sl c;
    private Context d;
    private sm e;
    private tw f;
    private View g;
    private View h;
    private Animation i = null;
    private Animation j = null;
    private GestureDetector k;
    private qq l = null;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private float q = 0.5f;
    private float r = 1.0f;
    private boolean s = true;
    private float t = 0.0f;
    private float u = 1.0f;
    private String v;
    private qw w;
    private String x;
    private String y;
    private Animation z;

    public sr(sl slVar, qz qzVar) {
        this.c = slVar;
        this.d = sl.a();
        this.f = slVar.d();
        this.e = slVar.h();
        this.n = qzVar.k();
        if (qzVar.a() != null) {
            if (this.n) {
                try {
                    double[] a = st.a(qzVar.a().c(), qzVar.a().b());
                    qw qwVar = new qw(a[1], a[0]);
                } catch (Exception e) {
                    qzVar.a();
                }
            }
            this.w = qzVar.a();
        }
        a(qzVar.d());
        this.g = qzVar.l();
        this.q = qzVar.e();
        this.r = qzVar.f();
        this.u = qzVar.h();
        this.t = qzVar.g();
        this.s = qzVar.j();
        this.v = qzVar.c();
        this.x = qzVar.b();
        this.m = qzVar.i();
        this.y = m();
        this.j = qzVar.p();
        this.i = qzVar.m();
        this.z = qzVar.n();
        this.A = qzVar.o();
        this.C = qzVar.q();
        this.B = (int) (((float) this.B) * this.d.getResources().getDisplayMetrics().density);
        this.k = new GestureDetector(this.d, new 1(this));
        q();
    }

    private static boolean a(float f, float f2, float f3) {
        return f > f2 && f <= f3;
    }

    private void q() {
        if (this.g == null) {
            if (this.l == null) {
                if (b == null) {
                    b = qr.a();
                }
                this.l = b;
            }
            this.g = new ImageView(this.d);
            ((ImageView) this.g).setImageBitmap(this.l.b());
        }
        this.g.measure(0, 0);
        b(this.u);
        a(this.t);
        this.f.addView(this.g, s());
        if (!this.s || this.z == null) {
            r();
            return;
        }
        this.g.clearAnimation();
        this.z.setAnimationListener(new 2(this));
        this.g.startAnimation(this.z);
    }

    private void r() {
        this.g.setOnTouchListener(new 3(this));
    }

    private a s() {
        PointF t = t();
        return new a(-2, -2, this.w, -((int) t.x), -((int) t.y), 0);
    }

    private PointF t() {
        PointF pointF = new PointF();
        pointF.x = ((float) this.g.getMeasuredWidth()) * this.q;
        pointF.y = ((float) this.g.getMeasuredHeight()) * this.r;
        return pointF;
    }

    private PointF u() {
        PointF pointF = new PointF();
        PointF pointF2 = a(this.t, 45.0f, 135.0f) ? new PointF(0.0f, ((float) this.g.getMeasuredHeight()) * 0.5f) : a(this.t, 135.0f, 225.0f) ? new PointF(((float) this.g.getMeasuredWidth()) * 0.5f, (float) this.g.getMeasuredHeight()) : a(this.t, 225.0f, 315.0f) ? new PointF((float) this.g.getMeasuredWidth(), ((float) this.g.getMeasuredHeight()) * 0.5f) : new PointF(((float) this.g.getMeasuredWidth()) * 0.5f, 0.0f);
        PointF t = t();
        float f = pointF2.x - t.x;
        float f2 = (-pointF2.y) + t.y;
        float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        double atan = Math.atan((double) (f / f2));
        if ((f > 0.0f && f2 < 0.0f) || (f < 0.0f && f2 < 0.0f)) {
            atan += 3.141592653589793d;
        }
        atan += ((double) (this.t / 180.0f)) * 3.141592653589793d;
        pointF.x = (float) (((double) sqrt) * Math.sin(atan));
        pointF.y = -((float) (Math.cos(atan) * ((double) sqrt)));
        return pointF;
    }

    private void v() {
        if (e()) {
            this.h.clearAnimation();
            this.f.removeView(this.h);
            PointF u = u();
            this.f.addView(this.h, this.f.indexOfChild(this.g) + 1, new a(-2, -2, this.w, (int) u.x, (int) u.y, 81));
        }
    }

    private void w() {
        if (e() && (this.h instanceof sq)) {
            ((sq) this.h).a(this.x, this.v);
        }
    }

    public final View a() {
        return this.g;
    }

    @SuppressLint({"NewApi"})
    public final void a(float f) {
        float f2 = (f + 360.0f) % 360.0f;
        if (VERSION.SDK_INT < 11) {
            Animation rotateAnimation = new RotateAnimation(this.t, f2, 1, this.q, 1, this.r);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setDuration(0);
            this.g.clearAnimation();
            this.g.startAnimation(rotateAnimation);
        } else {
            PointF t = t();
            this.g.setPivotX(t.x);
            this.g.setPivotY(t.y);
            this.g.setRotation(f2);
        }
        this.t = f2;
        v();
    }

    public final void a(float f, float f2) {
        if (this.q != f || this.r != f2) {
            this.q = f;
            this.r = f2;
            this.g.setLayoutParams(s());
            a(this.t);
            v();
        }
    }

    public final void a(View view) {
        if (this.g != null) {
            if (this.A != null) {
                this.A.setAnimationListener(new 4(this, view));
                this.g.setOnTouchListener(null);
                this.g.startAnimation(this.A);
                return;
            }
            this.f.removeView(this.g);
        }
        this.g = view;
        q();
        v();
    }

    public final void a(Animation animation) {
        this.i = animation;
    }

    public final void a(qq qqVar) {
        this.l = qqVar;
        if (this.g != null && (this.g instanceof ImageView)) {
            ((ImageView) this.g).setImageBitmap(this.l.b());
            this.g.measure(0, 0);
            this.g.setLayoutParams(s());
        }
    }

    public final void a(qw qwVar) {
        if (qwVar != null) {
            this.w = qwVar;
            ((a) this.g.getLayoutParams()).a(qwVar);
            this.f.a(this.g);
            if (this.h != null) {
                ((a) this.h.getLayoutParams()).a(qwVar);
                this.f.a(this.h);
            }
        }
    }

    public final void a(Object obj) {
        this.C = obj;
    }

    public final void a(String str) {
        this.v = str;
        w();
    }

    public final void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
        if (!z && e()) {
            g();
        }
        this.s = z;
    }

    public final void b() {
        this.c.e().c(m());
    }

    public final void b(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (VERSION.SDK_INT < 11) {
            Animation alphaAnimation = new AlphaAnimation(this.u, f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(0);
            this.g.clearAnimation();
            this.g.startAnimation(alphaAnimation);
        } else {
            this.g.setAlpha(f);
        }
        this.u = f;
    }

    public final void b(Animation animation) {
        this.j = animation;
    }

    public final void b(String str) {
        this.x = str;
        w();
    }

    public final void b(boolean z) {
        this.m = z;
    }

    public final void c() {
        if (this.A != null) {
            this.A.setAnimationListener(new 5(this));
            this.g.setOnTouchListener(null);
            this.g.clearAnimation();
            this.g.startAnimation(this.A);
            return;
        }
        this.f.removeView(this.g);
        this.f.removeView(this.h);
    }

    public final boolean d() {
        return this.m;
    }

    public final boolean e() {
        return (this.h == null || this.h.getParent() == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof sr) && obj.hashCode() == hashCode() && ((sr) obj).m().equals(m());
    }

    public final void f() {
        if (!e()) {
            if ((this.e.g() != null && this.e.g().a(new qy(this)) != null) || ((this.x != null && !this.x.isEmpty()) || (this.v != null && !this.v.isEmpty()))) {
                Animation animation;
                if (this.e.g() != null) {
                    View a = this.e.g().a(new qy(this));
                    if (a == null) {
                        this.h = new sq(this.d, this.x, this.v);
                    } else {
                        this.h = a;
                    }
                } else {
                    this.h = new sq(this.d, this.x, this.v);
                }
                t();
                PointF u = u();
                new StringBuilder().append(u.x).append(", ").append(u.y);
                this.f.addView(this.h, this.f.indexOfChild(this.g) + 1, new a(-2, -2, this.w, (int) u.x, (int) u.y, 81));
                if (this.i != null) {
                    animation = this.i;
                } else {
                    Animation animationSet = new AnimationSet(false);
                    animation = new ScaleAnimation(0.0f, 1.1f, 0.0f, 1.1f, 1, 0.5f, 1, 1.0f);
                    animation.setDuration(150);
                    animation.setInterpolator(new AccelerateInterpolator());
                    Animation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 1.0f);
                    scaleAnimation.setDuration(100);
                    scaleAnimation.setInterpolator(new DecelerateInterpolator());
                    scaleAnimation.setStartOffset(150);
                    animationSet.addAnimation(animation);
                    animationSet.addAnimation(scaleAnimation);
                    animation = animationSet;
                }
                this.h.startAnimation(animation);
                this.h.setOnClickListener(new 6(this));
            }
        }
    }

    public final void g() {
        if (e()) {
            Animation animation;
            this.h.clearAnimation();
            if (this.j != null) {
                animation = this.j;
            } else {
                Animation animationSet = new AnimationSet(true);
                animationSet.setInterpolator(new AccelerateInterpolator());
                animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
                animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 1.0f));
                animationSet.setDuration(100);
                animation = animationSet;
            }
            animation.setAnimationListener(new 7(this));
            this.h.startAnimation(animation);
        }
    }

    public final String h() {
        return this.x;
    }

    public final int hashCode() {
        return m().hashCode();
    }

    public final String i() {
        return this.v;
    }

    public final float j() {
        return this.t;
    }

    public final boolean k() {
        return this.s;
    }

    public final qw l() {
        return this.w;
    }

    public final String m() {
        if (this.y == null) {
            a++;
            this.y = "Marker" + a;
        }
        return this.y;
    }

    public final void n() {
        if (VERSION.SDK_INT < 11) {
            this.g.clearAnimation();
        }
        this.f.removeView(this.g);
        this.f.addView(this.g);
        v();
    }

    public final float o() {
        return this.u;
    }

    public final Object p() {
        return this.C;
    }
}
