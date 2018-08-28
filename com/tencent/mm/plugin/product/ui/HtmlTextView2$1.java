package com.tencent.mm.plugin.product.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class HtmlTextView2$1 implements OnTouchListener {
    final /* synthetic */ HtmlTextView2 lSe;

    HtmlTextView2$1(HtmlTextView2 htmlTextView2) {
        this.lSe = htmlTextView2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
    }
}
