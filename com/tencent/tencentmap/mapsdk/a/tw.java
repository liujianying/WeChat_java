package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

public class tw extends FrameLayout {
    private sl a;
    private sm b;
    private ty c;
    private tz d;
    private ub e;
    private Surface f;
    @Deprecated
    private tv g;

    public tw(Context context, ua uaVar) {
        super(context);
        a(uaVar);
    }

    private void a(View view, int i, int i2, float f, float f2, int i3) {
        int i4 = i3 & 7;
        int i5 = i3 & 112;
        if (i4 == 5) {
            f -= (float) i;
        } else if (i4 == 1) {
            f -= (float) (i / 2);
        }
        if (i5 == 80) {
            f2 -= (float) i2;
        } else if (i5 == 16) {
            f2 -= (float) (i2 / 2);
        }
        i4 = Math.round(f);
        i5 = Math.round(f2);
        view.layout(i4, i5, i4 + i, i5 + i2);
    }

    private void a(View view, int i, int i2, int[] iArr) {
        if (view instanceof ListView) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                iArr[0] = view2.getWidth();
                iArr[1] = view2.getHeight();
            }
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void a(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        a(view, iArr[0], iArr[1], (float) a.a(aVar), (float) a.b(aVar), a.c(aVar));
    }

    private void a(ua uaVar) {
        h();
        Context context = getContext();
        this.a = new sl(this);
        if (uaVar != null) {
            this.f = uaVar.a();
        }
        this.b = this.a.h();
        setOnKeyListener(this.b);
        this.c = new ty(this.a);
        this.e = new ub(this.a.f());
        this.d = new tz(this.a);
        this.g = new tv(this);
        if (uaVar != null) {
            this.a.g(uaVar.b());
        }
        if (context instanceof tu) {
            ((tu) context).a(this);
        }
        setBackgroundColor(-657936);
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                a(childAt);
            }
        }
    }

    private void b(View view, a aVar) {
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        if (aVar.a() != null) {
            PointF a = this.a.b().a(aVar.a());
            if (a != null) {
                a.x += (float) a.a(aVar);
                a.y += (float) a.b(aVar);
                a(view, iArr[0], iArr[1], a.x, a.y, a.c(aVar));
            }
        }
    }

    private void h() {
        Editor edit = getContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString("4e7cb4aa49", "1.2.6");
        edit.commit();
    }

    public void a() {
    }

    public void a(Bundle bundle) {
        this.a.a(bundle);
    }

    public void a(View view) {
        if (this != view.getParent()) {
            return;
        }
        if (view.getLayoutParams() instanceof a) {
            a aVar = (a) view.getLayoutParams();
            if (aVar.a == 0) {
                b(view, aVar);
                return;
            } else {
                a(view, aVar);
                return;
            }
        }
        a(view, new a(view.getLayoutParams()));
    }

    public void b() {
        sl.n();
    }

    public void b(Bundle bundle) {
        this.a.b(bundle);
    }

    public void c() {
    }

    public void computeScroll() {
        super.computeScroll();
        this.b.a();
    }

    public void d() {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        setClickable(false);
        this.b.b(MotionEvent.obtain(motionEvent));
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent) || this.b.a(motionEvent);
    }

    public void draw(Canvas canvas) {
        if (this.f != null) {
            Canvas lockCanvas = this.f.lockCanvas(null);
            super.draw(lockCanvas);
            this.f.unlockCanvasAndPost(lockCanvas);
            return;
        }
        super.draw(canvas);
    }

    public void e() {
        this.a.m();
    }

    public void f() {
        a(false, 0, 0, 0, 0);
    }

    public void g() {
        clearAnimation();
        this.a.c().clearAnimation();
        this.b.b();
    }

    public tv getController() {
        return this.g;
    }

    public int getLatitudeSpan() {
        return this.c.b();
    }

    public int getLongitudeSpan() {
        return this.c.c();
    }

    public tz getMap() {
        return this.d;
    }

    public qw getMapCenter() {
        return this.d.c();
    }

    protected sl getMapContext() {
        return this.a;
    }

    public tv getMapController() {
        return this.g;
    }

    public int getMaxZoomLevel() {
        return this.d.e();
    }

    public int getMinZoomLevel() {
        return this.d.f();
    }

    public ty getProjection() {
        return this.c;
    }

    public float getScalePerPixel() {
        return this.c.d();
    }

    public ub getUiSettings() {
        return this.e;
    }

    public final String getVersion() {
        return this.d.g();
    }

    public int getZoomLevel() {
        return this.d.d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a(z, i, i2, i3, i4);
    }

    public void setLogoPosition(int i) {
        this.e.a(i);
    }

    public void setPinchEnabeled(boolean z) {
        this.e.d(z);
    }

    public void setSatellite(boolean z) {
        this.d.a(z);
    }

    public void setScalControlsEnable(boolean z) {
        this.e.b(z);
    }

    public void setScaleControlsEnable(boolean z) {
        this.e.b(z);
    }

    public void setScaleViewPosition(int i) {
        this.e.b(i);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.e.c(z);
    }
}
