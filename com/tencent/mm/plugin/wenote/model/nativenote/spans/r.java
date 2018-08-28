package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public final class r implements ParagraphStyle {
    public final q qsK;
    public final ParagraphStyle qtr;

    public r(q qVar, ParagraphStyle paragraphStyle) {
        this.qsK = qVar;
        this.qtr = paragraphStyle;
    }

    public final String toString() {
        return this.qsK.name() + " - " + this.qtr.getClass().getSimpleName();
    }
}
