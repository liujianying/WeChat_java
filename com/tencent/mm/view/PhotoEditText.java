package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

public class PhotoEditText extends AppCompatEditText {
    private Paint cN = new Paint(1);
    private int doi;
    private Xfermode uSA;

    public PhotoEditText(Context context) {
        super(context);
        init();
    }

    public PhotoEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        new TextView(getContext()).setTextSize(getTextSize());
        this.uSA = new PorterDuffXfermode(Mode.CLEAR);
    }

    public void setTextBackground(int i) {
        this.doi = i;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        if (this.doi == 0) {
            super.onDraw(canvas);
            return;
        }
        canvas.saveLayerAlpha(null, (int) (getAlpha() * 255.0f), 31);
        this.cN.setColor(this.doi);
        Rect rect = new Rect();
        getLineBounds(0, rect);
        if (getLineCount() == 1) {
            rect.right = (int) (getLayout().getLineWidth(0) + ((float) rect.left));
        } else {
            float f = 0.0f;
            while (i < getLineCount()) {
                float lineWidth = getLayout().getLineWidth(i);
                if (f < lineWidth) {
                    f = lineWidth;
                }
                i++;
            }
            rect.right = (int) (((float) rect.left) + f);
            rect.bottom = rect.top + getLayout().getLineBottom(getLineCount() - 1);
        }
        rect.left = (int) (((float) rect.left) - 18.0f);
        rect.right = (int) (((float) rect.right) + 18.0f);
        if (getLineCount() != 1) {
            this.cN.setXfermode(null);
            this.cN.setColor(this.doi);
            canvas.drawRoundRect(new RectF(rect), 12.0f, 12.0f, this.cN);
            if (getLayout().getLineWidth(getLineCount() - 1) < getLayout().getLineWidth(getLineCount() - 2)) {
                this.cN.setXfermode(this.uSA);
                RectF rectF = new RectF();
                rectF.left = (((float) rect.left) + 36.0f) + getLayout().getLineWidth(getLineCount() - 1);
                rectF.top = (float) (rect.bottom - getLineHeight());
                rectF.right = ((float) rect.right) + 18.0f;
                rectF.bottom = ((float) rect.bottom) + 18.0f;
                canvas.drawRoundRect(rectF, 12.0f, 12.0f, this.cN);
                this.cN.setXfermode(this.uSA);
                canvas.drawRect(new Rect((int) (rectF.left - (getTextSize() / 2.0f)), (int) (rectF.bottom - (getTextSize() / 2.0f)), (int) rectF.left, (int) rectF.bottom), this.cN);
                canvas.drawRect(new Rect((int) (((float) rect.right) - (getTextSize() / 2.0f)), (int) (((float) (rect.top + getLayout().getLineBottom(getLineCount() - 2))) - (getTextSize() / 2.0f)), rect.right, (rect.top + getLayout().getLineBottom(getLineCount() - 2)) + 3), this.cN);
                this.cN.setXfermode(null);
                float textSize = rectF.left - getTextSize();
                if (textSize < ((float) rect.left)) {
                    textSize = (float) rect.left;
                }
                canvas.drawRoundRect(new RectF(new Rect((int) textSize, (int) (((float) rect.bottom) - (getTextSize() / 2.0f)), (int) rectF.left, rect.bottom)), 12.0f, 12.0f, this.cN);
                canvas.drawRoundRect(new RectF(new Rect((int) (((float) rect.right) - getTextSize()), (int) (((float) (rect.bottom - getLineHeight())) - getTextSize()), rect.right, rect.bottom - getLineHeight())), 12.0f, 12.0f, this.cN);
            }
        } else if (!TextUtils.isEmpty(getText())) {
            this.cN.setXfermode(null);
            canvas.drawRoundRect(new RectF(rect), 12.0f, 12.0f, this.cN);
        }
        canvas.restore();
        super.onDraw(canvas);
    }
}
