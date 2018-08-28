package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class GyroView extends View {
    private float To = (20.0f * getResources().getDisplayMetrics().density);
    private Paint cN = new Paint(1);
    private float trp = 0.0f;
    private float trq = 0.0f;
    private float trr = (100.0f * getResources().getDisplayMetrics().density);
    private float trs = (40.0f * getResources().getDisplayMetrics().density);
    private float trt = (10.0f * getResources().getDisplayMetrics().density);
    private float tru = (6.0f * getResources().getDisplayMetrics().density);
    private boolean trv = false;

    public GyroView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cN.setStyle(Style.FILL);
        this.cN.setColor(-4737097);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = ((float) getMeasuredWidth()) / 2.0f;
        float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
        if (this.trq > 0.0f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (this.trt / 2.0f) - ((this.trq * (this.trt - this.tru)) / 2.0f), this.cN);
            canvas.drawCircle(measuredWidth - (this.trq * this.To), measuredHeight, this.tru / 2.0f, this.cN);
            canvas.drawCircle(measuredWidth + (this.trq * this.To), measuredHeight, this.tru / 2.0f, this.cN);
            return;
        }
        canvas.drawCircle(measuredWidth, measuredHeight, (this.trp * this.trt) / 2.0f, this.cN);
    }

    public void setVerticalScroll(float f) {
        float f2 = (f - this.trs) / (this.trr - this.trs);
        if (this.trv) {
            f2 = 1.0f - f2;
        }
        this.trq = Math.max(0.0f, Math.min(f2, 1.0f));
        f2 = f / this.trs;
        if (this.trv) {
            f2 = 1.0f - f2;
        }
        this.trp = Math.max(0.0f, Math.min(f2, 1.0f));
        postInvalidate();
    }
}
