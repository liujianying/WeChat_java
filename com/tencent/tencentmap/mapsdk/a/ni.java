package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tencentmap.mapsdk.a.ld.b;
import java.util.ArrayList;
import java.util.List;

public class ni extends oh implements lh$a, mq {
    public Handler a = new 1(this, Looper.getMainLooper());
    private ViewGroup b = null;
    private ks c = null;
    private lj d;
    private lg e;
    private le f;
    private lc g;
    private int h;
    private List<ld> i = new ArrayList();
    private boolean j = false;

    public ni(ViewGroup viewGroup, View view) {
        this.b = viewGroup;
        this.c = (ks) view;
        if (this.b.indexOfChild(this.c) < 0) {
            this.b.addView(this.c, 0, new LayoutParams(-1, -1));
            this.b.requestLayout();
        }
        int i = 4;
        int i2 = 20;
        if (this.c.getMap() != null) {
            i = this.c.getMap().b();
            i2 = ne.a(this.c.getMap().c());
        }
        this.e = new lg(this.b.getContext(), i, i2, this.c.getWorldMapConfig());
        this.c.setLogoAndScaleManager(this.e);
        this.f = new le(this.b.getContext(), (aa) this.b);
        this.c.setIndoorFloorControlManager(this.f);
        this.d = new lj(this.b.getContext(), this.c);
        this.i.add(this.e);
        this.i.add(this.d);
        this.c.setMapEventHandler(this);
        this.c.a(this);
    }

    public void a() {
        this.b.removeAllViews();
        if (this.c != null) {
            this.c.setMapEventHandler(null);
        }
        this.c = null;
        this.b = null;
        for (ld a : this.i) {
            a.a();
        }
        this.d = null;
        this.d = null;
        this.i.clear();
        this.i = null;
    }

    public void a(a aVar) {
        if (this.d != null) {
            this.d.a(aVar);
        }
    }

    void a(boolean z) {
        this.d.a(z);
    }

    void b(boolean z) {
        this.c.setScrollGestureEnable(z);
    }

    void c(boolean z) {
        this.c.setZoomGestureEnable(z);
    }

    void d(boolean z) {
        this.c.setSkewGestureEnable(z);
    }

    void e(boolean z) {
        this.c.setRotateGestureEnable(z);
    }

    void f(boolean z) {
        this.c.setAllGestureEnable(z);
        b(z);
        c(z);
        d(z);
        e(z);
    }

    boolean b() {
        return this.c.k();
    }

    boolean c() {
        return this.c.l();
    }

    public void a(int i, int i2) {
        this.h = i2;
        for (ld ldVar : this.i) {
            ldVar.a(i, i2);
            ldVar.a(this.b);
        }
    }

    private void e() {
        for (ld a : this.i) {
            a.a(this.b);
        }
    }

    void g(boolean z) {
        if (this.e != null) {
            this.e.a(z);
        }
    }

    boolean d() {
        if (this.e != null) {
            return this.e.b();
        }
        return false;
    }

    void a(int i) {
        if (this.e != null) {
            this.e.a(b.a(i));
            e();
        }
    }

    void b(int i) {
        if (this.e != null) {
            this.e.b(b.a(i));
            e();
        }
    }

    public void a(lh lhVar) {
        if (lhVar != null && lhVar.a != -1) {
            this.a.sendMessage(this.a.obtainMessage(lhVar.a, lhVar));
        }
    }
}
