package com.tencent.mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class q extends FrameLayout {
    View FU;
    private int fW;
    View gnV;
    FrameLayout gnW;
    FrameLayout gnX;
    public boolean gnY = true;
    private boolean gnZ = false;
    private boolean goa = false;
    private boolean gob = false;
    private boolean goc = false;
    private int god;
    private int goe;
    private int gof;
    private ObjectAnimator gog = null;

    public q(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -1));
        this.fW = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setPullDownEnabled(boolean z) {
        this.gnY = !z;
    }

    public void setNeedStay(boolean z) {
        this.gnZ = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gnY) {
            return this.goc;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            return false;
        }
        if (this.gob) {
            return true;
        }
        switch (action) {
            case 0:
                if (ama()) {
                    this.god = (int) motionEvent.getX();
                    this.goe = (int) motionEvent.getY();
                    this.gof = (int) motionEvent.getY();
                    break;
                }
                break;
            case 2:
                if (ama()) {
                    action = ((int) motionEvent.getX()) - this.god;
                    int y = ((int) motionEvent.getY()) - this.goe;
                    if (Math.abs(y) > this.fW && Math.abs(y) > Math.abs(action) && y > 0) {
                        this.gob = true;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gnY) {
            if (this.goc) {
                alX();
            }
            return this.goc;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.gof = (int) motionEvent.getY();
                return true;
            case 1:
            case 3:
                if (this.gnX.getTranslationY() <= ((float) getOpenHeight()) || !this.gnZ) {
                    alX();
                } else {
                    alW();
                }
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.gof) >> 1;
                int maxOverScrollDistance = getMaxOverScrollDistance();
                if (y <= maxOverScrollDistance) {
                    maxOverScrollDistance = y;
                }
                if (this.goa) {
                    maxOverScrollDistance += getStayHeight();
                }
                maxOverScrollDistance = Math.max(maxOverScrollDistance, 0);
                x.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(maxOverScrollDistance)});
                this.gnX.setTranslationY((float) Math.min(getMaxOverScrollDistance(), maxOverScrollDistance));
                lq(maxOverScrollDistance);
                return true;
            default:
                return false;
        }
    }

    protected final void alW() {
        lr(getStayHeight());
        if (!this.goa) {
            alY();
        }
        this.gob = true;
        this.goa = true;
        this.goc = true;
    }

    protected final void alX() {
        lr(0);
        if (this.goa) {
            alZ();
        }
        this.gob = false;
        this.goa = false;
        this.goc = false;
    }

    protected void alY() {
    }

    protected void alZ() {
    }

    protected void lq(int i) {
    }

    public void setPullDownBackgroundColor(int i) {
        this.gnW.setBackgroundColor(i);
    }

    private boolean ama() {
        if (this.FU instanceof WebView) {
            return ((WebView) this.FU).isOverScrollStart();
        }
        return this.FU.getScrollY() == 0;
    }

    private int getMaxOverScrollDistance() {
        return getHeight();
    }

    protected int getOpenHeight() {
        return this.gnV.getHeight();
    }

    protected int getStayHeight() {
        return this.gnV.getHeight();
    }

    private void lr(int i) {
        int translationY = (int) this.gnX.getTranslationY();
        if (translationY != i) {
            x.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", new Object[]{Integer.valueOf(translationY), Integer.valueOf(i)});
            if (this.gog != null) {
                this.gog.cancel();
            }
            long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) getStayHeight())) * 250.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gnX, "translationY", new float[]{(float) translationY, (float) i});
            ofFloat.setDuration(Math.min(abs, 250));
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.start();
            ofFloat.addUpdateListener(new 1(this));
            this.gog = ofFloat;
        }
    }
}
