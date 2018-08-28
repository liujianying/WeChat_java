package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.tencent.map.lib.util.MathUtil;
import java.lang.reflect.Method;

public class hy implements OnTouchListener {
    private static final float a = ((float) Math.cos(0.0017453292780017621d));
    private boolean b;
    private boolean c;
    private int d;
    private PointF e = new PointF();
    private PointF f = new PointF();
    private PointF g = new PointF();
    private PointF h = new PointF();
    private PointF i = new PointF();
    private PointF j = new PointF();
    private PointF k = new PointF();
    private long l = 0;
    private GestureDetector m;
    private ia n;
    private gy o;
    private Method p;
    private Method q;

    public hy(Context context) {
        if (context != null) {
            this.m = new GestureDetector(context, new a(this, null));
        } else {
            this.m = new GestureDetector(new a(this, null));
        }
        this.n = new ia();
    }

    public void a(gy gyVar) {
        this.o = gyVar;
    }

    public void a(hz hzVar) {
        synchronized (this.n) {
            this.n.a(hzVar);
        }
    }

    public void b(hz hzVar) {
        synchronized (this.n) {
            this.n.b(hzVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
        r8 = this;
        r6 = 0;
        r2 = 0;
        r4 = 1;
        r0 = r10.getAction();
        r0 = r0 & 255;
        switch(r0) {
            case 0: goto L_0x0017;
            case 1: goto L_0x0042;
            case 2: goto L_0x007c;
            case 3: goto L_0x000d;
            case 4: goto L_0x000d;
            case 5: goto L_0x0029;
            case 6: goto L_0x0070;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r8.b;
        if (r0 != 0) goto L_0x0016;
    L_0x0011:
        r0 = r8.m;
        r0.onTouchEvent(r10);
    L_0x0016:
        return r4;
    L_0x0017:
        r8.l = r6;
        r8.b = r2;
        r0 = r8.n;
        r1 = r10.getX();
        r2 = r10.getY();
        r0.i(r1, r2);
        goto L_0x000d;
    L_0x0029:
        r0 = java.lang.System.currentTimeMillis();
        r8.l = r0;
        r8.d = r2;
        r8.b = r4;
        r8.c = r2;
        r0 = r8.g;
        r1 = r8.h;
        r8.a(r0, r1, r10);
        r0 = r8.n;
        r0.b();
        goto L_0x0016;
    L_0x0042:
        r0 = java.lang.System.currentTimeMillis();
        r2 = r8.l;
        r0 = r0 - r2;
        r2 = r8.d;
        if (r2 != 0) goto L_0x0062;
    L_0x004d:
        r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r2 <= 0) goto L_0x0062;
    L_0x0051:
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0062;
    L_0x0057:
        r0 = r8.c();
        if (r0 == 0) goto L_0x0062;
    L_0x005d:
        r0 = r8.n;
        r0.a();
    L_0x0062:
        r0 = r8.n;
        r1 = r10.getX();
        r2 = r10.getY();
        r0.j(r1, r2);
        goto L_0x000d;
    L_0x0070:
        r0 = r8.c;
        if (r0 != 0) goto L_0x000d;
    L_0x0074:
        r8.c = r4;
        r0 = r8.n;
        r0.c();
        goto L_0x0016;
    L_0x007c:
        r0 = r8.b;
        if (r0 == 0) goto L_0x008f;
    L_0x0080:
        r0 = r8.c;
        if (r0 != 0) goto L_0x008f;
    L_0x0084:
        r0 = r8.e;
        r1 = r8.f;
        r8.a(r0, r1, r10);
        r8.a();
        goto L_0x0016;
    L_0x008f:
        r0 = r8.n;
        r1 = r10.getX();
        r2 = r10.getY();
        r0.k(r1, r2);
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.hy.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void a() {
        double d;
        float f = this.e.x - this.g.x;
        float f2 = this.e.y - this.g.y;
        float f3 = this.f.x - this.h.x;
        float f4 = this.f.y - this.h.y;
        if (this.d == 0 || this.d == 1) {
            d = this.d == 0 ? 24.0d : 8.0d;
            if ((((double) Math.abs(f)) > d || ((double) Math.abs(f2)) > d || ((double) Math.abs(f3)) > d || ((double) Math.abs(f4)) > d) && f2 * f4 > 0.0f && ((double) Math.abs(f2)) > ((double) Math.abs(f)) * 1.2d && ((double) Math.abs(f4)) > ((double) Math.abs(f3)) * 1.2d) {
                float f5;
                this.d = 1;
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                ia iaVar = this.n;
                if (Math.abs(f2) > Math.abs(f4)) {
                    f5 = f2;
                } else {
                    f5 = f4;
                }
                iaVar.a(f5);
                return;
            }
        }
        double d2 = (double) (this.h.x - this.g.x);
        double d3 = (double) (this.h.y - this.g.y);
        double d4 = (double) (this.f.x - this.e.x);
        double d5 = (double) (this.f.y - this.e.y);
        double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        double sqrt2 = Math.sqrt((d4 * d4) + (d5 * d5));
        if ((this.d == 0 || this.d == 2) && sqrt * sqrt2 > 0.0d && Math.abs(((d2 * d4) + (d3 * d5)) / (sqrt * sqrt2)) < ((double) a)) {
            d = (180.0d * Math.acos(((d2 * d4) + (d3 * d5)) / (sqrt * sqrt2))) / 3.141592653589793d;
            if ((d2 * d5) - (d3 * d4) < 0.0d) {
                d = -d;
            }
            if (Math.abs(d) > (this.d == 0 ? 5.0d : 1.0d)) {
                this.d = 2;
                if (b()) {
                    this.k.set((float) (this.o == null ? 0 : this.o.g().width() / 2), (float) (this.o == null ? 0 : this.o.g().height() / 2));
                    this.n.a(this.k, this.k, (float) d);
                } else {
                    this.i.set((this.g.x + this.h.x) / 2.0f, (this.g.y + this.h.y) / 2.0f);
                    this.j.set((this.e.x + this.f.x) / 2.0f, (this.e.y + this.f.y) / 2.0f);
                    this.n.a(this.i, this.j, (float) d);
                }
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                return;
            }
        }
        if ((this.d == 0 || this.d == 3) && sqrt > 0.0d) {
            if (Math.abs((sqrt2 / sqrt) - 1.0d) > (this.d == 0 ? 0.05d : 0.025d)) {
                this.d = 3;
                this.i.set((this.g.x + this.h.x) / 2.0f, (this.g.y + this.h.y) / 2.0f);
                this.j.set((this.e.x + this.f.x) / 2.0f, (this.e.y + this.f.y) / 2.0f);
                this.n.a(this.i, this.j, sqrt, sqrt2);
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
                return;
            }
        }
        if (this.d == 0 || this.d == 4) {
            d = this.d == 0 ? 80.0d : 8.0d;
            if (((double) Math.abs(f)) > d || ((double) Math.abs(f2)) > d || ((double) Math.abs(f3)) > d || ((double) Math.abs(f4)) > d) {
                this.d = 4;
                this.n.d((f + f3) / 2.0f, (f2 + f4) / 2.0f);
                this.g.set(this.e.x, this.e.y);
                this.h.set(this.f.x, this.f.y);
            }
        }
    }

    private boolean b() {
        PointF poiWith2Line = MathUtil.getPoiWith2Line(this.h, this.g, this.f, this.e);
        if (poiWith2Line == null) {
            return false;
        }
        return a(poiWith2Line.x, poiWith2Line.y);
    }

    private boolean a(float f, float f2) {
        float f3 = 0.0f;
        int width = this.o == null ? 0 : this.o.g().width() / 2;
        int height = this.o == null ? 0 : this.o.g().height() / 2;
        float width2 = this.o == null ? 0.0f : ((float) this.o.g().width()) / 3.0f;
        if (this.o != null) {
            f3 = ((float) this.o.g().height()) / 3.0f;
        }
        if (Math.abs(f - ((float) width)) >= width2 || Math.abs(f2 - ((float) height)) >= f3) {
            return false;
        }
        return true;
    }

    private boolean b(float f, float f2) {
        return a(f, f2);
    }

    private boolean c() {
        double d = (double) (this.g.x - this.h.x);
        double d2 = (double) (this.g.y - this.h.y);
        return (d * d) + (d2 * d2) > 2500.0d;
    }

    private void a(PointF pointF, PointF pointF2, MotionEvent motionEvent) {
        try {
            if (this.p == null) {
                this.p = d();
                this.q = e();
            }
            float floatValue = ((Float) this.p.invoke(motionEvent, new Object[]{Integer.valueOf(0)})).floatValue();
            float floatValue2 = ((Float) this.p.invoke(motionEvent, new Object[]{Integer.valueOf(1)})).floatValue();
            float floatValue3 = ((Float) this.q.invoke(motionEvent, new Object[]{Integer.valueOf(0)})).floatValue();
            float floatValue4 = ((Float) this.q.invoke(motionEvent, new Object[]{Integer.valueOf(1)})).floatValue();
            pointF.set(floatValue, floatValue3);
            pointF2.set(floatValue2, floatValue4);
        } catch (Exception e) {
        }
    }

    private Method d() {
        return MotionEvent.class.getMethod("getX", new Class[]{Integer.TYPE});
    }

    private Method e() {
        return MotionEvent.class.getMethod("getY", new Class[]{Integer.TYPE});
    }
}
