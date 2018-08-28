package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;

public class MMSmoothHorizontalScrollView extends HorizontalScrollView {
    private Rect cO = new Rect();
    private Interpolator cp = new DecelerateInterpolator();
    private TranslateAnimation mlt;
    private View txv;
    private float ww;

    public MMSmoothHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFadingEdgeLength(0);
    }

    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            this.txv = getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 1;
        int i2 = 0;
        if (this.txv == null) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.ww = motionEvent.getX();
                break;
            case 1:
            case 3:
                this.ww = 0.0f;
                if (this.cO.isEmpty()) {
                    i = 0;
                }
                if (i != 0) {
                    this.mlt = new TranslateAnimation((float) this.txv.getLeft(), (float) this.cO.left, 0.0f, 0.0f);
                    this.mlt.setInterpolator(this.cp);
                    this.mlt.setDuration((long) Math.abs(this.txv.getLeft() - this.cO.left));
                    this.txv.startAnimation(this.mlt);
                    this.txv.layout(this.cO.left, this.cO.top, this.cO.right, this.cO.bottom);
                    this.cO.setEmpty();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX();
                if (this.ww == 0.0f) {
                    this.ww = x;
                }
                int i3 = ((int) (this.ww - x)) / 2;
                scrollBy(i3, 0);
                this.ww = x;
                int measuredWidth = this.txv.getMeasuredWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight());
                int scrollX = getScrollX();
                if (scrollX == 0 || scrollX == measuredWidth) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    if (this.cO.isEmpty()) {
                        this.cO.set(this.txv.getLeft(), this.txv.getTop(), this.txv.getRight(), this.txv.getBottom());
                    }
                    this.txv.layout(this.txv.getLeft() - i3, this.txv.getTop(), this.txv.getRight() - i3, this.txv.getBottom());
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
