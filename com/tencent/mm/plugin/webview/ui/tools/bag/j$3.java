package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBag.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j qcu;

    j$3(j jVar) {
        this.qcu = jVar;
    }

    public final void el(int i, int i2) {
        j.a(this.qcu, 19);
        j.c(this.qcu).qcw = i;
        j.c(this.qcu).qcv = i2;
        j.c(this.qcu).save();
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        if (j.d(this.qcu) != null) {
            a d = j.d(this.qcu);
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            a.a aVar;
            Animation translateAnimation;
            switch (motionEvent.getAction()) {
                case 0:
                    d.qbd.x = rawX;
                    d.qbd.y = rawY;
                    break;
                case 1:
                    if (!d.qbe) {
                        if (d.mIsShowing) {
                            d.mIsShowing = false;
                            aVar = d.qba;
                            translateAnimation = new TranslateAnimation(0.0f, (float) a.a.qbg, 0.0f, (float) a.a.qbg);
                            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            Animation animationSet = new AnimationSet(true);
                            animationSet.addAnimation(alphaAnimation);
                            animationSet.addAnimation(translateAnimation);
                            animationSet.setDuration(300);
                            animationSet.setAnimationListener(new a$a$1(aVar));
                            aVar.iDX.startAnimation(animationSet);
                            aVar.FU.startAnimation(animationSet);
                            break;
                        }
                    }
                    d.qbb.bWO();
                    break;
                    break;
                case 2:
                    boolean z;
                    if (d.qbc) {
                        z = true;
                    } else {
                        d.qbc = (((rawX - d.qbd.x) * (rawX - d.qbd.x)) + ((rawY - d.qbd.y) * (rawY - d.qbd.y))) - 900.0f > 0.0f;
                        z = d.qbc;
                    }
                    if (z) {
                        if (!d.mIsShowing) {
                            d.mIsShowing = true;
                            d.mScreenWidth = com.tencent.mm.bp.a.fk(ad.getContext());
                            d.mScreenHeight = com.tencent.mm.bp.a.fl(ad.getContext());
                            d.qbf = d.mScreenWidth > d.mScreenHeight;
                            x.i("MicroMsg.BagCancelController", "updateOrientation mIsLandScape:%b", new Object[]{Boolean.valueOf(d.qbf)});
                            aVar = d.qba;
                            aVar.setVisibility(0);
                            translateAnimation = new TranslateAnimation((float) a.a.qbg, 0.0f, (float) a.a.qbg, 0.0f);
                            translateAnimation.setFillAfter(true);
                            translateAnimation.setDuration(200);
                            aVar.iDX.startAnimation(translateAnimation);
                            aVar.FU.startAnimation(translateAnimation);
                        }
                        boolean z2 = d.qbe;
                        if (d.qbf) {
                            rawX = (((float) d.mScreenWidth) - motionEvent.getRawX()) - ((float) b.qbj);
                            rawY = ((float) d.mScreenHeight) - motionEvent.getRawY();
                        } else {
                            rawX = ((float) d.mScreenWidth) - motionEvent.getRawX();
                            rawY = (((float) d.mScreenHeight) - motionEvent.getRawY()) - ((float) b.qbj);
                        }
                        if ((rawX * rawX) + (rawY * rawY) < ((float) a.qaZ)) {
                            d.qbe = true;
                        } else {
                            d.qbe = false;
                        }
                        if (d.qbe != z2) {
                            aVar = d.qba;
                            if (d.qbe) {
                                aVar.R(1.0f, a.a.qbh);
                                if (aVar.hXL != null) {
                                    aVar.hXL.vibrate(10);
                                    return;
                                }
                                return;
                            }
                            aVar.R(a.a.qbh, 1.0f);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            d.qbc = false;
            d.qbe = false;
        }
    }
}
