package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.ac.l;
import com.tencent.tencentmap.mapsdk.a.kk.b;
import javax.microedition.khronos.opengles.GL10;

public class kd extends ke {
    private int A = 0;
    private int B = 0;
    private boolean C = false;
    private GeoPoint D = null;
    private iy E;
    private om F = null;
    private kk G = null;
    private l H;
    private Runnable I = new 1(this);
    private Runnable P = new Runnable() {
        public void run() {
            try {
                if (kd.this.F != null) {
                    kd.this.F.b();
                }
            } catch (NullPointerException e) {
            }
        }
    };
    private b Q = new 3(this);
    protected Bitmap a = null;
    boolean b = false;
    protected byte[] c = new byte[0];
    float d = 0.5f;
    float e = 0.5f;
    protected float f = 0.0f;
    protected boolean g = false;
    protected float h = 0.0f;
    protected float i = 0.0f;
    protected float j = -1.0f;
    protected pb k = null;
    protected String l = null;
    String m = null;
    protected GeoPoint n = null;
    protected GeoPoint o = null;
    protected GeoPoint p = null;
    protected float q = 1.0f;
    protected float r = 1.0f;
    protected float s = 1.0f;
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;
    protected ks w = null;
    public pa x = null;
    private boolean y = false;
    private boolean z = false;

    public kd(ks ksVar) {
        this.w = ksVar;
    }

    public pb e() {
        return this.k;
    }

    public void a(pb pbVar) {
        if (pbVar != null) {
            this.k = pbVar;
            a(kh.a(pbVar.b()));
            b(pbVar.f(), pbVar.g());
            a_(pbVar.i());
            a(pbVar.n());
            a(pbVar.e());
            b(pbVar.k());
            c(pbVar.l());
            b(pbVar);
        }
    }

    public void a(on onVar) {
        if (onVar != null) {
            no a = onVar.a();
            if (a != null) {
                Bitmap a2 = a.a(this.w.getContext());
                a(a.a());
                b(a2);
            }
        }
    }

    public void a(GeoPoint geoPoint) {
        if (geoPoint != null) {
            if (this.n == null) {
                this.n = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            } else {
                this.n.setLatitudeE6(geoPoint.getLatitudeE6());
                this.n.setLongitudeE6(geoPoint.getLongitudeE6());
            }
            this.y = true;
            if (this.E != null) {
                this.E.a(this.n);
            }
        }
    }

    protected void f() {
        if (this.u) {
            a(this.w.getNaviCenter());
        }
    }

    public GeoPoint g() {
        return this.n;
    }

    public void a(float f) {
        this.f = f;
        if (this.E != null) {
            this.E.a((int) this.f);
        }
    }

    public void b(float f, float f2) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.d = f;
        this.e = f2;
        if (this.E != null) {
            this.E.a(this.d, this.e);
        }
    }

    private void a(String str) {
        synchronized (this.c) {
            this.l = str;
        }
    }

    protected void a(Bitmap bitmap) {
        synchronized (this.c) {
            this.a = bitmap;
            if (this.l == null) {
                this.l = bitmap.toString();
            }
            if (this.E != null) {
                this.E.a(this.l, this.a);
            }
        }
    }

    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            a(bitmap);
            h();
        }
    }

    public void h() {
        synchronized (this.c) {
            if (!(this.a == null || this.a.isRecycled())) {
                this.b = true;
            }
        }
    }

    public void a(GL10 gl10) {
        if (a()) {
            f();
            b(gl10);
            hs y = this.w.getMap().y();
            if (y != null && this.E != null) {
                this.E.b(y, this.w.getMap().s());
                return;
            }
            return;
        }
        b();
    }

    public boolean a(float f, float f2) {
        boolean z = false;
        if (this.v && this.E != null) {
            z = this.E.a(this.w.getMap().s(), f, f2);
            if (z && this.H != null) {
                this.H.a(this.x);
            }
        }
        return z;
    }

    public float i() {
        if (this.E != null) {
            return this.E.f();
        }
        return 0.0f;
    }

    public float j() {
        if (this.E != null) {
            return this.E.g();
        }
        return 0.0f;
    }

    public float k() {
        if (this.E != null) {
            return this.E.h();
        }
        return 0.0f;
    }

    public float l() {
        if (this.E != null) {
            return this.E.i();
        }
        return 0.0f;
    }

    public boolean a() {
        return this.N;
    }

    public void a_(boolean z) {
        this.N = z;
        if (this.E != null) {
            this.E.a(z);
        }
        this.w.getMap().a();
    }

    public void b() {
        if (this.E != null) {
            this.E.j();
        }
    }

    public void c() {
    }

    public void d() {
        this.w = null;
        this.n = null;
        if (this.E != null) {
            this.E.j();
        }
    }

    public Rect m() {
        if (this.E != null) {
            return this.E.a(this.w.getMap().s());
        }
        return null;
    }

    protected boolean b(GL10 gl10) {
        if (this.G == null) {
            return false;
        }
        this.G.c();
        this.C = this.G.b();
        if (!this.C) {
            return true;
        }
        this.w.getMap().a();
        return true;
    }

    public void b(float f) {
        this.q = f;
        if (this.E != null) {
            this.E.a(f);
        }
    }

    public void c(float f) {
        this.M = f;
        if (this.E != null) {
            this.E.b((int) f);
        }
    }

    public float n() {
        return this.f;
    }

    public void b(boolean z) {
        this.z = z;
        if (this.E != null) {
            this.E.b(z);
        }
    }

    public boolean o() {
        return this.z;
    }

    public Point p() {
        return new Point(this.A, this.B);
    }

    public int c(boolean z) {
        if (this.a == null || this.E == null) {
            return 0;
        }
        int height = this.a.getHeight();
        if (z) {
            return (int) (((float) height) * (1.0f - this.E.b()));
        }
        return (int) (((float) height) * this.E.b());
    }

    public boolean q() {
        return true;
    }

    public boolean r() {
        return this.C;
    }

    public boolean s() {
        return this.E != null;
    }

    public iy t() {
        return this.E;
    }

    private void b(pb pbVar) {
        if (pbVar != null && this.E == null) {
            iz a = new iz().a(kh.a(pbVar.b())).a(pbVar.k()).a(pbVar.f(), pbVar.g());
            String str = Math.random();
            try {
                str = pbVar.e().a().a();
            } catch (NullPointerException e) {
            }
            iz e2 = a.a(str, new Bitmap[]{pbVar.e().a(this.w.getContext())}).a((int) pbVar.n()).b(pbVar.m()).b((int) pbVar.l()).d(this.z).c(pbVar.a()).e(pbVar.q());
            if (this.E == null) {
                this.E = new iy(e2);
            } else {
                this.E.a(e2);
            }
        }
    }
}
