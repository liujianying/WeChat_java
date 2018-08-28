package com.tencent.mm.plugin.appbrand.widget.e;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b extends Drawable {
    public float Tl = 0.0f;
    final Paint cN = new Paint(1);
    private final RectF gMn = new RectF();
    private float gMo = ((float) a.fromDPToPix(ad.getContext(), 3));
    private final Path ks = new Path();

    public final void draw(Canvas canvas) {
        float width = this.gMn.width();
        float height = this.gMn.height();
        float f = this.gMn.left;
        float f2 = this.gMn.top;
        float f3 = this.gMn.right;
        float f4 = this.gMn.bottom;
        width = Math.min(this.Tl, Math.min(width, height) * 0.5f);
        canvas.drawRoundRect(new RectF(f + this.gMo, f2 + this.gMo, f3 - this.gMo, f4 - this.gMo), width, width, this.cN);
        canvas.drawPath(this.ks, this.cN);
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.gMn.set((float) i, (float) i2, (float) i3, (float) i4);
        float f = ((float) (i + i3)) / 2.0f;
        this.ks.moveTo(f, (float) i4);
        this.ks.lineTo(f - this.gMo, ((float) i4) - this.gMo);
        this.ks.lineTo(f + this.gMo, ((float) i4) - this.gMo);
        this.ks.close();
    }

    public final void setAlpha(int i) {
        this.cN.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.cN.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
