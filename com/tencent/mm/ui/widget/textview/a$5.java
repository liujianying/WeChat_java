package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class a$5 implements OnAttachStateChangeListener {
    final /* synthetic */ a uPp;

    a$5(a aVar) {
        this.uPp = aVar;
    }

    public final void onViewAttachedToWindow(View view) {
    }

    public final void onViewDetachedFromWindow(View view) {
        a aVar = this.uPp;
        aVar.ih.getViewTreeObserver().removeOnScrollChangedListener(aVar.uOY);
        aVar.ih.getViewTreeObserver().removeOnPreDrawListener(aVar.uPm);
        aVar.cBo();
        aVar.cBn();
        aVar.uOZ = null;
        aVar.uPa = null;
        aVar.uPe = null;
    }
}
