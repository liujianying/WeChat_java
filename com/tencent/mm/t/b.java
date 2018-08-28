package com.tencent.mm.t;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.mm.bx.a;

public final class b implements Cloneable {
    private static Paint dnG;
    private float dD = 1.0f;
    private float jW = ((float) a.aH(5.0f));
    private Path ks;
    public int pN;

    static {
        Paint paint = new Paint();
        dnG = paint;
        paint.setAntiAlias(true);
        dnG.setStyle(Style.STROKE);
        dnG.setStrokeCap(Cap.ROUND);
    }

    public b(Path path, float f, int i) {
        this.ks = path;
        this.dD = f;
        this.pN = i;
    }

    public final void draw(Canvas canvas) {
        dnG.setColor(this.pN);
        dnG.setStrokeWidth(this.jW * this.dD);
        if (!this.ks.isEmpty()) {
            canvas.drawPath(this.ks, dnG);
        }
    }
}
