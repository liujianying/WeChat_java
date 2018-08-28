package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.ag;

public class MaskImageView extends TagImageView {
    private int a = 90;
    private int b = 0;
    private boolean bKe = true;
    private int g = 0;
    private ag nLo = new ag(Looper.getMainLooper());
    private Runnable nLp = new 1(this);
    private int r = 0;

    public MaskImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new 2(this));
        super.setContentDescription(getContext().getResources().getString(j.sns_img));
    }

    public void settouchEnable(boolean z) {
        this.bKe = z;
    }

    public final boolean d(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                view.setPressed(true);
                view.invalidate();
                this.nLo.removeCallbacks(this.nLp);
                break;
            case 1:
            case 3:
                this.nLo.post(this.nLp);
                break;
        }
        if (isClickable() || isLongClickable()) {
            return false;
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
