package com.tencent.mm.plugin.sns.ui;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class SnsOnlineVideoActivity$5 implements OnTouchListener {
    final /* synthetic */ SnsOnlineVideoActivity nZl;

    SnsOnlineVideoActivity$5(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.nZl = snsOnlineVideoActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        float f = 1.0f;
        SnsOnlineVideoActivity.d(this.nZl).onTouchEvent(motionEvent);
        if (SnsOnlineVideoActivity.e(this.nZl) == null) {
            SnsOnlineVideoActivity.a(this.nZl, VelocityTracker.obtain());
        }
        if (SnsOnlineVideoActivity.e(this.nZl) != null) {
            SnsOnlineVideoActivity.e(this.nZl).addMovement(motionEvent);
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                SnsOnlineVideoActivity.a(this.nZl, motionEvent.getX());
                SnsOnlineVideoActivity.b(this.nZl, motionEvent.getY());
                if (SnsOnlineVideoActivity.f(this.nZl)) {
                    SnsOnlineVideoActivity.g(this.nZl);
                    SnsOnlineVideoActivity.b(this.nZl, false);
                    break;
                }
                break;
            case 1:
                if (SnsOnlineVideoActivity.f(this.nZl)) {
                    SnsOnlineVideoActivity.c(this.nZl).setPivotX((float) (SnsOnlineVideoActivity.a(this.nZl).getWidth() / 2));
                    SnsOnlineVideoActivity.c(this.nZl).setPivotY((float) (SnsOnlineVideoActivity.a(this.nZl).getHeight() / 2));
                    SnsOnlineVideoActivity.c(this.nZl).setScaleX(1.0f);
                    SnsOnlineVideoActivity.c(this.nZl).setScaleY(1.0f);
                    SnsOnlineVideoActivity.c(this.nZl).setTranslationX(0.0f);
                    SnsOnlineVideoActivity.c(this.nZl).setTranslationY(0.0f);
                    SnsOnlineVideoActivity.h(this.nZl).setAlpha(1.0f);
                    SnsOnlineVideoActivity.c(this.nZl, 1.0f);
                    SnsOnlineVideoActivity.c(this.nZl, false);
                    SnsOnlineVideoActivity.a(this.nZl, false);
                    return true;
                } else if (!SnsOnlineVideoActivity.b(this.nZl) || SnsOnlineVideoActivity.i(this.nZl)) {
                    SnsOnlineVideoActivity.a(this.nZl, false);
                    break;
                } else {
                    this.nZl.ayH();
                    SnsOnlineVideoActivity.a(this.nZl, false);
                    return true;
                }
                break;
            case 2:
                VelocityTracker e = SnsOnlineVideoActivity.e(this.nZl);
                e.computeCurrentVelocity(BaseReportManager.MAX_READ_COUNT);
                int xVelocity = (int) e.getXVelocity();
                int yVelocity = (int) e.getYVelocity();
                float translationX = SnsOnlineVideoActivity.c(this.nZl).getTranslationX();
                float translationY = SnsOnlineVideoActivity.c(this.nZl).getTranslationY();
                SnsOnlineVideoActivity.a(this.nZl, (int) translationX);
                SnsOnlineVideoActivity.b(this.nZl, (int) translationY);
                x.d("MicroMsg.SnsOnlineVideoActivity", "dancy scaled:%s, tx:%s, ty:%s, vx:%s, vy:%s", new Object[]{Boolean.valueOf(SnsOnlineVideoActivity.b(this.nZl)), Float.valueOf(translationX), Float.valueOf(translationY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity)});
                if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || SnsOnlineVideoActivity.i(this.nZl)) && !SnsOnlineVideoActivity.b(this.nZl)) {
                    SnsOnlineVideoActivity.c(this.nZl, false);
                } else {
                    translationX = 1.0f - (translationY / ((float) SnsOnlineVideoActivity.a(this.nZl).getHeight()));
                    if (translationX <= 1.0f) {
                        f = translationX;
                    }
                    if (((yVelocity > 0 && f < SnsOnlineVideoActivity.j(this.nZl)) || yVelocity < 0) && ((double) f) >= 0.5d) {
                        x.d("MicroMsg.SnsOnlineVideoActivity", "dancy scale:%s", new Object[]{Float.valueOf(f)});
                        SnsOnlineVideoActivity.c(this.nZl, f);
                        SnsOnlineVideoActivity.c(this.nZl).setPivotX((float) (SnsOnlineVideoActivity.a(this.nZl).getWidth() / 2));
                        SnsOnlineVideoActivity.c(this.nZl).setPivotY((float) (SnsOnlineVideoActivity.a(this.nZl).getHeight() / 2));
                        SnsOnlineVideoActivity.c(this.nZl).setScaleX(f);
                        SnsOnlineVideoActivity.c(this.nZl).setScaleY(f);
                        SnsOnlineVideoActivity.c(this.nZl).setTranslationY(translationY);
                        SnsOnlineVideoActivity.h(this.nZl).setAlpha(f);
                    }
                    SnsOnlineVideoActivity.c(this.nZl, true);
                }
                if (translationY > 200.0f) {
                    SnsOnlineVideoActivity.b(this.nZl, false);
                } else if (translationY > 10.0f) {
                    SnsOnlineVideoActivity.b(this.nZl, true);
                }
                if (translationY > 50.0f) {
                    SnsOnlineVideoActivity.c(this.nZl).setOnLongClickListener(null);
                }
                if (SnsOnlineVideoActivity.e(this.nZl) != null) {
                    SnsOnlineVideoActivity.e(this.nZl).recycle();
                    SnsOnlineVideoActivity.a(this.nZl, null);
                }
                if (SnsOnlineVideoActivity.b(this.nZl)) {
                    return true;
                }
                break;
        }
        return false;
    }
}
