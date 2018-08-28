package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LineBackgroundSpan;
import android.widget.TextView;

public final class c implements LineBackgroundSpan {
    public int end;
    private TextView lSz;
    private final int pN;
    private Rect rect = new Rect();
    public int start;

    public c(TextView textView, int i, int i2, int i3) {
        this.pN = i;
        this.start = i2;
        this.end = i3;
        this.lSz = textView;
    }

    public final void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
        if (this.end >= i6 && this.start <= i7) {
            Rect rect;
            int color = paint.getColor();
            Layout layout = this.lSz.getLayout();
            int lineForOffset = layout.getLineForOffset(this.start);
            int lineForOffset2 = layout.getLineForOffset(this.end);
            if (lineForOffset <= i8 && i8 <= lineForOffset2) {
                if (lineForOffset == i8) {
                    i = (int) layout.getPrimaryHorizontal(this.start);
                }
                if (lineForOffset2 == i8) {
                    i2 = (int) layout.getPrimaryHorizontal(this.end);
                } else {
                    i2 = (int) layout.getLineWidth(i8);
                }
            }
            int descent = (int) (((float) i4) + paint.descent());
            this.rect.left = i;
            if (this.start == i6) {
                rect = this.rect;
                rect.left -= 4;
            }
            this.rect.right = i2;
            if (this.end == i2) {
                rect = this.rect;
                rect.right += 4;
            }
            this.rect.top = i3;
            this.rect.bottom = descent;
            paint.setColor(this.pN);
            canvas.drawRect(this.rect, paint);
            paint.setColor(color);
        }
    }
}
