package com.tencent.mm.plugin.facedetect.ui;

class b$3 implements Runnable {
    final /* synthetic */ b iRW;

    b$3(b bVar) {
        this.iRW = bVar;
    }

    public final void run() {
        this.iRW.iQl.setAnimationListener(new 1(this));
        this.iRW.ido.startAnimation(this.iRW.iQl);
    }
}
