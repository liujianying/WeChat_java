package com.tencent.mm.ui.base;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;

class MMViewPager$d extends SimpleOnGestureListener {
    final /* synthetic */ MMViewPager tyS;

    private MMViewPager$d(MMViewPager mMViewPager) {
        this.tyS = mMViewPager;
    }

    /* synthetic */ MMViewPager$d(MMViewPager mMViewPager, byte b) {
        this(mMViewPager);
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (MMViewPager.q(this.tyS) != null) {
            MMViewPager.q(this.tyS).ayI();
        }
        return true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        if (MMViewPager.r(this.tyS) != null) {
            MMViewPager.r(this.tyS).forceFinished(true);
        }
        return super.onDown(motionEvent);
    }

    public final void onLongPress(MotionEvent motionEvent) {
        MMViewPager.s(this.tyS);
        if (MMViewPager.p(this.tyS) != null) {
            MMViewPager.p(this.tyS).aMl();
        }
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (MMViewPager.a(this.tyS) == null) {
            return false;
        }
        if (MMViewPager.a(this.tyS).getScale() <= MMViewPager.a(this.tyS).getScaleRate()) {
            MMViewPager.a(this.tyS).U(f.i(motionEvent, 0), f.j(motionEvent, 0));
        } else {
            MMViewPager.a(this.tyS).T(f.i(motionEvent, 0), f.j(motionEvent, 0));
        }
        return true;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.d("MicroMsg.MMViewPager", "onFling");
        MultiTouchImageView t = MMViewPager.t(this.tyS);
        if (t == null) {
            t = MMViewPager.u(this.tyS);
        }
        if (t != null) {
            g gVar;
            x.d("MicroMsg.MMViewPager", "onFling MultiTouchImageView");
            if (t instanceof MultiTouchImageView) {
                gVar = t;
            } else if (t instanceof WxImageView) {
                WxImageView gVar2 = (WxImageView) t;
            } else {
                gVar2 = null;
            }
            float scale = gVar2.getScale() * ((float) gVar2.getImageWidth());
            float scale2 = gVar2.getScale() * ((float) gVar2.getImageHeight());
            if (gVar2.crk() || gVar2.crl() || ((int) scale) > MMViewPager.b(this.tyS) || ((int) scale2) > MMViewPager.d(this.tyS)) {
                float f3;
                r6 = new float[9];
                gVar2.getImageMatrix().getValues(r6);
                float f4 = r6[2];
                float f5 = f4 + scale;
                float f6 = r6[5];
                float f7 = f6 + scale2;
                x.d("MicroMsg.MMViewPager", "left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[]{Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(MMViewPager.c(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2)});
                if (((float) Math.round(f4)) >= MMViewPager.v(this.tyS).left || ((float) Math.round(f5)) <= MMViewPager.v(this.tyS).right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= MMViewPager.v(this.tyS).top || ((float) Math.round(f7)) <= MMViewPager.v(this.tyS).bottom) {
                    f2 = 0.0f;
                }
                int i = (int) (MMViewPager.v(this.tyS).right - scale);
                int i2 = (int) (scale + MMViewPager.v(this.tyS).right);
                int i3 = (int) (MMViewPager.v(this.tyS).bottom - scale2);
                int i4 = (int) (MMViewPager.v(this.tyS).bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) MMViewPager.w(this.tyS))) {
                        f3 = (float) MMViewPager.w(this.tyS);
                    }
                    f6 = f3;
                } else {
                    if (Math.abs(f3) >= ((float) MMViewPager.w(this.tyS))) {
                        f3 = (float) (-MMViewPager.w(this.tyS));
                    }
                    f6 = f3;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) MMViewPager.w(this.tyS))) {
                        f2 = (float) MMViewPager.w(this.tyS);
                    }
                } else if (Math.abs(f2) >= ((float) MMViewPager.w(this.tyS))) {
                    f2 = (float) (-MMViewPager.w(this.tyS));
                }
                MMViewPager.r(this.tyS).fling(MMViewPager.r(this.tyS).getCurrX(), MMViewPager.r(this.tyS).getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!MMViewPager.c(motionEvent, motionEvent2) || f4 < 0.0f) && (MMViewPager.c(motionEvent, motionEvent2) || f5 > ((float) MMViewPager.b(this.tyS)))) {
                    return false;
                }
            }
        }
        if (MMViewPager.m(this.tyS)) {
            return false;
        }
        return MMViewPager.a(this.tyS, motionEvent, motionEvent2, f);
    }
}
