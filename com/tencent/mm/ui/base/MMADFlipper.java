package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;

public class MMADFlipper extends ViewGroup {
    private View Iq;
    private VelocityTracker cE;
    private int fW;
    private View iln;
    private Context mContext;
    private int ttn;
    private Interpolator tto;
    private int ttp;
    private int ttq;
    private boolean ttr;
    private boolean tts;
    private a ttt;
    private Scroller wf;
    private float ww;
    private float wx;

    public MMADFlipper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMADFlipper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ttn = 0;
        this.ttr = false;
        this.tts = true;
        this.mContext = context;
        this.tto = getInterpolator();
        this.wf = new Scroller(this.mContext, this.tto);
        this.fW = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i5, 0, i5 + measuredWidth, childAt.getMeasuredHeight());
                i5 += measuredWidth;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).measure(i, i2);
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
                if (action > 600) {
                    if (cro()) {
                        this.ttp--;
                        Ei(this.ttp);
                    }
                    this.ttr = true;
                } else if (action < -600) {
                    if (cro()) {
                        this.ttp++;
                        Ei(this.ttp);
                    }
                    this.ttr = true;
                } else {
                    action = getWidth();
                    Ei((getScrollX() + (action / 2)) / action);
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

    private Interpolator getInterpolator() {
        return new LinearInterpolator();
    }

    public void setHeaderView(View view) {
        this.Iq = view;
    }

    public void setFooterView(View view) {
        this.iln = view;
    }

    public void setScrollEnable(boolean z) {
        this.tts = z;
    }

    private boolean cro() {
        if (getChildCount() > 1) {
            return true;
        }
        return false;
    }

    public int getRealChildCount() {
        if (getChildCount() > 1) {
            return getChildCount() - 2;
        }
        return getChildCount();
    }

    public int getCurScreen() {
        return this.ttp;
    }

    public int getRealCurScreen() {
        if (getChildCount() > 1) {
            return this.ttp - 1;
        }
        return this.ttp;
    }

    private void Ei(int i) {
        int max = Math.max(0, Math.min(i, getChildCount() - 1));
        if (getScrollX() != getWidth() * max) {
            int width = (max * getWidth()) - getScrollX();
            this.wf.startScroll(getScrollX(), 0, width, 0, a.ag(getContext(), Math.abs(width) * 2));
            invalidate();
        }
        x.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", Integer.valueOf(this.ttp), Integer.valueOf(this.ttq), Integer.valueOf(i));
        this.ttq = i;
    }

    public void computeScroll() {
        if (this.wf.computeScrollOffset()) {
            scrollTo(this.wf.getCurrX(), this.wf.getCurrY());
            postInvalidate();
        } else if (this.ttr) {
            this.ttr = false;
            if (this.ttp <= 0) {
                this.ttp = getRealChildCount();
                setScrollXOffest(this.ttp * getWidth());
            } else if (this.ttp >= getChildCount() - 1) {
                this.ttp = 1;
                setScrollXOffest(this.ttp * getWidth());
            }
        }
    }

    public void setOnScreenChangedListener(a aVar) {
        this.ttt = aVar;
    }

    @TargetApi(14)
    public void setScrollXOffest(int i) {
        if (VERSION.SDK_INT >= 14) {
            setScrollX(i);
        } else if (this.wf != null) {
            this.wf.setFinalX(i);
        }
    }
}
