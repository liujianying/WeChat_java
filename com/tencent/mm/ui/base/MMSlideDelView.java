package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public class MMSlideDelView extends ViewGroup {
    private VelocityTracker cE;
    private final int fW;
    private g hkN;
    private c hkO;
    private d hkQ;
    private boolean hsJ = false;
    private int kJp;
    private boolean kws = true;
    private ag mHandler = new ag();
    long time;
    private boolean txm = false;
    private b txn;
    private Runnable txo;
    private long txp;
    private boolean txq = false;
    private a txr = null;
    private e txs;
    private final Scroller wf;
    private float ww;
    private float wx;

    public interface e {
    }

    public interface f {
        void bv(Object obj);
    }

    public interface g {
        void t(View view, int i);
    }

    private class h {
        int txu;

        private h() {
        }

        /* synthetic */ h(MMSlideDelView mMSlideDelView, byte b) {
            this();
        }
    }

    public static d getItemStatusCallBack() {
        return new 1();
    }

    public MMSlideDelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wf = new Scroller(context, new LinearInterpolator());
        this.fW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.txp = (long) ViewConfiguration.getLongPressTimeout();
    }

    public void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    public void setItemStatusCallBack(d dVar) {
        this.hkQ = dVar;
    }

    public void setEnable(boolean z) {
        this.kws = z;
    }

    public void setOnDelViewShowCallback(e eVar) {
        this.txs = eVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() >= 2) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    childAt.layout(i5, 0, i5 + measuredWidth, i4 - i2);
                    i5 += measuredWidth;
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() >= 2) {
            int size = MeasureSpec.getSize(i);
            try {
                getChildAt(0).measure(i, i2);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
            int max = Math.max(0, getChildAt(0).getMeasuredHeight());
            LayoutParams layoutParams = getChildAt(1).getLayoutParams();
            View childAt = getChildAt(1);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                try {
                    childAt.measure(MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), MeasureSpec.makeMeasureSpec(max, 1073741824));
                } catch (ArrayIndexOutOfBoundsException e2) {
                }
                max = Math.max(max, childAt.getMeasuredHeight());
            }
            setMeasuredDimension(resolveSize(size, i), resolveSize(max, i2));
        }
    }

    public void setView(View view) {
        if (getChildCount() == 2) {
            removeViewAt(0);
        }
        addView(view, 0, new LayoutParams(-1, -2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.kws) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.hkQ.aYk() && !this.txm) {
            x.v("MicroMsg.MMSlideDelView", "onTouchEvent a menu has been shown, skip");
            this.txq = false;
            this.hkQ.aYl();
        }
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        if (this.txq) {
            return false;
        }
        switch (action) {
            case 0:
                if (getContext() instanceof MMActivity) {
                    ((MMActivity) getContext()).YC();
                }
                this.hsJ = false;
                if (!this.wf.isFinished()) {
                    this.wf.abortAnimation();
                }
                this.time = System.currentTimeMillis();
                if (this.hkO != null) {
                    this.kJp = this.hkO.cl(this);
                }
                if (this.txn == null) {
                    this.txn = new b(this);
                }
                this.mHandler.postDelayed(this.txn, (long) ViewConfiguration.getTapTimeout());
                this.ww = x;
                this.wx = y;
                if (this.txr == null) {
                    this.txr = new a(this, (byte) 0);
                }
                a aVar = this.txr;
                aVar.txu = aVar.txt.getWindowAttachCount();
                this.mHandler.postDelayed(this.txr, this.txp);
                return true;
            case 1:
                crJ();
                if (this.hsJ || ((!isPressed() && System.currentTimeMillis() - this.time >= 200) || this.hkN == null || this.txm)) {
                    setPressed(false);
                } else {
                    setPressed(true);
                    if (this.txo != null) {
                        removeCallbacks(this.txo);
                    }
                    this.txo = new 2(this);
                    this.mHandler.postDelayed(this.txo, (long) ViewConfiguration.getPressedStateDuration());
                }
                if (this.hsJ) {
                    crK();
                }
                hl();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.txr);
                return true;
            case 2:
                int i = (int) (this.ww - x);
                action = (int) (this.wx - y);
                int scrollX = getScrollX();
                if (!this.hsJ) {
                    boolean z;
                    if (i >= 0 && Math.abs(i) >= this.fW / 3) {
                        if (action == 0) {
                            action = 1;
                        }
                        if (Math.abs(i / action) > 3) {
                            z = true;
                            if (z || this.txm) {
                                this.hsJ = true;
                                em(true);
                            }
                        }
                    }
                    z = false;
                    this.hsJ = true;
                    em(true);
                }
                if (this.hsJ) {
                    View childAt = getChildAt(1);
                    if (!(childAt == null || childAt.isShown())) {
                        childAt.setVisibility(0);
                    }
                    crJ();
                    setPressed(false);
                    em(true);
                    if (scrollX + i < 0) {
                        action = -scrollX;
                    } else if (scrollX + i > getChildAt(1).getWidth()) {
                        action = getChildAt(1).getWidth() - scrollX;
                    } else {
                        action = i;
                    }
                    if (this.mHandler != null) {
                        this.mHandler.removeCallbacks(this.txr);
                    }
                    scrollBy(action, 0);
                }
                this.ww = x;
                this.wx = y;
                return true;
            case 3:
                crJ();
                setPressed(false);
                if (this.hsJ) {
                    crK();
                }
                hl();
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.txr);
                return true;
            default:
                if (this.mHandler == null) {
                    return true;
                }
                this.mHandler.removeCallbacks(this.txr);
                return true;
        }
    }

    private void hl() {
        if (this.cE != null) {
            this.cE.clear();
            this.cE = null;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        x.v("MicroMsg.MMSlideDelView", "window focus change, reset long press status");
        this.txq = false;
        super.onWindowFocusChanged(z);
    }

    private void crJ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.txn);
        }
    }

    private void crK() {
        setPressed(false);
        if (this.txm) {
            crM();
            return;
        }
        MMSlideDelView mMSlideDelView;
        VelocityTracker velocityTracker = this.cE;
        velocityTracker.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT);
        int xVelocity = (int) velocityTracker.getXVelocity();
        int scrollX;
        int width;
        if (xVelocity < -600) {
            scrollX = getScrollX();
            width = getChildAt(1).getWidth() - scrollX;
            this.hkQ.a(this, true);
            this.txm = true;
            this.wf.startScroll(scrollX, 0, width, 0, 100);
            mMSlideDelView = this;
        } else if (xVelocity > TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_INTERRUPTED) {
            crM();
            if (this.cE != null) {
                this.cE.recycle();
                this.cE = null;
            }
            this.hsJ = false;
            em(false);
        } else {
            scrollX = getScrollX();
            xVelocity = getChildAt(1).getWidth();
            width = xVelocity - scrollX;
            if (scrollX > xVelocity / 2) {
                this.hkQ.a(this, true);
                this.txm = true;
                this.wf.startScroll(scrollX, 0, width, 0, 100);
                mMSlideDelView = this;
            } else {
                this.txm = false;
                this.hkQ.a(this, false);
                this.wf.startScroll(scrollX, 0, -scrollX, 0, 100);
                mMSlideDelView = this;
            }
        }
        mMSlideDelView.invalidate();
        if (this.cE != null) {
            this.cE.recycle();
            this.cE = null;
        }
        this.hsJ = false;
        em(false);
    }

    private void em(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void crL() {
        this.hkQ.a(this, false);
        this.txm = false;
        scrollTo(0, 0);
        invalidate();
    }

    public final void crM() {
        int scrollX = getScrollX();
        this.hkQ.a(this, false);
        this.txm = false;
        this.wf.startScroll(scrollX, 0, -scrollX, 0, 100);
        invalidate();
    }

    public void computeScroll() {
        if (this.wf.computeScrollOffset()) {
            scrollTo(this.wf.getCurrX(), this.wf.getCurrY());
            postInvalidate();
        }
    }

    public Bitmap getDrawingCache() {
        return null;
    }

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public void buildDrawingCache(boolean z) {
    }

    public void buildDrawingCache() {
    }
}
