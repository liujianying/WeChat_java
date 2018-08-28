package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public final class a extends View {
    private Paint cN;
    private int hPK;
    private int mType = 2;
    private int pHK;
    private RectF qrH;
    private RectF qrI;
    private RectF qrJ;
    private RectF qrK;
    private int qrL;
    private int qrM;
    private int qrN;
    private a qrO;

    public a(Context context, int i, int i2, int i3, int i4, a aVar) {
        super(context);
        this.mType = i;
        this.qrM = i2;
        this.pHK = i3;
        this.qrL = (this.qrM * 2) / 5;
        this.hPK = this.qrL;
        this.qrN = (this.qrL * 3) / 4;
        this.cN = new Paint(1);
        this.cN.setColor(i4);
        this.qrO = aVar;
        this.qrH = new RectF((float) this.hPK, (float) this.qrM, (float) (this.hPK + (this.qrL * 2)), (float) (this.qrM + (this.qrL * 2)));
        this.qrI = new RectF((float) (this.qrN - this.qrL), (float) this.qrM, (float) (this.qrN + this.qrL), (float) (this.qrM + (this.qrL * 2)));
        this.qrJ = new RectF((float) this.hPK, (float) this.qrM, (float) (this.hPK + (this.qrL * 2)), (float) (this.qrM + (this.qrL * 2)));
        this.qrK = new RectF((float) (this.hPK + this.pHK), (float) this.qrM, (float) ((this.hPK + this.pHK) + (this.qrL * 2)), (float) (this.qrM + (this.qrL * 2)));
    }

    public final int getType() {
        return this.mType;
    }

    public final int getViewHeight() {
        return (this.qrM + (this.qrL * 2)) + this.hPK;
    }

    public final int getViewWidth() {
        if (this.mType == 3 || this.mType == 4) {
            return (this.hPK + this.qrL) + this.qrN;
        }
        return this.pHK + ((this.hPK + this.qrL) * 2);
    }

    public final int getOffsetForCursorMid() {
        return (this.hPK + this.qrL) + 1;
    }

    public final int getViewPadding() {
        return this.hPK;
    }

    protected final void onDraw(Canvas canvas) {
        switch (this.mType) {
            case 2:
                canvas.drawRect((float) (this.hPK + this.qrL), 0.0f, (float) ((this.hPK + this.qrL) + this.pHK), (float) (this.qrM + (this.qrL * 2)), this.cN);
                canvas.drawArc(this.qrJ, 90.0f, 180.0f, true, this.cN);
                canvas.drawArc(this.qrK, 270.0f, 180.0f, true, this.cN);
                return;
            case 3:
                canvas.drawRect((float) (((this.hPK + this.qrL) + this.qrN) - this.pHK), 0.0f, (float) ((this.hPK + this.qrL) + this.qrN), (float) this.qrM, this.cN);
                canvas.drawArc(this.qrH, 90.0f, 180.0f, true, this.cN);
                canvas.drawRect((float) (this.hPK + this.qrL), (float) this.qrM, (float) ((this.hPK + this.qrL) + this.qrN), (float) (this.qrM + (this.qrL * 2)), this.cN);
                return;
            case 4:
                canvas.drawRect(0.0f, 0.0f, (float) this.pHK, (float) this.qrM, this.cN);
                canvas.drawRect(0.0f, (float) this.qrM, (float) this.qrN, (float) (this.qrM + (this.qrL * 2)), this.cN);
                canvas.drawArc(this.qrI, 270.0f, 180.0f, true, this.cN);
                return;
            default:
                return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.qrO != null) {
            this.qrO.a(this.mType, motionEvent);
        }
        return true;
    }
}
