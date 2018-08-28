package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomerScrollView extends ScrollView {
    private float uYo;
    private float uYp;
    private float uYq;
    private float uYr;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.uYp = 0.0f;
                this.uYo = 0.0f;
                this.uYq = motionEvent.getX();
                this.uYr = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.uYo += Math.abs(x - this.uYq);
                this.uYp += Math.abs(y - this.uYr);
                this.uYq = x;
                this.uYr = y;
                if (this.uYo > this.uYp) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
