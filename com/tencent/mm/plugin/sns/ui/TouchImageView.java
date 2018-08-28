package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class TouchImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean bKe = true;
    private int g = 0;
    ag nLo;
    Runnable nLp;
    private Rect ohZ = new Rect();
    private Paint oia = new Paint();
    private int r = 0;

    public TouchImageView(Context context) {
        super(context);
        init();
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void settouchEnable(boolean z) {
        this.bKe = z;
    }

    private void init() {
        this.nLo = new ag();
        this.nLp = new 1(this);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!TouchImageView.this.bKe) {
                    return false;
                }
                TouchImageView touchImageView = TouchImageView.this;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        touchImageView.nLo.removeCallbacks(touchImageView.nLp);
                        break;
                    case 1:
                    case 3:
                        touchImageView.nLo.post(touchImageView.nLp);
                        break;
                }
                if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            this.ohZ.left = getPaddingLeft();
            this.ohZ.top = getPaddingTop();
            this.ohZ.right = getWidth() - getPaddingRight();
            this.ohZ.bottom = getHeight() - getPaddingBottom();
            this.oia.setARGB(this.a, this.r, this.g, this.b);
            canvas.drawRect(this.ohZ, this.oia);
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    }
}
