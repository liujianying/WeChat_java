package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class MMFlipper extends ViewGroup {
    private VelocityTracker cE;
    private Interpolator cp;
    private int fW;
    private int ttn;
    protected int ttp;
    protected int ttq;
    private boolean tts;
    protected int tuh;
    private int tui;
    private boolean tuj;
    private b tuk;
    private a tul;
    int tum;
    int tun;
    private Scroller wf;
    private float ww;
    private float wx;

    public MMFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public MMFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tui = 0;
        this.ttn = 0;
        this.tuj = false;
        this.tts = true;
        this.tum = -123454321;
        this.tun = -123454321;
        init(context);
    }

    protected Interpolator getInterpolator() {
        return new c();
    }

    private void init(Context context) {
        this.cp = getInterpolator();
        this.wf = new Scroller(context, this.cp);
        this.ttq = -1;
        int i = this.tui;
        this.ttp = i;
        this.tuh = i;
        this.fW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        long VG = bi.VG();
        int i5 = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                x.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:" + measuredWidth);
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
        x.v("MicroMsg.MMFlipper", "use " + bi.bI(VG) + " ms, flipper onLayout changed:" + z + " Left,Top,Right,Bottom:" + i + "," + i2 + "," + i3 + "," + i4);
    }

    protected void onMeasure(int i, int i2) {
        long VG = bi.VG();
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (this.tul != null) {
            this.tul.dp(size, size2);
        }
        this.tum = size;
        this.tun = size2;
        int childCount = getChildCount();
        for (size2 = 0; size2 < childCount; size2++) {
            getChildAt(size2).measure(i, i2);
        }
        scrollTo(this.ttp * size, 0);
        x.v("MicroMsg.MMFlipper", "flipper onMeasure:" + size + "," + MeasureSpec.getSize(i2) + " childCount:" + childCount + ", use " + bi.bI(VG));
    }

    public void setOnMeasureListener(a aVar) {
        this.tul = aVar;
    }

    public void setOnScreenChangedListener(b bVar) {
        this.tuk = bVar;
    }

    private void Ei(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (getWidth() * max) - getScrollX();
            this.wf.startScroll(getScrollX(), 0, width, 0, a.ag(getContext(), (int) (((float) Math.abs(width)) * 1.3f)));
            if (this.ttp != max) {
                this.tuj = true;
                this.tuh += max - this.ttp;
            }
            this.ttq = this.ttp;
            this.ttp = max;
            invalidate();
        }
    }

    public final void El(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.tuj = false;
        if (!this.wf.isFinished()) {
            this.wf.abortAnimation();
        }
        this.ttq = this.ttp;
        this.ttp = max;
        scrollTo(max * getWidth(), 0);
    }

    public final void Em(int i) {
        this.tuh = i;
    }

    public void setToScreen(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        this.tuj = false;
        if (!this.wf.isFinished()) {
            this.wf.abortAnimation();
        }
        if (this.tuk != null) {
            this.tuk.vC(max);
        }
        this.ttq = this.ttp;
        this.ttp = max;
        this.tuh = max;
        scrollTo(max * getWidth(), 0);
    }

    public int getCurScreen() {
        x.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[]{Integer.valueOf(this.ttp)});
        return this.ttp;
    }

    public void computeScroll() {
        this.wf.getCurrX();
        if (this.wf.computeScrollOffset()) {
            scrollTo(this.wf.getCurrX(), this.wf.getCurrY());
            postInvalidate();
        } else if (this.tuj) {
            this.tuj = false;
            if (this.tuk != null) {
                this.tuk.vC(this.tuh);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 1) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        motionEvent.getY();
        switch (action) {
            case 0:
                if (!this.wf.isFinished()) {
                    this.wf.abortAnimation();
                }
                this.ww = x;
                return true;
            case 1:
            case 3:
                VelocityTracker velocityTracker = this.cE;
                velocityTracker.computeCurrentVelocity(1000);
                action = (int) velocityTracker.getXVelocity();
                if (action > 600 && this.ttp > 0) {
                    Ei(this.ttp - 1);
                } else if (action >= -600 || this.ttp >= getChildCount() - 1) {
                    action = getWidth();
                    Ei((getScrollX() + (action / 2)) / action);
                } else {
                    Ei(this.ttp + 1);
                }
                if (this.cE != null) {
                    this.cE.recycle();
                    this.cE = null;
                }
                this.ttn = 0;
                this.ww = 0.0f;
                this.wx = 0.0f;
                return true;
            case 2:
                action = (int) (this.ww - x);
                this.ww = x;
                scrollBy(action, 0);
                return true;
            default:
                return true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.tts) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (getChildCount() == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.ttn != 0) {
            return true;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.ww = x;
                this.wx = y;
                this.ttn = this.wf.isFinished() ? 0 : 1;
                break;
            case 1:
            case 3:
                this.ttn = 0;
                break;
            case 2:
                boolean z;
                action = (int) Math.abs(this.ww - x);
                int abs = (int) Math.abs(this.wx - y);
                x.v("MicroMsg.MMFlipper", "xDif = " + action + ", yDif = " + abs);
                if (action <= this.fW || abs >= this.fW) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    this.ttn = 0;
                    break;
                }
                this.ttn = 1;
                break;
                break;
        }
        if (this.ttn == 0) {
            return false;
        }
        return true;
    }

    public void setScrollEnable(boolean z) {
        this.tts = z;
    }
}
