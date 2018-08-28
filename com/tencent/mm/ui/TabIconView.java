package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.c;

public class TabIconView extends ImageView {
    private Paint fBa;
    private Bitmap tqE;
    private Bitmap tqF;
    private Bitmap tqG;
    private Rect tqH;
    private Rect tqI;
    private Rect tqJ;
    private int tqK = 0;

    public TabIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TabIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void g(int i, int i2, int i3, boolean z) {
        if (z) {
            this.tqE = c.CW(i);
            this.tqF = c.CW(i3);
            this.tqG = c.CW(i2);
        } else {
            this.tqE = c.CV(i);
            this.tqF = c.CV(i3);
            this.tqG = c.CV(i2);
        }
        this.tqH = new Rect(0, 0, this.tqE.getWidth(), this.tqE.getHeight());
        this.tqI = new Rect(0, 0, this.tqF.getWidth(), this.tqF.getHeight());
        this.tqJ = new Rect(0, 0, this.tqG.getWidth(), this.tqG.getHeight());
        this.fBa = new Paint(1);
    }

    public void setFocusAlpha(int i) {
        this.tqK = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fBa != null) {
            if (this.tqK < 128) {
                this.fBa.setAlpha(255 - (this.tqK * 2));
                canvas.drawBitmap(this.tqF, null, this.tqI, this.fBa);
                this.fBa.setAlpha(this.tqK * 2);
                canvas.drawBitmap(this.tqG, null, this.tqJ, this.fBa);
                return;
            }
            this.fBa.setAlpha(255 - (this.tqK * 2));
            canvas.drawBitmap(this.tqG, null, this.tqJ, this.fBa);
            this.fBa.setAlpha(this.tqK * 2);
            canvas.drawBitmap(this.tqE, null, this.tqH, this.fBa);
        }
    }
}
