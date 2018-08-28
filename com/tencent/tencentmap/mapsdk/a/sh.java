package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import com.tencent.tencentmap.mapsdk.a.rl.a;
import com.tencent.tencentmap.mapsdk.a.tz.f;
import java.util.List;
import java.util.Vector;

public final class sh extends View {
    private sl a;
    private si b;
    private boolean c = false;
    private volatile boolean d = false;
    private List<Runnable> e = new Vector();
    private rs f;
    private ru g = null;
    private PointF h = null;
    private f i;
    private final Handler j = new 1(this);
    private rn k;
    private rm l;

    public sh(sl slVar) {
        super(sl.a());
        this.a = slVar;
        this.b = slVar.b();
        this.f = new rs(10.0d);
        if (slVar.f().a() >= 3 && slVar.f().b() > 1.0f) {
            this.f.a(1.3d);
        }
        this.g = rv.a(new qw(39.91669d, 116.39716d));
        this.h = new PointF((float) (getWidth() / 2), (float) (getHeight() / 2));
        sz.a(this, 2);
    }

    private ru a(int i, int i2) {
        return new ru(this.g.b() + (((double) i) * this.f.d()), this.g.a() - (((double) i2) * this.f.d()));
    }

    private void a(rs rsVar, PointF pointF) {
        double width = ((double) getWidth()) / 2.0d;
        double height = ((double) getHeight()) / 2.0d;
        double a = this.g.a() - (((((double) pointF.y) - height) * this.f.d()) + ((height - ((double) pointF.y)) * rsVar.d()));
        this.g.b(this.g.b() + (((((double) pointF.x) - width) * this.f.d()) + ((width - ((double) pointF.x)) * rsVar.d())));
        this.g.a(a);
        this.h.x = (float) ((int) width);
        this.h.y = (float) ((int) height);
        this.f.b(rsVar.c());
        this.b.a(this.g);
        this.a.a(false, false);
    }

    private void b(double d, PointF pointF, boolean z, long j, tt ttVar) {
        a(d, pointF, z, j, a.c, ttVar);
    }

    private PointF e() {
        return new PointF((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public final PointF a() {
        return this.h;
    }

    public final void a(double d, PointF pointF) {
        a(this.b.a(new rs(this.f.a(), this.f.b() * d)), pointF);
    }

    public final void a(double d, PointF pointF, boolean z, long j, a aVar, tt ttVar) {
        if (z) {
            if (this.k != null) {
                this.k.b();
            }
            this.k = new rn(this.a, d, pointF, j, ttVar);
            this.k.a(aVar);
            this.k.a();
            return;
        }
        a(this.b.a(new rs(d)), pointF);
        if (ttVar != null) {
            ttVar.a();
        }
    }

    public final void a(double d, PointF pointF, boolean z, long j, tt ttVar) {
        b(d, pointF, false, 0, null);
    }

    public final void a(double d, PointF pointF, boolean z, tt ttVar) {
        b(this.f.c() + d, pointF, z, 500, ttVar);
    }

    public final void a(double d, boolean z, tt ttVar) {
        b(this.f.c() + d, e(), z, 500, ttVar);
    }

    public final void a(int i, int i2, long j, tt ttVar) {
        a(a(i, i2), j, ttVar);
    }

    public final void a(PointF pointF, boolean z, tt ttVar) {
        b(1.0d + this.f.c(), pointF, true, 500, null);
    }

    public final void a(ru ruVar) {
        this.g = ruVar;
        this.b.a(this.g);
        this.a.a(false, false);
    }

    public final void a(ru ruVar, long j, tt ttVar) {
        if (this.l != null) {
            this.l.b();
        }
        this.l = new rm(this.a, ruVar, j, ttVar);
        this.l.a();
    }

    public final void a(rw rwVar) {
        if (this.d || !rwVar.a()) {
            rwVar.a(this.a);
        } else {
            this.e.add(new 2(this, rwVar));
        }
    }

    public final void a(f fVar) {
        this.i = fVar;
    }

    public final void a(boolean z) {
        this.c = true;
    }

    public final void a(boolean z, tt ttVar) {
        b(1.0d + this.f.c(), e(), z, 500, ttVar);
    }

    public final ru b() {
        return this.g;
    }

    public final void b(double d, boolean z, tt ttVar) {
        b(d, e(), z, 500, ttVar);
    }

    public final void b(ru ruVar) {
        a(ruVar);
    }

    public final void b(boolean z, tt ttVar) {
        b(this.f.c() - 1.0d, e(), z, 500, ttVar);
    }

    public final double c() {
        return this.f.c();
    }

    public final void clearAnimation() {
        super.clearAnimation();
        if (this.l != null) {
            this.l.b();
        }
        if (this.k != null) {
            this.k.b();
        }
    }

    public final rs d() {
        return this.f;
    }

    public final void draw(Canvas canvas) {
        if (!this.d) {
            this.j.sendEmptyMessage(11);
            this.d = true;
        }
        if (VERSION.SDK_INT > 10) {
            canvas.isHardwareAccelerated();
        }
        boolean a = this.a.g().a(canvas);
        this.a.e().a(canvas);
        if (!sl.p()) {
            Paint paint = new Paint();
            paint.setColor(-65536);
            paint.setTextSize(50.0f);
            Rect rect = new Rect();
            String str = "鉴权失败，请到腾讯";
            String str2 = "地图官网申请密钥";
            int width = getWidth();
            int height = getHeight();
            paint.getTextBounds(str, 0, str.length(), rect);
            canvas.drawText(str, (float) ((width / 2) - (rect.width() / 2)), (float) ((height / 2) - rect.height()), paint);
            paint.getTextBounds(str2, 0, str2.length(), rect);
            canvas.drawText(str2, (float) ((width / 2) - (rect.width() / 2)), (float) ((height / 2) + 2), paint);
        }
        this.a.d(a);
        if (this.c && a) {
            this.c = false;
            this.j.sendEmptyMessage(16);
        }
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.b.g() == 0.0d || this.b.h() == 0.0d)) {
            this.b.b(this.b.g(), this.b.h());
            this.b.a(0);
            this.b.b(0);
        }
        this.h = new PointF((float) (getWidth() / 2), (float) (getHeight() / 2));
        int i5 = rs.a;
        while (256.0d * Math.pow(2.0d, (double) i5) < ((double) Math.max(getWidth(), getHeight()))) {
            i5++;
        }
        rs.a = i5;
        if (this.b.j().a() < rs.a) {
            this.b.c(rs.a);
        }
        this.a.a(false, false);
    }

    public final void scrollBy(int i, int i2) {
        a(a(i, i2));
    }
}
