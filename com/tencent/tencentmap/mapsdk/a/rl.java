package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class rl {
    protected sl a;
    protected sh b;
    protected tt c;
    private a d = a.ACCELERATE_DECELERATE;
    private Handler e = new Handler();
    private Scroller f;
    private long g;
    private float h = 0.0f;
    private boolean i = false;
    private double j = 0.0d;
    private Runnable k = new 1(this);

    public enum a {
        ACCELERATE,
        DECELERATE,
        ACCELERATE_DECELERATE;

        public static a[] a() {
            return (a[]) d.clone();
        }
    }

    public rl(sl slVar, long j, tt ttVar) {
        this.a = slVar;
        this.b = slVar.c();
        this.g = j;
        this.c = ttVar;
    }

    public final void a() {
        switch (2.a[this.d.ordinal()]) {
            case 1:
                this.f = new Scroller(sl.a(), new AccelerateInterpolator());
                break;
            case 2:
                this.f = new Scroller(sl.a(), new DecelerateInterpolator());
                break;
            case 3:
                this.f = new Scroller(sl.a(), new AccelerateDecelerateInterpolator());
                break;
            default:
                this.f = new Scroller(sl.a());
                break;
        }
        c();
        this.i = true;
        this.f.startScroll(0, 0, 10000, 0, (int) this.g);
        this.e.postDelayed(this.k, 5);
        this.a.a(false, false);
    }

    protected abstract void a(float f);

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final void b() {
        if (this.i) {
            this.i = false;
            if (this.c != null) {
                this.c.b();
            }
            this.a.h().a(true);
        }
    }

    protected abstract void c();

    protected abstract void d();
}
