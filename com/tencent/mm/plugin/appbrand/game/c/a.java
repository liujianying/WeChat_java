package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;

final class a extends AppCompatButton {
    private RectF fAW;
    private boolean fAX;
    private float fAY;
    private float fAZ;

    public a(Context context) {
        super(context);
        setGravity(17);
        setText("vConsole");
        setTextColor(-1);
        float f = getContext().getResources().getDisplayMetrics().density;
        setPadding((int) (13.0f * f), (int) (4.0f * f), (int) (13.0f * f), (int) (f * 6.0f));
        setBackgroundDrawable(new a(this, (byte) 0));
    }

    private boolean B(float f, float f2) {
        if (this.fAW == null) {
            return false;
        }
        return this.fAW.contains(f, f2);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.fAW = new RectF(getX(), getY(), getX() + ((float) getWidth()), getY() + ((float) getHeight()));
                this.fAX = false;
                break;
            case 1:
                if (!this.fAX && B(motionEvent.getRawX(), motionEvent.getRawY())) {
                    performClick();
                    break;
                }
            case 2:
                if (this.fAX || !B(motionEvent.getRawX(), motionEvent.getRawY())) {
                    setX(getX() + (motionEvent.getRawX() - this.fAY));
                    setY(getY() + (motionEvent.getRawY() - this.fAZ));
                    requestLayout();
                    this.fAX = true;
                    break;
                }
        }
        this.fAY = motionEvent.getRawX();
        this.fAZ = motionEvent.getRawY();
        return true;
    }
}
