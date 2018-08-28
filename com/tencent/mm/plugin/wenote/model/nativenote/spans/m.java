package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public class m implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    public static float qta = 0.0f;
    private float kgD = 10.0f;
    private final int qsP;
    public boolean qsQ;
    private final int qsY;
    private float qsZ;

    public final /* synthetic */ f caH() {
        return new m(this.qsY, this.qsP, this.qsQ);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public m(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.qsY = i;
        this.qsP = i2;
        boolean z4 = z && z3 && !z2;
        this.qsQ = z4;
    }

    private m(int i, int i2, boolean z) {
        this.qsY = i;
        this.qsP = i2;
        this.qsQ = z;
    }

    public int getLeadingMargin(boolean z) {
        qta = (float) Math.max(Math.round(this.qsZ + 2.0f > qta ? this.qsZ + 2.0f : qta), this.qsP);
        return this.qsQ ? 0 : (int) qta;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.qsQ && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Style.FILL);
            this.kgD = (float) (i4 - i3);
            this.qsZ = paint.measureText(this.qsY + ".");
            canvas.drawText(this.qsY + ".", (float) i, (float) i4, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
        }
    }
}
