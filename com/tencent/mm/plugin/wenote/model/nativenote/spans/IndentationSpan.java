package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan.Standard;

public class IndentationSpan extends Standard implements f<Integer>, g<Integer> {
    private final boolean qsQ;
    private final int qsR;

    public final /* synthetic */ f caH() {
        return new IndentationSpan(this.qsR, this.qsQ);
    }

    public final /* synthetic */ Object getValue() {
        return Integer.valueOf(this.qsR);
    }

    private IndentationSpan(int i, boolean z) {
        super(i);
        this.qsR = i;
        this.qsQ = z;
    }

    public int getLeadingMargin(boolean z) {
        return this.qsQ ? 0 : this.qsR;
    }
}
