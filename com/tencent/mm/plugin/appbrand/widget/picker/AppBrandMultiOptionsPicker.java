package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.b;

public final class AppBrandMultiOptionsPicker extends FrameLayout implements e<int[]> {
    private boolean Re;
    private boolean Rf;
    private final Drawable gMU;
    public LinearLayout gMV;
    private d gMW;
    public final b gMX = new 1(this);

    public final /* synthetic */ Object aqq() {
        int i = 0;
        int pickersCount = getPickersCount();
        if (pickersCount <= 0) {
            return new int[0];
        }
        Object obj = new int[pickersCount];
        while (i < pickersCount) {
            obj[i] = ml(i).getValue();
            i++;
        }
        return obj;
    }

    @Keep
    public AppBrandMultiOptionsPicker(Context context) {
        super(context);
        this.gMU = context.getResources().getDrawable(f.app_brand_multi_options_picker_column_divider);
        this.gMV = new LinearLayout(context);
        this.gMV.setPadding(a.fromDPToPix(context, 2), 0, a.fromDPToPix(context, 2), 0);
        this.gMV.setOrientation(0);
        addView(this.gMV, new LayoutParams(-1, -1, 17));
        this.gMV.setDividerDrawable(this.gMU);
        this.gMV.setShowDividers(2);
    }

    public final void setLayoutFrozen(boolean z) {
        if (this.Rf != z) {
            this.Rf = z;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            } else if (this.Re) {
                requestLayout();
            }
        }
    }

    public final void requestLayout() {
        if (this.Rf) {
            this.Re = true;
        } else {
            super.requestLayout();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Rf) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Rf) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final c ml(int i) {
        if (i >= 0 && this.gMV != null) {
            return (c) this.gMV.getChildAt(i);
        }
        return null;
    }

    public final int getPickersCount() {
        return this.gMV == null ? 0 : this.gMV.getChildCount();
    }

    public final void mm(int i) {
        if (i > 0) {
            int pickersCount = getPickersCount() - 1;
            while (i > 0) {
                this.gMV.removeViewAt(pickersCount);
                pickersCount--;
                i--;
            }
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
        this.gMW = dVar;
    }

    public final void aqo() {
        int pickersCount = getPickersCount();
        for (int i = 0; i < pickersCount; i++) {
            c ml = ml(i);
            if (ml != null) {
                ml.aqA();
            }
        }
    }

    public final void b(d dVar) {
        this.gMW = dVar;
    }

    public final void aqp() {
        this.gMW = null;
    }
}
