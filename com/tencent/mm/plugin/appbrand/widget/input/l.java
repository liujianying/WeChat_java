package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.z;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class l extends FrameLayout {
    private static final int fDq = g.app_brand_ui_root;
    private View gHe;
    private View gHf;
    private int gHg = -1;
    private final int[] gHh = new int[2];
    private a gHi;
    private WeakHashMap<View, b> gHj = new WeakHashMap();
    private Runnable gHk = new 1(this);
    private final Runnable gHl = new 2(this);
    public final Set<a> gHm = new HashSet();
    private boolean mInLayout = false;

    static /* synthetic */ void bX(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static l bV(View view) {
        return (l) view.getRootView().findViewById(fDq);
    }

    public static l m(Activity activity) {
        return (l) activity.findViewById(fDq);
    }

    public l(Context context, View view) {
        super(context);
        super.setId(fDq);
        this.gHf = view;
        super.addView(view);
    }

    public final void setForceHeight(int i) {
        Object obj = i != this.gHg ? 1 : null;
        this.gHg = i;
        if (obj != null && z.ai(this) && !this.mInLayout) {
            requestLayout();
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (this.gHg > 0) {
            i2 = MeasureSpec.makeMeasureSpec(this.gHg, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.gHe == null || !this.gHe.isShown()) {
                Activity cJ = j.cJ(getContext());
                if (MMActivity.class.isInstance(cJ) && ((MMActivity) cJ).mController.hideVKB()) {
                    return true;
                }
            }
            this.gHe.setVisibility(8);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar = (b) this.gHj.get(this.gHe);
        if (bVar != null && bVar.gHo && this.gHe != null && this.gHe.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.gHe.getLocationOnScreen(this.gHh);
            float f = (float) this.gHh[1];
            float height = ((float) this.gHe.getHeight()) + f;
            if (rawY < f || rawY > height) {
                this.gHe.setVisibility(8);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setId(int i) {
    }

    public final void addView(View view) {
        if (view == this.gHf || view == this.gHe) {
            super.addView(view);
        }
    }

    public final void addView(View view, int i) {
        if (view == this.gHf || view == this.gHe) {
            super.addView(view, i);
        }
    }

    public final void addView(View view, int i, int i2) {
        if (view == this.gHf || view == this.gHe) {
            super.addView(view, i, i2);
        }
    }

    public final void addView(View view, LayoutParams layoutParams) {
        if (view == this.gHf || view == this.gHe) {
            super.addView(view, layoutParams);
        }
    }

    public final void addView(View view, int i, LayoutParams layoutParams) {
        if (view == this.gHf || view == this.gHe) {
            super.addView(view, i, layoutParams);
        }
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams) {
        return false;
    }

    protected final boolean addViewInLayout(View view, int i, LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final View getCurrentBottomPanel() {
        return this.gHe;
    }

    public final void f(View view, boolean z) {
        if (this.gHe != null) {
            this.gHe.setVisibility(8);
            this.gHe = null;
        }
        if (this != view.getParent()) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.gHe = view;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
            b bVar = new b((byte) 0);
            bVar.gHo = z;
            this.gHj.put(view, bVar);
        }
    }

    public final void bW(View view) {
        f(view, false);
    }

    public final void setOnLayoutListener(a aVar) {
        this.gHi = aVar;
    }

    public final a getOnLayoutListener() {
        return this.gHi;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        if (z.ai(this)) {
            boolean z2 = false;
            int i5 = 1;
            int i6 = 0;
            for (int i7 = 0; i7 < getChildCount(); i7++) {
                View childAt = getChildAt(i7);
                if (!(childAt == null || childAt == this.gHf)) {
                    b bVar = (b) this.gHj.get(childAt);
                    if (bVar != null) {
                        if (!(z2 || bVar.gHp == 0 || childAt.getVisibility() != 0)) {
                            this.gHe = childAt;
                            post(this.gHk);
                            z2 = true;
                        }
                        int i8 = (bVar.gHp == 0 ? 1 : 0) | i6;
                        i5 &= childAt.getVisibility() != 0 ? 1 : 0;
                        bVar.gHp = childAt.getVisibility();
                        i6 = i8;
                    }
                }
            }
            if (z2 || !(i6 == 0 || i5 == 0)) {
                post(this.gHl);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.gHi != null) {
            this.gHi.bY(this);
        }
        this.mInLayout = false;
    }
}
