package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

public class NewPullDownView extends View {
    private float trp = 0.0f;
    private boolean trv = false;
    private float trw = (20.0f * getResources().getDisplayMetrics().density);
    private float trx = ((14.0f * getResources().getDisplayMetrics().density) - (getResources().getDisplayMetrics().density * 4.0f));
    private Paint try = new Paint(1);
    private Paint trz;

    public NewPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.try.setStyle(Style.FILL);
        this.try.setColor(-4408132);
        this.trz = new Paint(1);
        this.trz.setStyle(Style.STROKE);
        this.trz.setColor(0);
        this.trz.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        this.trz.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = (float) (getMeasuredWidth() / 2);
        float measuredHeight = (float) (getMeasuredHeight() / 2);
        canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), null, 31);
        canvas.drawCircle(measuredWidth, measuredHeight, (this.trp * this.trw) / 2.0f, this.try);
        if (this.trp >= 0.4f) {
            canvas.drawCircle(measuredWidth, measuredHeight, (((this.trp - 0.4f) / 0.6f) * this.trx) / 2.0f, this.trz);
        }
        canvas.restore();
    }

    public void setVerticalScrollPercent(float f) {
        x.i("MicroMsg.PullDownView", "[setVerticalScrollPercent] percent:%s", new Object[]{Float.valueOf(f)});
        if (this.trv) {
            f = 1.0f - f;
        }
        this.trp = Math.max(0.0f, Math.min(f, 1.0f));
        postInvalidate();
    }
}
