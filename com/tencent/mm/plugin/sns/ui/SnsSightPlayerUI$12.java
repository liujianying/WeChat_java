package com.tencent.mm.plugin.sns.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class SnsSightPlayerUI$12 extends SimpleOnGestureListener {
    final /* synthetic */ SnsSightPlayerUI obb;

    SnsSightPlayerUI$12(SnsSightPlayerUI snsSightPlayerUI) {
        this.obb = snsSightPlayerUI;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float translationX = (((View) SnsSightPlayerUI.f(this.obb)).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
        float translationY = (((View) SnsSightPlayerUI.f(this.obb)).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
        if (SnsSightPlayerUI.l(this.obb)) {
            ((View) SnsSightPlayerUI.f(this.obb)).setTranslationX(translationX);
            ((View) SnsSightPlayerUI.f(this.obb)).setTranslationY(translationY);
        }
        return true;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        SnsSightPlayerUI.b(this.obb, true);
        super.onLongPress(motionEvent);
    }
}
