package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.platformtools.c.a;

public class BorderNumView extends View {
    private static int tgX = 22;
    private static int tgY = 105;
    private static int tgZ = 100;
    private Paint cN;
    private Context context = null;
    private int tgW = 100;

    public BorderNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public BorderNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.cN = new Paint();
    }

    public void setPaintNum(int i) {
        this.tgW = i;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.tgW < 100) {
            tgX += 15;
        }
        if (this.tgW >= 1000) {
            tgZ -= 20;
        }
        float b = (float) a.b(this.context, (float) tgX);
        float b2 = (float) a.b(this.context, (float) tgY);
        String str = this.tgW;
        this.cN.setAntiAlias(true);
        this.cN.setTextSize((float) tgZ);
        this.cN.setColor(-11491572);
        this.cN.setStyle(Style.STROKE);
        this.cN.setStrokeWidth(8.0f);
        canvas.drawText(str, b, b2, this.cN);
        this.cN.setTextSize((float) tgZ);
        this.cN.setColor(-1770573);
        this.cN.setStyle(Style.FILL);
        this.cN.setStrokeWidth(8.0f);
        canvas.drawText(str, b, b2, this.cN);
    }
}
