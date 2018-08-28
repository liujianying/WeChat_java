package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;

public class MMViewPager extends WxViewPager {
    private int OI = -1;
    private int SQ;
    private int SR;
    private float aaZ = 0.0f;
    private float aba = 0.0f;
    private float bwH;
    private VelocityTracker cE;
    private GestureDetector gbw;
    private ag handler = new ag(Looper.getMainLooper());
    private int hmV;
    private int hmW;
    private int jDz = -1;
    private boolean jEU = false;
    private OverScroller jEV;
    private RectF jEX = new RectF();
    private float jEZ;
    private boolean jFa = false;
    private boolean jFb = false;
    private boolean jFc = false;
    private boolean jFd = false;
    private boolean nZh = false;
    private boolean nZi = false;
    private boolean nZj = false;
    private OnTouchListener oQM;
    private boolean tyA = false;
    private boolean tyB = false;
    private int tyC = 0;
    private a tyD;
    private e tyE;
    private c tyF;
    private e tyG = null;
    private float tyH = 0.0f;
    private float tyI;
    private float tyJ;
    private VelocityTracker tyK = null;
    private MotionEvent tyL;
    private long tyM = 0;
    private b tyN;
    private SimpleOnGestureListener tyO = new d(this, (byte) 0);
    private OnLongClickListener tyP = new 3(this);
    private final int tyQ = 60;
    private final int tyR = 500;
    private g tyt;
    private WxImageView tyu;
    private boolean tyv = false;
    private k tyw;
    private boolean tyx = false;
    private boolean tyy = false;
    private boolean tyz = false;

    private class f extends a {
        float[] jFk = new float[9];

        public f() {
            super(MMViewPager.this);
        }

        public final void play() {
            MMViewPager.this.handler.post(new 1(this));
        }
    }

    private class g extends a {
        float[] jFk = new float[9];

        public g() {
            super(MMViewPager.this);
        }

        public final void play() {
            MMViewPager.this.handler.post(new 1(this));
        }
    }

    public void setSingleClickOverListener(e eVar) {
        this.tyE = eVar;
    }

    public void setLongClickOverListener(c cVar) {
        this.tyF = cVar;
    }

    public MMViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
    }

    private void aSa() {
        this.tyw.removeMessages(1);
    }

    private void aSb() {
        aSa();
        k kVar = this.tyw;
        kVar.jFr = 15;
        kVar.sendEmptyMessageDelayed(1, 15);
    }

    public void setOnPageChangeListener(e eVar) {
        this.tyG = eVar;
    }

    public MMViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.tyw = new k(new WeakReference(this));
        this.gbw = new GestureDetector(context, new d(this, (byte) 0));
        this.jEV = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.tyC = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        super.setOnPageChangeListener(new 1(this));
        super.setOnTouchListener(new 2(this));
    }

    private void crT() {
        this.tyu = getSelectedWxImageView$778eb1f();
        if (this.tyu != null) {
            x.d("MicroMsg.MMViewPager", "alvinluo ViewPager initWxImageView");
            this.tyv = true;
            this.tyu.setGestureDetectorListener(this.tyO);
            this.tyu.setOnLongClickListener(this.tyP);
            this.tyu.crm();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            x.d("MicroMsg.MMViewPager", "alvinluo dispatchTouchEvent action: %s", new Object[]{Integer.valueOf(motionEvent.getAction())});
            if (this.tyu == null) {
                crT();
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMViewPager", e, "alvinluo MMViewPager dispatchTouchEvent exception", new Object[0]);
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (!(this.tyu == null || onInterceptTouchEvent)) {
            if (this.tyK == null) {
                this.tyK = VelocityTracker.obtain();
            }
            this.tyK.addMovement(motionEvent);
            VelocityTracker velocityTracker = this.tyK;
            velocityTracker.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT);
            int xVelocity = (int) velocityTracker.getXVelocity();
            int yVelocity = (int) velocityTracker.getYVelocity();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.tyI = motionEvent.getRawX();
                    this.tyJ = motionEvent.getRawY();
                    onInterceptTouchEvent = false;
                    break;
                case 1:
                    onInterceptTouchEvent = false;
                    break;
                case 2:
                    float rawY = motionEvent.getRawY() - this.tyJ;
                    x.d("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[]{Float.valueOf(motionEvent.getRawX() - this.tyI), Float.valueOf(rawY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity)});
                    if (Math.abs(motionEvent.getRawX() - this.tyI) <= 250.0f && Math.abs(yVelocity) > Math.abs(xVelocity) && Math.abs(yVelocity) > 0) {
                        x.i("MicroMsg.MMViewPager", "alvinluo ViewPager onInterceptTouchEvent action: %d", new Object[]{Integer.valueOf(motionEvent.getAction())});
                        onInterceptTouchEvent = true;
                        break;
                    }
                    onInterceptTouchEvent = false;
                    break;
                    break;
                default:
                    onInterceptTouchEvent = false;
                    break;
            }
            if (onInterceptTouchEvent) {
                this.aaZ = motionEvent.getRawX();
                this.aba = motionEvent.getRawY();
                this.jEZ = this.tyu.getScale();
            }
        }
        return onInterceptTouchEvent;
    }

    public void setGalleryScaleListener(b bVar) {
        this.tyN = bVar;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.oQM = onTouchListener;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hmV = MeasureSpec.getSize(i);
        this.hmW = MeasureSpec.getSize(i2);
        this.jEX.set(0.0f, 0.0f, (float) this.hmV, (float) this.hmW);
    }

    private boolean crU() {
        x.d("MicroMsg.MMViewPager", "dancy scroll left right !!");
        if (this.tyy) {
            return true;
        }
        this.tyz = true;
        return false;
    }

    private boolean a(float f, View view, float f2) {
        if (getAdapter().k(view) == crV()) {
            if (this.tyt instanceof WxImageView) {
                float f3 = f2 * 0.3f;
                x.d("MicroMsg.MMViewPager", "alvinluo scrollFirst current is WxImageView, distanceX: %f, translateLeft: %f", new Object[]{Float.valueOf(f3), Float.valueOf(((WxImageView) this.tyt).getTranslationX())});
                if (f3 < 0.0f && r0 - f3 > 0.0f) {
                    this.tyA = true;
                }
                if (!this.tyA) {
                    return false;
                }
                ((WxImageView) this.tyt).translate(-f3, 0.0f);
                return true;
            } else if (this.tyA) {
                if (f2 < 0.0f) {
                    if (f <= this.jEX.left) {
                        this.tyt.V(-f2, 0.0f);
                    } else if (f > this.jEX.left && f < ((float) this.hmV) * 0.3f) {
                        this.tyt.V(-(f2 * 0.3f), 0.0f);
                        return true;
                    }
                }
                return false;
            } else if (f2 < 0.0f) {
                if (f > 0.0f) {
                    this.tyA = true;
                }
                if (f <= this.jEX.left) {
                    this.tyt.V(-f2, 0.0f);
                } else if (f > this.jEX.left && f < ((float) this.hmV) * 0.3f) {
                    this.tyt.V(-(f2 * 0.3f), 0.0f);
                    return true;
                }
            }
        }
        if (this.tyz || this.tyy) {
            return false;
        }
        this.tyA = false;
        return false;
    }

    private boolean b(float f, View view, float f2) {
        if (getAdapter().k(view) == crW()) {
            if (this.tyt instanceof WxImageView) {
                float f3 = f2 * 0.3f;
                x.d("MicroMsg.MMViewPager", "alvinluo scrollLast current is WxImageView, distanceX: %f, translateRight: %f", new Object[]{Float.valueOf(f3), Float.valueOf(((WxImageView) this.tyt).getTranslationX())});
                if (f3 > 0.0f && r0 - f3 < 0.0f) {
                    this.tyB = true;
                }
                if (!this.tyB) {
                    return false;
                }
                ((WxImageView) this.tyt).translate(-f3, 0.0f);
                return true;
            } else if (this.tyB) {
                if (f2 > 0.0f) {
                    if (f >= ((float) this.hmV)) {
                        this.tyt.V(-f2, 0.0f);
                    } else if (f > ((float) this.hmV) * 0.7f && f < ((float) this.hmW)) {
                        this.tyt.V(-(f2 * 0.3f), 0.0f);
                        return true;
                    }
                }
                return false;
            } else if (f2 > 0.0f) {
                if (f < ((float) this.hmV)) {
                    this.tyB = true;
                }
                if (f >= ((float) this.hmV)) {
                    this.tyt.V(-f2, 0.0f);
                } else if (f > ((float) this.hmV) * 0.7f && f < ((float) this.hmW)) {
                    this.tyt.V(-(f2 * 0.3f), 0.0f);
                    return true;
                }
            }
        }
        if (this.tyz || this.tyy) {
            return false;
        }
        this.tyB = false;
        return false;
    }

    private boolean a(float f, float f2, View view, float f3) {
        if (b(f2, view, f3) || a(f, view, f3)) {
            return true;
        }
        return false;
    }

    private View getSelectedView() {
        return ((t) getAdapter()).Ep(getCurrentItem());
    }

    private g getSelectedImageView() {
        MultiTouchImageView selectedMultiTouchImageView = getSelectedMultiTouchImageView();
        return selectedMultiTouchImageView != null ? selectedMultiTouchImageView : getSelectedWxImageView$778eb1f();
    }

    private MultiTouchImageView getSelectedMultiTouchImageView() {
        return ((t) getAdapter()).qC(getCurrentItem());
    }

    private WxImageView getSelectedWxImageView$778eb1f() {
        WxImageView qD = ((t) getAdapter()).qD(getCurrentItem());
        if (qD != null) {
            return qD;
        }
        return null;
    }

    public void setAdapter(u uVar) {
        if (uVar instanceof t) {
            super.setAdapter(uVar);
            return;
        }
        throw new IllegalArgumentException("must be MMViewPagerAdapter");
    }

    private int getCurrentX() {
        if (getAdapter() == null) {
            return -1;
        }
        return getScrollX() - (this.hmV * ((getAdapter().getCount() - getCurrentItem()) - 1));
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null || motionEvent.getX() - motionEvent2.getX() >= 0.0f) {
            return false;
        }
        return true;
    }

    public void computeScroll() {
        int i = 0;
        super.computeScroll();
        if (this.tyt != null) {
            float scale = this.tyt.getScale() * ((float) this.tyt.getImageWidth());
            float scale2 = this.tyt.getScale() * ((float) this.tyt.getImageHeight());
            if (this.jEV.computeScrollOffset()) {
                int currX = this.jEV.getCurrX() - this.SQ;
                int currY = this.jEV.getCurrY() - this.SR;
                this.SQ = this.jEV.getCurrX();
                this.SR = this.jEV.getCurrY();
                float[] fArr = new float[9];
                this.tyt.getImageMatrix().getValues(fArr);
                float f = fArr[2];
                scale += f;
                float f2 = fArr[5];
                float f3 = f2 + scale2;
                if (currX < 0 && ((float) currX) < this.jEX.right - ((float) Math.round(scale))) {
                    currX = (int) (this.jEX.right - ((float) Math.round(scale)));
                }
                if (currX > 0 && ((float) currX) > this.jEX.left - ((float) Math.round(f))) {
                    currX = (int) (this.jEX.left - ((float) Math.round(f)));
                }
                if (currY < 0 && ((float) currY) < this.jEX.bottom - ((float) Math.round(f3))) {
                    currY = (int) (this.jEX.bottom - ((float) Math.round(f3)));
                }
                if (currY > 0 && ((float) currY) > this.jEX.top - ((float) Math.round(f2))) {
                    currY = (int) (this.jEX.top - ((float) Math.round(f2)));
                }
                if (((float) Math.round(f)) >= this.jEX.left || ((float) Math.round(scale)) <= this.jEX.right) {
                    currX = 0;
                } else if (((float) Math.round(f2)) >= this.jEX.top || ((float) Math.round(f3)) <= this.jEX.bottom) {
                    currY = 0;
                }
                if (scale2 >= ((float) this.hmW)) {
                    i = currY;
                }
                this.tyt.V((float) currX, (float) i);
                postInvalidate();
            }
        }
    }

    public int getScreenWidth() {
        return this.hmV;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    public boolean isFocused() {
        return true;
    }

    public final int crV() {
        int crV = ((t) getAdapter()).crV();
        return crV >= 0 ? crV : super.crV();
    }

    public final int crW() {
        int crW = ((t) getAdapter()).crW();
        return crW >= 0 ? crW : super.crW();
    }
}
