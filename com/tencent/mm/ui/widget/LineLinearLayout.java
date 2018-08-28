package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;

public class LineLinearLayout extends LinearLayout {
    private Paint cN;
    private Rect cO;
    private int uFZ;

    public LineLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        this.cO = new Rect();
        this.cN = new Paint();
        this.cN.setStyle(Style.STROKE);
        this.cN.setColor(-571543826);
        this.cN.setStrokeWidth((float) Math.round(a.getDensity(getContext()) * 0.5f));
        this.uFZ = a.fromDPToPix(context, 44);
    }

    protected void onDraw(Canvas canvas) {
        int measuredHeight = getMeasuredHeight();
        Paint paint = this.cN;
        int i = 1;
        while (true) {
            int i2 = i;
            if (this.uFZ * i2 < measuredHeight) {
                canvas.drawLine(0.0f, (float) (this.uFZ * i2), (float) getMeasuredWidth(), (float) (this.uFZ * i2), paint);
                i = i2 + 1;
            } else {
                super.onDraw(canvas);
                return;
            }
        }
    }
}
