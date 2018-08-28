package com.tencent.mm.plugin.topstory.ui.a;

class d$1 implements Runnable {
    final /* synthetic */ d oDc;

    d$1(d dVar) {
        this.oDc = dVar;
    }

    public final void run() {
        this.oDc.oCZ.getLayoutParams().width = this.oDc.oCZ.getMeasuredWidth();
        this.oDc.oCZ.getLayoutParams().height = this.oDc.oCX.getMeasuredHeight() + this.oDc.oCY.getMeasuredHeight();
        this.oDc.oCZ.setLayoutParams(this.oDc.oCZ.getLayoutParams());
    }
}
