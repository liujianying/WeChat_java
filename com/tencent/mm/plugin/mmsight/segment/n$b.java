package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class n$b extends Drawable {
    final /* synthetic */ n lmL;
    boolean lmQ = false;
    private Drawable lmR;
    private Drawable lmS;

    public n$b(n nVar, Drawable drawable, Drawable drawable2) {
        this.lmL = nVar;
        this.lmR = drawable;
        this.lmS = drawable2;
        this.lmQ = false;
    }

    public final void draw(Canvas canvas) {
        Drawable drawable;
        if (this.lmQ) {
            drawable = this.lmR;
        } else {
            drawable = this.lmS;
        }
        if (!getBounds().equals(drawable.getBounds())) {
            drawable.setBounds(getBounds());
        }
        drawable.draw(canvas);
    }

    public final void setAlpha(int i) {
        this.lmR.setAlpha(i);
        this.lmS.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.lmR.setColorFilter(colorFilter);
        this.lmS.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
