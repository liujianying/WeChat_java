package com.tencent.mm.ui.widget.textview;

import android.view.ViewTreeObserver.OnPreDrawListener;

class a$6 implements OnPreDrawListener {
    final /* synthetic */ a uPp;

    a$6(a aVar) {
        this.uPp = aVar;
    }

    public final boolean onPreDraw() {
        if (this.uPp.uPl) {
            this.uPp.uPl = false;
            a aVar = this.uPp;
            aVar.ih.removeCallbacks(aVar.uPo);
            aVar.ih.postDelayed(aVar.uPo, 100);
        }
        return true;
    }
}
