package com.tencent.mm.plugin.appbrand.game.page;

class d$5 implements Runnable {
    final /* synthetic */ d fCR;

    d$5(d dVar) {
        this.fCR = dVar;
    }

    public final void run() {
        this.fCR.fCJ.setVisibility(0);
        this.fCR.fCJ.setImageBitmap(this.fCR.fCK.content);
    }
}
