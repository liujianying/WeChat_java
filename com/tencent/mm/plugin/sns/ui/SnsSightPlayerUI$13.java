package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.tools.k;
import com.tencent.smtt.sdk.WebView;

class SnsSightPlayerUI$13 implements OnTouchListener {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$13(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f = 1.0f;
        SnsSightPlayerUI.m(this.obb).onTouchEvent(motionEvent);
        if (SnsSightPlayerUI.n(this.obb) == null) {
            SnsSightPlayerUI.a(this.obb, VelocityTracker.obtain());
        }
        SnsSightPlayerUI.n(this.obb).addMovement(motionEvent);
        switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
            case 0:
                SnsSightPlayerUI.a(this.obb, motionEvent.getX());
                SnsSightPlayerUI.b(this.obb, motionEvent.getY());
                break;
            case 1:
                if (SnsSightPlayerUI.o(this.obb)) {
                    ((View) SnsSightPlayerUI.f(this.obb)).setPivotX((float) (this.obb.ndZ.getWidth() / 2));
                    ((View) SnsSightPlayerUI.f(this.obb)).setPivotY((float) (this.obb.ndZ.getHeight() / 2));
                    ((View) SnsSightPlayerUI.f(this.obb)).setScaleX(1.0f);
                    ((View) SnsSightPlayerUI.f(this.obb)).setScaleY(1.0f);
                    ((View) SnsSightPlayerUI.f(this.obb)).setTranslationX(0.0f);
                    ((View) SnsSightPlayerUI.f(this.obb)).setTranslationY(0.0f);
                    SnsSightPlayerUI snsSightPlayerUI = this.obb;
                    if (snsSightPlayerUI.contextMenuHelper == null) {
                        snsSightPlayerUI.contextMenuHelper = new k(snsSightPlayerUI.mController.tml);
                    }
                    snsSightPlayerUI.contextMenuHelper.a((View) snsSightPlayerUI.hEl, snsSightPlayerUI.oba, snsSightPlayerUI.hqV);
                    if (SnsSightPlayerUI.p(this.obb) != null) {
                        SnsSightPlayerUI.p(this.obb).setVisibility(0);
                    }
                    SnsSightPlayerUI.c(this.obb, false);
                    SnsSightPlayerUI.b(this.obb, false);
                    break;
                } else if (!SnsSightPlayerUI.l(this.obb) || SnsSightPlayerUI.q(this.obb)) {
                    SnsSightPlayerUI.b(this.obb, false);
                    break;
                } else {
                    this.obb.ayH();
                    SnsSightPlayerUI.b(this.obb, false);
                    return true;
                }
                break;
            case 2:
                float translationX = ((View) SnsSightPlayerUI.f(this.obb)).getTranslationX();
                float translationY = ((View) SnsSightPlayerUI.f(this.obb)).getTranslationY();
                VelocityTracker n = SnsSightPlayerUI.n(this.obb);
                n.computeCurrentVelocity(1000);
                int xVelocity = (int) n.getXVelocity();
                int yVelocity = (int) n.getYVelocity();
                if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsSightPlayerUI.q(this.obb)) && !SnsSightPlayerUI.l(this.obb)) {
                    SnsSightPlayerUI.c(this.obb, false);
                } else {
                    float height = 1.0f - (translationY / ((float) this.obb.ndZ.getHeight()));
                    if (height <= 1.0f) {
                        f = height;
                    }
                    if (((yVelocity > 0 && f < SnsSightPlayerUI.r(this.obb)) || yVelocity < 0) && ((double) f) >= 0.5d) {
                        SnsSightPlayerUI.a(this.obb, (int) translationX);
                        SnsSightPlayerUI.b(this.obb, (int) translationY);
                        SnsSightPlayerUI.c(this.obb, f);
                        if (SnsSightPlayerUI.p(this.obb) != null) {
                            SnsSightPlayerUI.p(this.obb).setVisibility(8);
                        }
                        ((View) SnsSightPlayerUI.f(this.obb)).setPivotX((float) (this.obb.ndZ.getWidth() / 2));
                        ((View) SnsSightPlayerUI.f(this.obb)).setPivotY((float) (this.obb.ndZ.getHeight() / 2));
                        ((View) SnsSightPlayerUI.f(this.obb)).setScaleX(f);
                        ((View) SnsSightPlayerUI.f(this.obb)).setScaleY(f);
                        SnsSightPlayerUI.s(this.obb).setAlpha(f);
                    }
                    SnsSightPlayerUI.c(this.obb, true);
                }
                if (translationY > 200.0f) {
                    SnsSightPlayerUI.d(this.obb, false);
                } else if (translationY > 10.0f) {
                    SnsSightPlayerUI.d(this.obb, true);
                }
                if (translationY > 50.0f) {
                    ((View) SnsSightPlayerUI.f(this.obb)).setOnLongClickListener(null);
                }
                if (SnsSightPlayerUI.n(this.obb) != null) {
                    SnsSightPlayerUI.n(this.obb).recycle();
                    SnsSightPlayerUI.a(this.obb, null);
                }
                if (SnsSightPlayerUI.l(this.obb)) {
                    return true;
                }
                break;
        }
        return false;
    }
}
