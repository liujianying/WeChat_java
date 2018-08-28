package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class a$a extends Drawable {
    Paint fBa;
    RectF fBb;
    final /* synthetic */ a fBc;

    private a$a(a aVar) {
        this.fBc = aVar;
        this.fBa = new Paint(1);
        this.fBb = new RectF();
        this.fBa.setColor(-12748166);
        this.fBa.setStyle(Style.FILL);
    }

    /* synthetic */ a$a(a aVar, byte b) {
        this(aVar);
    }

    public final void draw(Canvas canvas) {
        float height = ((float) canvas.getHeight()) / 2.0f;
        RectF rectF = this.fBb;
        this.fBb.top = 0.0f;
        rectF.left = 0.0f;
        rectF = this.fBb;
        float f = height * 2.0f;
        this.fBb.bottom = f;
        rectF.right = f;
        canvas.drawArc(this.fBb, 90.0f, 180.0f, false, this.fBa);
        this.fBb.left = ((float) canvas.getWidth()) - (height * 2.0f);
        this.fBb.top = 0.0f;
        this.fBb.right = (float) canvas.getWidth();
        this.fBb.bottom = (float) canvas.getHeight();
        canvas.drawArc(this.fBb, -90.0f, 180.0f, false, this.fBa);
        canvas.drawRect(height - 1.0f, 0.0f, (((float) this.fBc.getWidth()) - height) + 1.0f, (float) this.fBc.getHeight(), this.fBa);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -1;
    }
}
