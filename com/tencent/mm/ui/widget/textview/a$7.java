package com.tencent.mm.ui.widget.textview;

import android.view.ViewTreeObserver.OnScrollChangedListener;

class a$7 implements OnScrollChangedListener {
    final /* synthetic */ a uPp;

    a$7(a aVar) {
        this.uPp = aVar;
    }

    public final void onScrollChanged() {
        if (!this.uPp.uPl && !this.uPp.ccw) {
            this.uPp.uPl = true;
            if (this.uPp.uPe != null) {
                this.uPp.uPe.ctb();
            }
            if (this.uPp.uOZ != null) {
                this.uPp.uOZ.uPs.dismiss();
            }
            if (this.uPp.uPa != null) {
                this.uPp.uPa.uPs.dismiss();
            }
        }
    }
}
