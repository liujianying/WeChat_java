package com.tencent.mm.ui.widget.textview;

class a$1 implements Runnable {
    final /* synthetic */ a uPp;

    a$1(a aVar) {
        this.uPp = aVar;
    }

    public final void run() {
        if (!this.uPp.ccw) {
            this.uPp.cBp();
            if (this.uPp.uOZ != null) {
                this.uPp.a(this.uPp.uOZ);
            }
            if (this.uPp.uPa != null) {
                this.uPp.a(this.uPp.uPa);
            }
        }
    }
}
