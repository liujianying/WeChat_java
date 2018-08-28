package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CameraFrontSightView extends View {
    Paint cN = new Paint();
    int gEH;
    boolean lnT = false;
    boolean lnU = false;
    boolean lnV = false;
    boolean lnW = false;
    long lnX = 0;
    int lnY;
    int lnZ;
    LayoutParams loa;
    public int mHeight;
    public int mWidth;

    public CameraFrontSightView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CameraFrontSightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void draw(Canvas canvas) {
        canvas.translate((float) (this.lnY / 2), (float) (this.lnZ / 2));
        long currentTimeMillis = System.currentTimeMillis() - this.lnX;
        if (currentTimeMillis > 200) {
            this.lnT = false;
            this.lnU = true;
        }
        if (currentTimeMillis > 800) {
            this.lnU = false;
            this.lnV = true;
        }
        if (currentTimeMillis > 1100) {
            this.lnV = false;
            this.lnW = true;
        }
        if (currentTimeMillis > 1300) {
            this.lnW = false;
            setVisibility(8);
            return;
        }
        float f;
        if (this.lnT) {
            f = (((float) (200 - currentTimeMillis)) / 200.0f) + 1.0f;
            canvas.scale(f, f, (float) (this.lnY / 2), (float) (this.lnZ / 2));
            this.cN.setAlpha((int) ((2.0f - f) * 255.0f));
        } else {
            canvas.scale(1.0f, 1.0f);
        }
        if (this.lnU) {
            f = (((float) ((currentTimeMillis - 200) % 200)) / 200.0f) * 2.0f;
            this.cN.setAlpha((int) (((f > 1.0f ? f - 1.0f : 1.0f - f) * 128.0f) + 127.0f));
        } else {
            this.cN.setAlpha(255);
        }
        if (this.lnW) {
            this.cN.setAlpha((int) ((1.0f - (((float) (currentTimeMillis - 1100)) / 200.0f)) * 255.0f));
        }
        canvas.drawLine(0.0f, 0.0f, (float) this.lnY, 0.0f, this.cN);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.lnZ, this.cN);
        canvas.drawLine((float) this.lnY, 0.0f, (float) this.lnY, (float) this.lnZ, this.cN);
        canvas.drawLine(0.0f, (float) this.lnZ, (float) this.lnY, (float) this.lnZ, this.cN);
        canvas.drawLine(0.0f, (float) (this.lnZ / 2), (float) (this.lnY / 10), (float) (this.lnZ / 2), this.cN);
        canvas.drawLine((float) this.lnY, (float) (this.lnZ / 2), (float) ((this.lnY * 9) / 10), (float) (this.lnZ / 2), this.cN);
        canvas.drawLine((float) (this.lnY / 2), 0.0f, (float) (this.lnY / 2), (float) (this.lnZ / 10), this.cN);
        canvas.drawLine((float) (this.lnY / 2), (float) this.lnZ, (float) (this.lnY / 2), (float) ((this.lnZ * 9) / 10), this.cN);
        invalidate();
    }
}
