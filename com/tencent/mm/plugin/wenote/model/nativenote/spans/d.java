package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

public final class d implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private static Path qsO = null;
    private final int qsP;
    public boolean qsQ;

    public final /* synthetic */ f caH() {
        return new d(this.qsP, this.qsQ);
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public d(int i, boolean z, boolean z2, boolean z3) {
        this.qsP = i;
        boolean z4 = z && z3 && !z2;
        this.qsQ = z4;
        if (qsO == null) {
            qsO = new Path();
        }
    }

    private d(int i, boolean z) {
        this.qsP = i;
        this.qsQ = z;
    }

    public final int getLeadingMargin(boolean z) {
        return this.qsQ ? 0 : this.qsP;
    }

    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.qsQ && spanned.getSpanStart(this) == i6) {
            Style style = paint.getStyle();
            paint.setStyle(Style.FILL);
            qsO.reset();
            qsO.addCircle(0.0f, 0.0f, 6.0f, Direction.CW);
            FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i8 = (fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2;
            canvas.save();
            canvas.translate((float) ((i2 * 6) + i), (float) i8);
            canvas.drawPath(qsO, paint);
            canvas.restore();
            paint.setStyle(style);
        }
    }
}
