package com.tencent.mm.plugin.account.bind.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.account.a.c;

class BindLinkedInUI$12 extends ClickableSpan {
    final /* synthetic */ BindLinkedInUI eFM;

    BindLinkedInUI$12(BindLinkedInUI bindLinkedInUI) {
        this.eFM = bindLinkedInUI;
    }

    public final void onClick(View view) {
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.eFM.getResources().getColor(c.link_color));
        textPaint.setUnderlineText(false);
    }
}
