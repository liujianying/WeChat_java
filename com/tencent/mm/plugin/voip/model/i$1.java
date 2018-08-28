package com.tencent.mm.plugin.voip.model;

class i$1 implements Runnable {
    final /* synthetic */ i oJs;

    i$1(i iVar) {
        this.oJs = iVar;
    }

    public final void run() {
        this.oJs.oJq.dismiss();
        this.oJs.oJq = null;
    }
}
