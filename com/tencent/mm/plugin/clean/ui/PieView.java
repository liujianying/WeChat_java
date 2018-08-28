package com.tencent.mm.plugin.clean.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    private int bUw = 0;
    private int fHo = 6;
    private Paint hRB;
    private Paint hRC;
    private Paint hRD;
    private Paint hRE;
    private Paint hRF;
    private Paint hRG;
    private Paint hRH;
    private int hRI;
    private int hRJ;
    private int hRK;
    private int hRL;
    private int hRM;
    private int hRN;
    private int hRO = 0;
    private int hRP = -90;

    public PieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public void setStage(int i) {
        this.bUw = i;
    }

    public void setGreenTargetAngle(int i) {
        this.hRM = i;
    }

    public void setDeepGrayTargetAngle(int i) {
        this.hRN = i;
    }

    public void setOtherAccTargetAngle(int i) {
        this.hRO = i;
    }

    private void initView() {
        this.hRB = ol(-1);
        this.hRC = ol(-657931);
        this.hRD = ol(-2565928);
        this.hRE = ol(-15223279);
        this.hRF = ol(-7876878);
        this.hRG = ol(-7876878);
        this.hRH = ol(-1644567);
    }

    private static Paint ol(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Style.FILL);
        paint.setColor(i);
        return paint;
    }

    public void draw(Canvas canvas) {
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) ((getMeasuredHeight() / 2) + getTop());
        float measuredHeight2 = (float) ((getMeasuredHeight() / 3) + 15);
        float f = measuredHeight2 - 15.0f;
        RectF rectF = new RectF(measuredWidth - measuredHeight2, measuredHeight - measuredHeight2, measuredWidth + measuredHeight2, measuredHeight + measuredHeight2);
        if (this.bUw == 0) {
            canvas.drawCircle(measuredWidth, measuredHeight, measuredHeight2, this.hRC);
            canvas.drawArc(rectF, (float) this.hRP, 45.0f, true, this.hRD);
            canvas.drawCircle(measuredWidth, measuredHeight, f, this.hRB);
            this.hRP += 4;
            this.hRP %= 360;
        }
        if (this.bUw == 1) {
            float f2 = 10.0f + measuredHeight2;
            RectF rectF2 = new RectF(measuredWidth - f2, measuredHeight - f2, measuredWidth + f2, f2 + measuredHeight);
            this.hRI = F(this.hRI, this.hRM, this.fHo);
            canvas.drawArc(rectF2, -90.0f, (float) this.hRI, true, this.hRE);
            if (this.hRO <= 0) {
                if (this.hRI == this.hRM) {
                    this.hRK = F(this.hRK, this.hRN, this.fHo);
                    canvas.drawArc(rectF, (float) (this.hRM - 90), (float) this.hRK, true, this.hRF);
                }
                if (this.hRK == this.hRN) {
                    this.hRJ = F(this.hRJ, (360 - this.hRM) - this.hRN, this.fHo);
                    canvas.drawArc(rectF, (float) ((this.hRM - 90) + this.hRN), (float) this.hRJ, true, this.hRG);
                }
            } else {
                if (this.hRI == this.hRM) {
                    this.hRL = F(this.hRL, this.hRO, this.fHo);
                    canvas.drawArc(rectF2, (float) (this.hRM - 90), (float) this.hRL, true, this.hRH);
                }
                if (this.hRL == this.hRO) {
                    this.hRK = F(this.hRK, this.hRN, this.fHo);
                    canvas.drawArc(rectF, (float) ((this.hRO - 90) + this.hRM), (float) this.hRK, true, this.hRF);
                }
                if (this.hRK == this.hRN) {
                    this.hRJ = F(this.hRJ, ((360 - this.hRM) - this.hRN) - this.hRO, this.fHo);
                    canvas.drawArc(rectF, (float) (((this.hRM - 90) + this.hRN) + this.hRO), (float) this.hRJ, true, this.hRG);
                }
            }
        }
        invalidate();
    }

    private static int F(int i, int i2, int i3) {
        if (i2 - i >= i3) {
            return i + i3;
        }
        if (i - i2 > i3) {
            return i - i3;
        }
        return i2;
    }
}
