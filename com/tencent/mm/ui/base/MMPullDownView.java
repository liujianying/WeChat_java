package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.tools.j.a;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMPullDownView extends FrameLayout implements OnGestureListener {
    private static int twM = SystemUtil.SMALL_SCREEN_THRESHOLD;
    private static final int twP = Color.parseColor("#00000000");
    private int bgColor;
    public Context context;
    private GestureDetector iEv;
    public View tiw;
    private int ttp;
    private int tui;
    private c twA;
    private d twB;
    public View twC;
    private int twD;
    private int twE;
    private int twF;
    private boolean twG;
    private f twH;
    private boolean twI;
    private j twJ;
    private boolean twK;
    private a twL;
    private ag twN;
    boolean twO;
    private boolean twQ;
    private int twR;
    private int twS;
    private b twT;
    private g two;
    private e twp;
    private int twq;
    private int twr;
    private boolean tws;
    private boolean twt;
    private boolean twu;
    private boolean twv;
    public boolean tww;
    private boolean twx;
    private boolean twy;
    private boolean twz;
    private Scroller wf;

    public MMPullDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tui = 1;
        this.tws = false;
        this.twt = false;
        this.twu = false;
        this.twv = false;
        this.tww = true;
        this.twx = false;
        this.twy = true;
        this.twz = true;
        this.twE = 4;
        this.twF = 4;
        this.twG = false;
        this.twI = true;
        this.twK = false;
        this.twN = new ag() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (MMPullDownView.this.twD) {
                    case 0:
                        if (MMPullDownView.this.two != null) {
                            MMPullDownView.this.tww = MMPullDownView.this.two.aCj();
                        }
                        if (MMPullDownView.this.tww && MMPullDownView.this.twC.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.twq);
                            break;
                        }
                    case 1:
                        if (MMPullDownView.this.twp != null) {
                            MMPullDownView.this.tww = MMPullDownView.this.twp.aCg();
                        }
                        if (MMPullDownView.this.tww && MMPullDownView.this.tiw.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.twq);
                            break;
                        }
                }
                x.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[]{Integer.valueOf(MMPullDownView.this.twD), Boolean.valueOf(MMPullDownView.this.tww)});
            }
        };
        this.twO = false;
        this.twQ = false;
        this.bgColor = Color.parseColor("#ffffffff");
        this.twR = Integer.MIN_VALUE;
        this.twS = this.bgColor;
        this.wf = new Scroller(context, new AccelerateInterpolator());
        this.ttp = this.tui;
        this.iEv = new GestureDetector(context, this);
        this.twJ = new j(context);
        this.context = context;
    }

    public void aCz() {
        View inflate = inflate(this.context, h.loading_view, null);
        View inflate2 = inflate(this.context, h.loading_view, null);
        addView(inflate, 0, new LayoutParams(-1, -2));
        addView(inflate2, new LayoutParams(-1, -2));
    }

    public void setCanOverScrool(boolean z) {
        this.twI = z;
    }

    public void setIsTopShowAll(boolean z) {
        x.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.twy), bi.cjd()});
        this.twy = z;
    }

    public void setIsBottomShowAll(boolean z) {
        x.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.twz), bi.cjd()});
        this.twz = z;
    }

    public void setOnTopLoadDataListener(g gVar) {
        this.two = gVar;
    }

    public void setOnBottomLoadDataListener(e eVar) {
        this.twp = eVar;
    }

    public void setAtTopCallBack(d dVar) {
        this.twB = dVar;
    }

    public void setAtBottomCallBack(c cVar) {
        this.twA = cVar;
    }

    public void setOnSrcollDistance(f fVar) {
        this.twH = fVar;
    }

    public void setOnMMFlingListener(a aVar) {
        this.twJ.uAc = aVar;
    }

    public void setTopView(View view) {
        if (view == null) {
            this.twF = 4;
            if (this.twC != null) {
                this.twC.setVisibility(4);
                return;
            }
            return;
        }
        removeViewAt(0);
        this.twC = view;
        this.twC.setVisibility(0);
        this.twF = 0;
        addView(this.twC, 0, new LayoutParams(-1, -2));
        this.twq = 0;
    }

    public void setBottomView(View view) {
        if (view == null) {
            this.twE = 4;
            if (this.tiw != null) {
                this.tiw.setVisibility(4);
                return;
            }
            return;
        }
        this.tiw = view;
        this.tiw.setVisibility(0);
        this.twE = 0;
        removeViewAt(getChildCount() - 1);
        addView(this.tiw, new LayoutParams(-1, -2));
        this.twr = 0;
    }

    public void setBottomViewVisible(boolean z) {
        this.twE = z ? 0 : 4;
        if (this.tiw != null) {
            this.tiw.setVisibility(this.twE);
        }
        x.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[]{Boolean.valueOf(z), bi.cjd()});
    }

    public void setTopViewVisible(boolean z) {
        this.twF = z ? 0 : 4;
        if (this.twC != null) {
            this.twC.setVisibility(this.twF);
        }
        x.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b], stack[%s]", new Object[]{Boolean.valueOf(z), bi.cjd()});
    }

    public static void e(ViewGroup viewGroup, int i) {
        x.i("MicroMsg.MMPullDownView", "fix android O progress bar bug.");
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            if (viewGroup.getTag() == null) {
                viewGroup.setTag(viewGroup.findViewById(g.chatting_load_progress));
            }
            View view = (View) viewGroup.getTag();
            if (view != null) {
                view.setVisibility(i);
            }
        }
    }

    private void crG() {
        e((ViewGroup) this.twC, 0);
        e((ViewGroup) this.tiw, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (!this.twG) {
            aCz();
            this.twG = true;
        }
        int i5 = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                try {
                    childAt.layout(0, i5, childAt.getMeasuredWidth(), i5 + measuredHeight);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMPullDownView", e, "childCount: %d, i:%d, childHeight:%d", new Object[]{Integer.valueOf(childCount), Integer.valueOf(i6), Integer.valueOf(measuredHeight)});
                }
                i5 += measuredHeight;
            }
        }
        this.twC = getChildAt(0);
        this.tiw = getChildAt(getChildCount() - 1);
        this.twC.setVisibility(this.twF);
        this.tiw.setVisibility(this.twE);
        this.twq = this.twC.getHeight();
        this.twr = this.tiw.getHeight();
        this.twR = this.twq;
        if (!this.twx && this.twq != 0) {
            this.twx = true;
            scrollTo(0, this.twq);
        }
    }

    public int getCurScreen() {
        return this.ttp;
    }

    public void computeScroll() {
        if (this.wf.computeScrollOffset()) {
            scrollTo(this.wf.getCurrX(), this.wf.getCurrY());
            postInvalidate();
        } else if (this.twv) {
            x.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
            this.twv = false;
            this.twN.sendEmptyMessageDelayed(0, (long) twM);
            crG();
        }
        this.wf.isFinished();
    }

    public int getTopHeight() {
        return this.twq;
    }

    public int getBottomHeight() {
        return this.twr;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.twL != null) {
            this.twL.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.twq < 0) {
                    this.tws = true;
                }
                if (getScrollY() > this.twr) {
                    this.twt = true;
                }
                crH();
                break;
        }
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        j jVar = this.twJ;
        if (jVar.uAc != null) {
            jVar.ZY.onTouchEvent(motionEvent);
        }
        if (!this.tww) {
            return z;
        }
        if (this.twB == null) {
            this.tws = false;
        } else {
            this.tws = this.twB.aCh();
        }
        if (this.twA == null) {
            this.twt = false;
        } else {
            this.twt = this.twA.aCi();
        }
        if (this.twF == 0) {
            if (this.twy) {
                this.twC.setVisibility(4);
            } else {
                this.twC.setVisibility(0);
            }
        }
        if (this.twE == 0) {
            if (this.twz) {
                this.tiw.setVisibility(4);
            } else {
                this.tiw.setVisibility(0);
            }
        }
        if (motionEvent.getAction() == z) {
            crH();
            return super.dispatchTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 3) {
            crH();
            return this.twK ? super.dispatchTouchEvent(motionEvent) : false;
        } else if (this.iEv.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
            this.twO = z;
            return super.dispatchTouchEvent(motionEvent);
        } else {
            try {
                return super.dispatchTouchEvent(motionEvent);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMPullDownView", e, "", new Object[0]);
                return z;
            }
        }
    }

    public final void lJ(boolean z) {
        x.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], stack[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.twv), Boolean.valueOf(this.tww), Boolean.valueOf(this.twy), Integer.valueOf(getScrollY()), bi.cjd()});
        if (z) {
            if (this.twy) {
                this.wf.startScroll(0, getScrollY(), 0, this.twq + (-getScrollY()), 200);
            } else {
                if (this.twC != null && this.twC.getVisibility() == 4) {
                    this.wf.startScroll(0, getScrollY(), 0, this.twq + (-getScrollY()), 200);
                }
                if (this.twC != null && this.twC.getVisibility() == 0) {
                    this.wf.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.twD = 0;
                this.twv = true;
                this.tww = false;
            }
            postInvalidate();
        } else if (!this.tww) {
            this.tww = true;
            this.twv = false;
            if (this.twC != null && this.twC.getVisibility() == 0) {
                scrollTo(0, this.twq);
            }
        }
        crG();
    }

    public final void lK(boolean z) {
        x.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], stack[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.twv), Boolean.valueOf(this.tww), Boolean.valueOf(this.twz), Integer.valueOf(getScrollY()), bi.cjd()});
        if (z) {
            if (this.twz) {
                this.wf.startScroll(0, getScrollY(), 0, this.twr - getScrollY(), 200);
            } else {
                if (this.tiw != null && this.tiw.getVisibility() == 4) {
                    this.wf.startScroll(0, getScrollY(), 0, this.twr - getScrollY(), 200);
                }
                if (this.tiw != null && this.tiw.getVisibility() == 0) {
                    this.wf.startScroll(0, getScrollY(), 0, this.twr + (this.twr - getScrollY()), 200);
                }
                this.twD = 1;
                this.twv = true;
                this.tww = false;
            }
            postInvalidate();
            return;
        }
        if (!this.tww) {
            this.tww = true;
            this.twv = false;
        }
        if (this.tiw != null && this.tiw.getVisibility() == 0) {
            x.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
            scrollTo(0, this.twq);
        }
    }

    private void crH() {
        if (this.twH != null) {
            this.twH.bEi();
        }
        if (getScrollY() - this.twq < 0) {
            if (this.twy) {
                this.wf.startScroll(0, getScrollY(), 0, this.twq + (-getScrollY()), 200);
            } else {
                if (this.twC.getVisibility() == 4) {
                    this.wf.startScroll(0, getScrollY(), 0, this.twq + (-getScrollY()), 200);
                }
                if (this.twC.getVisibility() == 0) {
                    this.wf.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.twD = 0;
                this.twv = true;
                this.tww = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.twr) {
            if (this.twz) {
                this.wf.startScroll(0, getScrollY(), 0, this.twr - getScrollY(), 200);
            } else {
                if (this.tiw.getVisibility() == 4) {
                    this.wf.startScroll(0, getScrollY(), 0, this.twr - getScrollY(), 200);
                }
                if (this.tiw.getVisibility() == 0) {
                    this.wf.startScroll(0, getScrollY(), 0, this.twr + (this.twr - getScrollY()), 200);
                }
                this.twD = 1;
                this.twv = true;
                this.tww = false;
            }
            postInvalidate();
        }
        this.twu = false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.wf.isFinished()) {
            this.wf.abortAnimation();
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i = -1;
        if (this.twH != null) {
            this.twH.av(f2);
        }
        if (f2 > 0.0f) {
            this.twu = true;
        } else {
            this.twu = false;
        }
        int i2;
        if (this.twt && (this.twu || getScrollY() - this.twq > 0)) {
            if (!this.twI) {
                if (this.tiw.getVisibility() != 0) {
                    return true;
                }
                if (this.twu && getScrollY() >= this.twq * 2) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            x.v("check", "moveUp:" + i + " distanceY:" + f2 + " scrollY:" + getScrollY());
            if (getScrollY() + i < this.twq && !this.twu) {
                i = this.twq - getScrollY();
            } else if (!this.twI && getScrollY() + i >= this.twq * 2) {
                i = (this.twq * 2) - getScrollY();
            }
            scrollBy(0, i);
            return true;
        } else if (!this.tws || (this.twu && getScrollY() - this.twq >= 0)) {
            return false;
        } else {
            if (!this.twI) {
                if (this.twC.getVisibility() != 0) {
                    return true;
                }
                if (!this.twu && getScrollY() <= 0) {
                    return true;
                }
            }
            i2 = (int) (((double) f2) * 0.5d);
            if (i2 != 0) {
                i = i2;
            } else if (f2 > 0.0f) {
                i = 1;
            }
            if (getScrollY() + i > this.twq) {
                i = this.twq - getScrollY();
            } else if (!this.twI && getScrollY() + i < 0) {
                i = -getScrollY();
            }
            scrollBy(0, i);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void setShowBackground(boolean z) {
        this.twQ = z;
    }

    public void setBgColor(String str) {
        this.bgColor = Color.parseColor(str);
        this.twS = this.bgColor;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.twT != null) {
            this.twT.aIc();
        }
        if (this.twQ) {
            if (this.twR == Integer.MIN_VALUE) {
                this.twR = this.twq;
                x.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.twR);
            }
            if (i2 <= this.twR && this.twS != twP) {
                setBackgroundResource(f.mm_trans);
                this.twS = twP;
                x.d("MicroMsg.MMPullDownView", "onScrollChanged full");
            } else if (i2 > this.twR && this.twS != this.bgColor) {
                x.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                setBackgroundColor(this.bgColor);
                this.twS = this.bgColor;
            }
        }
    }

    public void setOnScrollChangedListener(b bVar) {
        this.twT = bVar;
    }

    public void setOnInterceptTouchEventListener(a aVar) {
        this.twL = aVar;
    }

    public void setIsReturnSuperDispatchWhenCancel(boolean z) {
        this.twK = z;
    }
}
