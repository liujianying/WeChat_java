package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class kc extends kb {
    boolean I;
    private float P;
    private float Q;
    private float R;
    private float S;
    private int T;
    private int U;
    private boolean V;
    private Bitmap W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private a aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private pb ae;
    private final byte[] af;
    private boolean ag;
    private boolean ah;
    private Bitmap ai;
    private Bitmap aj;
    private Bitmap ak;
    private int al;
    private int am;

    public kc(ks ksVar) {
        super(ksVar);
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = 0.0f;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = null;
        this.X = false;
        this.Y = true;
        this.Z = true;
        this.aa = a.a;
        this.ab = false;
        this.ac = true;
        this.ad = false;
        this.ae = null;
        this.af = new byte[0];
        this.ag = false;
        this.ah = false;
        this.al = 0;
        this.am = 0;
        this.I = a();
        this.t = true;
    }

    public void a(float f, float f2, float f3, float f4) {
        synchronized (this.af) {
            this.P = f;
            this.Q = f2;
            this.R = f3;
            this.S = f4;
            this.T = (int) Math.abs(this.Q - this.P);
            this.U = (int) Math.abs(this.S - this.R);
            synchronized (this) {
                if (this.V) {
                    this.V = false;
                }
            }
        }
    }

    public void a(pb pbVar) {
        super.a(pbVar);
        this.ae = pbVar;
    }

    public void c(boolean z) {
        this.ac = z;
    }

    public synchronized void a(boolean z, boolean z2) {
        h(true);
        if (z && z2) {
            this.V = false;
        } else {
            this.V = true;
        }
        if (this.ac) {
            if (z) {
                this.aa = a.a;
            }
            if (!this.ad) {
                this.aa = a.d;
            }
            if (z && this.A != null && this.A.b()) {
                this.A.a();
                if (this.z != null) {
                    this.z.b();
                }
            }
            if (this.aa == a.a) {
                this.aa = a.c;
                if (this.w.g != null) {
                    a(this.w.g);
                    g();
                }
            }
            if (this.aa == a.c) {
                this.aa = a.d;
                if (this.w.i != null) {
                    a(this.w.i);
                    g();
                } else {
                    e();
                    f();
                    this.ab = true;
                    this.w.getMap().a();
                }
            }
            if (this.aa == a.d) {
                this.aa = a.b;
                if (this.w.h != null) {
                    a(this.w.h);
                    g();
                }
            }
        } else {
            e();
            f();
            this.ab = true;
            this.w.getMap().a();
        }
    }

    protected void h() {
        if (this.aa == a.d) {
            e();
            f();
            this.w.getMap().a();
        }
        if (this.aa != a.b) {
            a(false, false);
            return;
        }
        this.ab = true;
        this.w.getMap().a();
    }

    public void d(boolean z) {
        this.ad = z;
    }

    public void e(boolean z) {
        this.ab = z;
    }

    public void e() {
        synchronized (this.d) {
            if (!(this.ak == null || this.ak.isRecycled())) {
                this.c = true;
            }
        }
    }

    public void b(Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.d) {
                this.b = bitmap;
            }
            synchronized (this.af) {
                if (!this.ah) {
                    a(bitmap);
                }
            }
            synchronized (this.d) {
                if (this.ab) {
                    e();
                }
            }
        }
    }

    public void a(GeoPoint geoPoint) {
        this.p = geoPoint;
    }

    public void b(GeoPoint geoPoint) {
        if (geoPoint != null) {
            if (this.o == null) {
                this.o = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            } else {
                this.o.setLatitudeE6(geoPoint.getLatitudeE6());
                this.o.setLongitudeE6(geoPoint.getLongitudeE6());
            }
            if (this.a != null) {
                this.a.a(this.o);
            }
            if (this.ab) {
                f();
            }
        }
    }

    public void i() {
        if (this.b != null) {
            this.b = null;
        }
        if (this.W != null) {
            this.W = null;
        }
        if (this.ai != null) {
            this.ai = null;
        }
        if (this.aj != null) {
            this.aj = null;
        }
        synchronized (this.d) {
            if (this.ak != null) {
                this.ak = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(boolean r3) {
        /*
        r2 = this;
        r1 = r2.af;
        monitor-enter(r1);
        r0 = r2.ag;	 Catch:{ all -> 0x002d }
        if (r0 != r3) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
    L_0x0008:
        return;
    L_0x0009:
        r2.ag = r3;	 Catch:{ all -> 0x002d }
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        r0 = r2.a;
        if (r0 == 0) goto L_0x0030;
    L_0x0010:
        r0 = r2.w;
        r0 = r0.g;
        if (r0 == 0) goto L_0x0030;
    L_0x0016:
        r0 = r2.Z;
        if (r0 != 0) goto L_0x0030;
    L_0x001a:
        r0 = new com.tencent.tencentmap.mapsdk.a.kc$1;
        r0.<init>(r2, r3);
        r2.a(r0);
        r0 = r2.w;
        r0 = r0.g;
        r2.a(r0);
        r2.g();
        goto L_0x0008;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002d }
        throw r0;
    L_0x0030:
        r0 = 0;
        r2.Z = r0;
        r2.i(r3);
        r2.j(r3);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.kc.f(boolean):void");
    }

    public void c(Bitmap bitmap) {
        if (bitmap != null) {
            synchronized (this.d) {
                this.ai = bitmap;
            }
            synchronized (this.af) {
                if (this.ah) {
                    a(bitmap);
                }
            }
            synchronized (this.d) {
                if (this.ab) {
                    e();
                }
            }
        }
    }

    public void d(Bitmap bitmap) {
        if (bitmap != null) {
            this.aj = bitmap;
        }
    }

    public boolean g(boolean z) {
        boolean z2 = this.X == z;
        this.X = z;
        if (this.X && !this.ab) {
            this.X = false;
        }
        return !z2;
    }

    public void h(boolean z) {
        this.Y = z;
        this.w.getMap().a();
    }

    public boolean j() {
        return this.Y;
    }

    public Rect a(hh hhVar) {
        Rect a;
        synchronized (this.af) {
            if (this.a != null) {
                i(false);
                k(false);
                a = this.a.a(hhVar);
                i(this.ah);
                k(this.ah);
            } else {
                a = new Rect(0, 0, 0, 0);
            }
        }
        return a;
    }

    public Rect b(hh hhVar) {
        Rect a;
        synchronized (this.af) {
            if (this.a != null) {
                i(true);
                k(true);
                a = this.a.a(hhVar);
                i(this.ah);
                k(this.ah);
            } else {
                a = new Rect(0, 0, 0, 0);
            }
        }
        return a;
    }

    public iy k() {
        return this.a;
    }

    public void b(int i, int i2) {
        this.al = i;
        this.am = i2;
        l(false);
    }

    private void j(boolean z) {
        synchronized (this.af) {
            this.ah = z;
        }
        synchronized (this.d) {
            if (z) {
                if (this.ai != null) {
                    a(this.ai);
                }
            } else if (this.b != null) {
                a(this.b);
            }
            if (this.ab) {
                e();
            }
        }
        a(this.w.h);
        g();
    }

    private void k(boolean z) {
        synchronized (this.d) {
            if (z) {
                if (this.ai != null) {
                    a(this.ai);
                }
            } else if (this.b != null) {
                a(this.b);
            }
        }
    }

    public void i(boolean z) {
        l(z);
        if (this.a != null) {
            this.a.a(this.E, this.F);
        }
    }

    private void l(boolean z) {
        int i = this.m;
        if (this.ai != null) {
            i = this.ai.getHeight();
        }
        if (i == 0) {
            i = 1;
        }
        if (z) {
            this.F = (-(((float) this.am) + 5.0f)) / ((float) i);
        } else {
            this.F = ((((float) this.al) + 5.0f) + ((float) i)) / ((float) i);
        }
    }
}
