package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

final class ag$b extends Drawable {
    private final int fi;
    private final String gEw;
    private final TextPaint gJA;
    private Rect gJB;

    /* synthetic */ ag$b(String str, int i, byte b) {
        this(str, i);
    }

    private ag$b(String str, int i) {
        this.gEw = str;
        this.fi = i;
        this.gJA = new TextPaint();
        this.gJA.setAntiAlias(true);
        this.gJA.setTextAlign(Align.CENTER);
        this.gJA.setTextSize((float) this.fi);
        this.gJB = new Rect();
        this.gJA.getTextBounds(this.gEw, 0, this.gEw.length(), this.gJB);
    }

    public final int getIntrinsicWidth() {
        return this.gJB.width();
    }

    public final int getIntrinsicHeight() {
        return this.gJB.height();
    }

    public final void draw(Canvas canvas) {
        canvas.drawText(this.gEw, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.gJA.descent() + this.gJA.ascent()) / 2.0f), this.gJA);
    }

    public final void setAlpha(int i) {
        this.gJA.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.gJA.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
