package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.kk.a;
import com.tencent.tencentmap.mapsdk.a.kk.b;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public class kb extends ke {
    private static AtomicInteger P = new AtomicInteger(0);
    protected kk A = null;
    protected boolean B = false;
    protected int C = 0;
    protected int D = 0;
    protected float E = 0.5f;
    protected float F = 0.5f;
    public int G = 0;
    public int H = 0;
    private boolean I = false;
    private Runnable Q = new 1(this);
    private Runnable R = new Runnable() {
        public void run() {
            kb.this.e = 0.0f;
            if (kb.this.z != null) {
                kb.this.z.b();
            }
        }
    };
    private a S = new 3(this);
    private b T = new b() {
        public void a(float f) {
            kb.this.q = f;
            if (kb.this.a != null) {
                kb.this.a.a(kb.this.q);
            }
        }

        public void b(float f) {
        }
    };
    protected iy a;
    protected Bitmap b = null;
    boolean c = false;
    protected byte[] d = new byte[0];
    protected float e = 0.0f;
    protected boolean f = false;
    protected float g = 0.0f;
    protected float h = 0.0f;
    protected float i = -1.0f;
    protected String j = null;
    String k = null;
    public int l = 0;
    public int m = 0;
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
    public pb y = null;
    protected om z = null;

    public kb(ks ksVar) {
        this.w = ksVar;
        i();
    }

    public void a(pb pbVar) {
        if (pbVar != null) {
            this.y = pbVar;
            a_(pbVar.i());
            a(pbVar.n());
            b(pbVar.k());
            c(pbVar);
        }
    }

    public void b(boolean z) {
        this.B = z;
    }

    public void a(int i, int i2) {
        this.C = i;
        this.D = i2;
        if (this.a != null) {
            b(true);
            this.a.a(new GeoPoint(this.D, this.C));
        }
    }

    public void a(float f) {
        this.e = f;
    }

    protected void a(Bitmap bitmap) {
        synchronized (this.d) {
            this.j = (bitmap.hashCode() + P.getAndIncrement());
            if (this.j == null) {
                this.j = "";
            }
            if (this.a != null) {
                this.a.a(this.j, bitmap);
            }
            this.l = bitmap.getWidth();
            this.m = bitmap.getHeight();
        }
    }

    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            a(bitmap);
            e();
        }
    }

    public void e() {
        synchronized (this.d) {
            if (!(this.b == null || this.b.isRecycled())) {
                this.c = true;
            }
        }
    }

    public void f() {
        if (this.o != null) {
            this.I = true;
        }
    }

    public void a(GL10 gl10) {
        if (a()) {
            b(this.y);
            b(gl10);
            hs y = this.w.getMap().y();
            if (y != null && this.a != null) {
                this.a.b(y, this.w.getMap().s());
            }
        }
    }

    public boolean a(float f, float f2) {
        boolean z = false;
        if (!(!this.v || this.a == null || this.a == null)) {
            z = this.a.a(this.w.getMap().s(), f, f2);
            Rect b = this.a.b(this.w.getMap().s());
            if (!z || b == null) {
                this.G = -1;
                this.H = -1;
            } else {
                this.G = ((int) f) - b.left;
                this.H = ((int) f2) - b.top;
            }
        }
        return z;
    }

    public boolean a() {
        return this.N;
    }

    public void a_(boolean z) {
        this.N = z;
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
        this.w = null;
        this.n = null;
    }

    public void a(kk kkVar) {
        this.A = kkVar;
        if (this.A != null) {
            this.A.a(this.S);
            this.A.a(this.T);
        }
    }

    public boolean g() {
        if (this.A == null) {
            return false;
        }
        return this.A.a(this.n, this.p);
    }

    protected boolean b(GL10 gl10) {
        if (this.A == null) {
            return false;
        }
        this.A.c();
        if (!this.A.b()) {
            return true;
        }
        this.w.getMap().a();
        return true;
    }

    protected void h() {
    }

    public void a(om omVar) {
        this.z = omVar;
    }

    public void b(float f) {
        this.q = f;
    }

    private void i() {
        iz izVar = new iz();
        if (this.a == null) {
            this.a = new iy(izVar);
        } else {
            this.a.a(izVar);
        }
    }

    private void b(pb pbVar) {
        if (pbVar != null && this.a == null) {
            iz d = d(pbVar);
            if (d != null) {
                this.a = new iy(d);
            }
        }
    }

    private void c(pb pbVar) {
        if (pbVar != null) {
            iz d = d(pbVar);
            if (d == null) {
                return;
            }
            if (this.a == null) {
                this.a = new iy(d);
            } else {
                this.a.a(d);
            }
        }
    }

    private iz d(pb pbVar) {
        if (pbVar == null) {
            return null;
        }
        return new iz().a(pbVar.k()).a(this.E, this.F).b(false).b((int) pbVar.l()).d(this.B).a(true);
    }
}
