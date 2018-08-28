package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class aa extends FrameLayout {
    private ac a = null;

    public aa(Context context, ad adVar) {
        super(context);
        setClickable(true);
        if (!isInEditMode()) {
            a(context, adVar);
        }
    }

    private void a(Context context, ad adVar) {
        setBackgroundColor(Color.rgb(222, 215, 214));
        setEnabled(true);
        this.a = new ac(this, context, adVar);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a == null || this.a.c() == null || this.a.c().i() == null) {
            return super.onTouchEvent(motionEvent);
        }
        return this.a.c().i().onTouchEvent(motionEvent);
    }

    public final ac getMap() {
        return this.a;
    }

    public void a() {
        if (this.a != null) {
            this.a.p();
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.q();
        }
    }

    public void c() {
        if (this.a != null) {
            this.a.s();
            this.a = null;
        }
    }

    public void d() {
        if (this.a != null) {
            this.a.o();
        }
    }

    public void e() {
        if (this.a != null) {
            this.a.r();
        }
    }

    public void f() {
        if (this.a != null) {
            this.a.n();
        }
    }

    public void setOnTop(boolean z) {
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }
}
