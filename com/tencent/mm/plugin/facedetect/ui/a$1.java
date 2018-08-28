package com.tencent.mm.plugin.facedetect.ui;

class a$1 implements Runnable {
    final /* synthetic */ a iQo;

    a$1(a aVar) {
        this.iQo = aVar;
    }

    public final void run() {
        a.b(this.iQo).setAnimationListener(new 1(this));
        a.a(this.iQo).startAnimation(a.b(this.iQo));
    }
}
