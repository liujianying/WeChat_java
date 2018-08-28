package com.tencent.map.lib.gl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.lib.d;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.tencentmap.mapsdk.a.gv;
import com.tencent.tencentmap.mapsdk.a.if;
import java.util.Arrays;
import java.util.Hashtable;

public class JNICallback {
    public i a = null;
    private if b;
    private a c;
    private h d;
    private e e;
    private d f;
    private j g;
    private b h;
    private c i;
    private k j;
    private g k;
    private f l;
    private Hashtable<Long, Paint> m = new Hashtable();
    private Hashtable<Long, PointF> n = new Hashtable();
    private Bitmap o = null;

    public JNICallback(if ifVar, a aVar, h hVar, e eVar, g gVar) {
        this.b = ifVar;
        this.c = aVar;
        this.d = hVar;
        this.e = eVar;
        this.k = gVar;
        this.o = Bitmap.createBitmap(800, SystemUtil.SMALL_SCREEN_THRESHOLD, Config.ALPHA_8);
        this.a = new i(null);
    }

    public void a() {
        this.o = null;
        this.a = null;
        if (this.m != null) {
            this.m.clear();
            this.m = null;
        }
        if (this.n != null) {
            this.n.clear();
            this.n = null;
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = null;
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void a(c cVar) {
        this.i = cVar;
    }

    public void a(j jVar) {
        this.g = jVar;
    }

    public void a(k kVar) {
        this.j = kVar;
    }

    public void a(f fVar) {
        this.l = fVar;
    }

    public Object a(int i, int i2, String str, byte[] bArr) {
        boolean z = false;
        switch (i) {
            case 1:
                return a(i2, str, bArr);
            case 2:
                return a(str, i2);
            case 3:
                a(str);
                return null;
            case 4:
                return a(i2, bArr);
            case 5:
                a(str, bArr);
                return null;
            case 6:
                if (this.d != null) {
                    this.d.f(i2);
                    return null;
                }
                break;
            case 7:
                gv.a().a(str);
                return null;
            case 8:
                if (this.e != null) {
                    this.e.z();
                    return null;
                }
                break;
            case 9:
                if (this.f != null) {
                    return this.f.a(bArr);
                }
                break;
            case 10:
                if (this.k != null) {
                    g gVar = this.k;
                    if (i2 > 0) {
                        z = true;
                    }
                    gVar.b(z);
                    return null;
                }
                break;
            case 11:
                if (this.g != null) {
                    return this.g.a(bArr);
                }
                break;
            case 12:
                if (this.j != null) {
                    this.j.a(str, Arrays.copyOfRange(bArr, 0, 12), Arrays.copyOfRange(bArr, 12, bArr.length));
                    break;
                }
                break;
            case 13:
                if (this.h != null) {
                    return this.h.a(bArr);
                }
                break;
            case 14:
                if (this.i != null) {
                    this.i.a(str, Arrays.copyOfRange(bArr, 0, 12), Arrays.copyOfRange(bArr, 12, bArr.length));
                    return null;
                }
                break;
        }
        return null;
    }

    public int b() {
        if (this.l != null) {
            return this.l.getGLContext();
        }
        return 0;
    }

    private Paint c() {
        if (this.m == null) {
            return null;
        }
        return (Paint) this.m.get(Long.valueOf(Thread.currentThread().getId()));
    }

    private void a(Paint paint) {
        if (this.m != null) {
            this.m.put(Long.valueOf(Thread.currentThread().getId()), paint);
        }
    }

    private PointF d() {
        if (this.n == null) {
            return null;
        }
        return (PointF) this.n.get(Long.valueOf(Thread.currentThread().getId()));
    }

    private void a(PointF pointF) {
        if (this.n != null) {
            this.n.put(Long.valueOf(Thread.currentThread().getId()), pointF);
        }
    }

    private Paint a(int i) {
        Paint c = c();
        if (c == null) {
            c = new Paint();
            c.setTypeface(Typeface.DEFAULT);
            c.setAntiAlias(true);
            c.setStyle(Style.FILL);
            c.setTextAlign(Align.CENTER);
            c.setLinearText(true);
            a(c);
        }
        c.setTextAlign(Align.CENTER);
        c.setTextSize((float) i);
        return c;
    }

    private Bitmap a(int i, String str, byte[] bArr) {
        if (this.o == null) {
            this.o = Bitmap.createBitmap(800, SystemUtil.SMALL_SCREEN_THRESHOLD, Config.ALPHA_8);
        }
        if (this.o == null) {
            return null;
        }
        this.a.a(bArr);
        Paint a = a(i);
        this.o.eraseColor(0);
        Canvas canvas = new Canvas(this.o);
        float descent = 200.0f - ((a.descent() + a.ascent()) / 2.0f);
        a.setFakeBoldText(this.a.e);
        canvas.drawText(str, 400.0f, descent, a);
        return this.o;
    }

    private PointF a(String str, int i) {
        float measureText = 1.0f + a(i).measureText(str);
        int i2 = i + 2;
        PointF d = d();
        if (d == null) {
            d = new PointF();
            a(d);
        }
        d.x = measureText;
        d.y = (float) i2;
        return d;
    }

    private IconImageInfo a(int i, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            String str = new String(bArr);
            if (i == 1) {
                return this.b.a(str);
            }
            return this.b.b(str);
        } catch (Exception e) {
            return null;
        }
    }

    private void a(String str) {
        if (this.c != null) {
            d.a("Engine callback download:" + str);
            this.c.c(str);
        }
    }

    private void a(String str, byte[] bArr) {
        if (bArr != null) {
            new 1(this, str, bArr).execute(new Void[0]);
        }
    }
}
