package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.os.SystemClock;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager.b;

public final class a implements OnTouchListener {
    private float ftp = Float.MIN_VALUE;
    private DummyViewPager nHe;
    private float nHf = Float.MIN_VALUE;

    public a(DummyViewPager dummyViewPager) {
        this.nHe = dummyViewPager;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        new StringBuilder("onTouchEvent , action ").append(motionEvent.getAction()).append(", e.rawY ").append(motionEvent.getRawY()).append(",lastMotionY ").append(this.nHf).append(",downY ").append(this.ftp);
        switch (motionEvent.getAction()) {
            case 0:
                this.ftp = motionEvent.getRawY();
                break;
            case 1:
            case 3:
                if (this.nHe.wC) {
                    try {
                        DummyViewPager dummyViewPager = this.nHe;
                        if (dummyViewPager.wC) {
                            VelocityTracker velocityTracker = dummyViewPager.cE;
                            velocityTracker.computeCurrentVelocity(1000, (float) dummyViewPager.wz);
                            int a = (int) y.a(velocityTracker, dummyViewPager.cF);
                            dummyViewPager.wr = true;
                            int clientWidth = dummyViewPager.getClientWidth();
                            int scrollX = dummyViewPager.getScrollX();
                            b bAp = dummyViewPager.bAp();
                            dummyViewPager.a(dummyViewPager.a(bAp.position, ((((float) scrollX) / ((float) clientWidth)) - bAp.wW) / bAp.wV, a, (int) (dummyViewPager.ww - dummyViewPager.vm)), true, true, a);
                            dummyViewPager.cP();
                            dummyViewPager.wC = false;
                        } else {
                            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
                        }
                    } catch (Exception e) {
                    }
                }
                this.ftp = Float.MIN_VALUE;
                this.nHf = Float.MIN_VALUE;
                break;
            case 2:
                if (this.ftp == Float.MIN_VALUE && this.nHf == Float.MIN_VALUE) {
                    this.ftp = motionEvent.getRawY();
                    break;
                }
                float rawY = motionEvent.getRawY() - (this.nHf == Float.MIN_VALUE ? this.ftp : this.nHf);
                this.nHf = motionEvent.getRawY();
                float f = rawY / 2.0f;
                new StringBuilder("scrollX ").append(this.nHe.getScrollX()).append(",basescrollX ").append(this.nHe.getBaseScrollX());
                if (this.nHe.getScrollX() == this.nHe.getBaseScrollX()) {
                    if (z.h(view, (-f) > 0.0f ? 1 : -1)) {
                        new StringBuilder("scroll vertically  ").append(f).append(", move.lastMotionY ").append(motionEvent.getY());
                        break;
                    }
                    DummyViewPager dummyViewPager2 = this.nHe;
                    if (!dummyViewPager2.fU) {
                        dummyViewPager2.wC = true;
                        dummyViewPager2.setScrollState(1);
                        dummyViewPager2.ww = 0.0f;
                        dummyViewPager2.vm = 0.0f;
                        if (dummyViewPager2.cE == null) {
                            dummyViewPager2.cE = VelocityTracker.obtain();
                        } else {
                            dummyViewPager2.cE.clear();
                        }
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                        dummyViewPager2.cE.addMovement(obtain);
                        obtain.recycle();
                        dummyViewPager2.nGV = uptimeMillis;
                    }
                    a(view, motionEvent, f);
                    c(view, motionEvent);
                    return false;
                } else if (a(view, motionEvent, f)) {
                    return false;
                }
                break;
        }
        return view.onTouchEvent(motionEvent);
    }

    private boolean a(View view, MotionEvent motionEvent, float f) {
        if (!this.nHe.wC) {
            return false;
        }
        boolean z;
        float scrollX;
        float scrollX2 = (float) (((int) (((float) this.nHe.getScrollX()) - f)) - this.nHe.getBaseScrollX());
        float scrollX3 = (float) (this.nHe.getScrollX() - this.nHe.getBaseScrollX());
        if (Math.abs(scrollX2 + scrollX3) < Math.abs(scrollX2 - scrollX3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            scrollX = (float) (this.nHe.getScrollX() - this.nHe.getBaseScrollX());
        } else {
            scrollX = f;
        }
        DummyViewPager dummyViewPager = this.nHe;
        if (dummyViewPager.wC) {
            dummyViewPager.ww += scrollX;
            float scrollX4 = ((float) dummyViewPager.getScrollX()) - scrollX;
            int clientWidth = dummyViewPager.getClientWidth();
            float f2 = ((float) clientWidth) * dummyViewPager.wn;
            b bVar = (b) dummyViewPager.bA.get(0);
            b bVar2 = (b) dummyViewPager.bA.get(dummyViewPager.bA.size() - 1);
            scrollX2 = bVar.position != 0 ? bVar.wW * ((float) clientWidth) : ((float) clientWidth) * dummyViewPager.wm;
            scrollX3 = bVar2.position != dummyViewPager.wa.getCount() + -1 ? bVar2.wW * ((float) clientWidth) : f2;
            if (scrollX4 >= scrollX2) {
                scrollX2 = scrollX4 > scrollX3 ? scrollX3 : scrollX4;
            }
            dummyViewPager.ww += scrollX2 - ((float) ((int) scrollX2));
            dummyViewPager.scrollTo((int) scrollX2, dummyViewPager.getScrollY());
            dummyViewPager.an((int) scrollX2);
            MotionEvent obtain = MotionEvent.obtain(dummyViewPager.nGV, SystemClock.uptimeMillis(), 2, dummyViewPager.ww, 0.0f, 0);
            dummyViewPager.cE.addMovement(obtain);
            obtain.recycle();
            new StringBuilder("fake drag, diff ").append(f).append(",step ").append(scrollX).append(",scrollX ").append(this.nHe.getScrollX());
            c(view, motionEvent);
            return true;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    private static void c(View view, MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(0);
        view.dispatchTouchEvent(obtain);
    }
}
