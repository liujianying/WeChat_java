package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bp.a;

public class CardTagTextView extends TextView {
    private int fillColor = 0;
    private int hAy = 3;
    private RectF hIU = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private Paint hIV = new Paint();
    private int hIW = 9;
    private int hIX = 0;

    public CardTagTextView(Context context) {
        super(context);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CardTagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.hAy = Math.round(a.getDensity(getContext()) * 0.5f);
        this.hIW = a.fromDPToPix(getContext(), 3);
        this.hIX = getCurrentTextColor();
    }

    public void setTextColor(int i) {
        this.hIX = i;
        super.setTextColor(i);
    }

    public void setFillColor(int i) {
        this.fillColor = i;
    }

    protected void onDraw(Canvas canvas) {
        this.hIU.left = (float) this.hIW;
        this.hIU.top = (float) this.hAy;
        this.hIU.right = (float) (getWidth() - this.hIW);
        this.hIU.bottom = (float) (getHeight() - this.hAy);
        if (this.fillColor != 0) {
            this.hIV.setColor(this.fillColor);
            this.hIV.setStyle(Style.FILL);
            canvas.drawRoundRect(this.hIU, (float) ((getHeight() / 2) - this.hAy), (float) ((getHeight() / 2) - this.hAy), this.hIV);
        }
        this.hIV.setColor(this.hIX);
        this.hIV.setStrokeWidth((float) this.hAy);
        this.hIV.setStyle(Style.STROKE);
        canvas.drawRoundRect(this.hIU, (float) ((getHeight() / 2) - this.hAy), (float) ((getHeight() / 2) - this.hAy), this.hIV);
        super.onDraw(canvas);
    }
}
