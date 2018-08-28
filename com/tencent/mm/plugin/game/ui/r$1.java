package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class r$1 implements OnGlobalLayoutListener {
    final /* synthetic */ TextView kbQ;
    final /* synthetic */ TextView kbR;
    final /* synthetic */ r kbS;

    r$1(r rVar, TextView textView, TextView textView2) {
        this.kbS = rVar;
        this.kbQ = textView;
        this.kbR = textView2;
    }

    public final void onGlobalLayout() {
        if (this.kbQ.getLineCount() > 1) {
            this.kbQ.setMaxLines(2);
            this.kbR.setMaxLines(1);
            return;
        }
        this.kbR.setMaxLines(2);
    }
}
