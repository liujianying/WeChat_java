package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import b.c.b.e;

public class RadarSpecialSmoothScrollView extends ScrollView {
    private final Rect cO = new Rect();
    private RadarSpecialTableLayout mls;
    private TranslateAnimation mlt;
    private final a mlu = new a();
    private float wx;

    public RadarSpecialSmoothScrollView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (!(childAt instanceof RadarSpecialTableLayout)) {
                childAt = null;
            }
            this.mls = (RadarSpecialTableLayout) childAt;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        e.i(motionEvent, "ev");
        if (this.mls == null) {
            return super.onTouchEvent(motionEvent);
        }
        RadarSpecialTableLayout radarSpecialTableLayout;
        switch (motionEvent.getAction()) {
            case 0:
                this.wx = motionEvent.getY();
                break;
            case 1:
                this.wx = 0.0f;
                if (this.cO.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    radarSpecialTableLayout = this.mls;
                    if (radarSpecialTableLayout == null) {
                        e.cJM();
                    }
                    this.mlt = new TranslateAnimation(0.0f, 0.0f, (float) (radarSpecialTableLayout.getTop() - this.cO.top), 0.0f);
                    TranslateAnimation translateAnimation = this.mlt;
                    if (translateAnimation == null) {
                        e.cJM();
                    }
                    translateAnimation.setInterpolator((Interpolator) this.mlu);
                    TranslateAnimation translateAnimation2 = this.mlt;
                    if (translateAnimation2 == null) {
                        e.cJM();
                    }
                    radarSpecialTableLayout = this.mls;
                    if (radarSpecialTableLayout == null) {
                        e.cJM();
                    }
                    translateAnimation2.setDuration((long) Math.abs(radarSpecialTableLayout.getTop() - this.cO.top));
                    radarSpecialTableLayout = this.mls;
                    if (radarSpecialTableLayout == null) {
                        e.cJM();
                    }
                    radarSpecialTableLayout.startAnimation(this.mlt);
                    RadarSpecialTableLayout radarSpecialTableLayout2 = this.mls;
                    if (radarSpecialTableLayout2 == null) {
                        e.cJM();
                    }
                    radarSpecialTableLayout2.s(this.cO.left, this.cO.top, this.cO.right, this.cO.bottom);
                    this.cO.setEmpty();
                    break;
                }
                break;
            case 2:
                float y = motionEvent.getY();
                if (this.wx == 0.0f) {
                    this.wx = y;
                }
                RadarSpecialTableLayout radarSpecialTableLayout3 = this.mls;
                if (radarSpecialTableLayout3 == null) {
                    e.cJM();
                }
                int measuredHeight = radarSpecialTableLayout3.getMeasuredHeight() - getHeight();
                int scrollY = getScrollY();
                if (!(scrollY == 0 || scrollY == measuredHeight)) {
                    i = 0;
                }
                if (i != 0) {
                    RadarSpecialTableLayout radarSpecialTableLayout4;
                    RadarSpecialTableLayout radarSpecialTableLayout5;
                    int right;
                    RadarSpecialTableLayout radarSpecialTableLayout6;
                    i = (int) (this.wx - y);
                    scrollBy(0, i);
                    if (this.cO.isEmpty()) {
                        Rect rect = this.cO;
                        radarSpecialTableLayout3 = this.mls;
                        if (radarSpecialTableLayout3 == null) {
                            e.cJM();
                        }
                        measuredHeight = radarSpecialTableLayout3.getLeft();
                        radarSpecialTableLayout4 = this.mls;
                        if (radarSpecialTableLayout4 == null) {
                            e.cJM();
                        }
                        scrollY = radarSpecialTableLayout4.getTop();
                        radarSpecialTableLayout5 = this.mls;
                        if (radarSpecialTableLayout5 == null) {
                            e.cJM();
                        }
                        right = radarSpecialTableLayout5.getRight();
                        radarSpecialTableLayout6 = this.mls;
                        if (radarSpecialTableLayout6 == null) {
                            e.cJM();
                        }
                        rect.set(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom());
                    }
                    radarSpecialTableLayout = this.mls;
                    if (radarSpecialTableLayout == null) {
                        e.cJM();
                    }
                    radarSpecialTableLayout3 = this.mls;
                    if (radarSpecialTableLayout3 == null) {
                        e.cJM();
                    }
                    measuredHeight = radarSpecialTableLayout3.getLeft();
                    radarSpecialTableLayout4 = this.mls;
                    if (radarSpecialTableLayout4 == null) {
                        e.cJM();
                    }
                    scrollY = radarSpecialTableLayout4.getTop() - (i / 2);
                    radarSpecialTableLayout5 = this.mls;
                    if (radarSpecialTableLayout5 == null) {
                        e.cJM();
                    }
                    right = radarSpecialTableLayout5.getRight();
                    radarSpecialTableLayout6 = this.mls;
                    if (radarSpecialTableLayout6 == null) {
                        e.cJM();
                    }
                    radarSpecialTableLayout.s(measuredHeight, scrollY, right, radarSpecialTableLayout6.getBottom() - (i / 2));
                } else {
                    scrollBy(0, ((int) (this.wx - y)) / 2);
                }
                this.wx = y;
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
