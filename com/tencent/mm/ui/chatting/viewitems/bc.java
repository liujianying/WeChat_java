package com.tencent.mm.ui.chatting.viewitems;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import com.tencent.mm.ui.base.a.a;

abstract class bc extends ClickableSpan implements a {
    private boolean ugB;
    private int ugC;
    private int ugD;

    public bc(int i, int i2) {
        this.ugC = i;
        this.ugD = i2;
    }

    public final void kT(boolean z) {
        this.ugB = z;
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.ugB ? this.ugD : this.ugC);
        textPaint.setUnderlineText(false);
    }
}
