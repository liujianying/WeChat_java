package com.tencent.mm.plugin.voip.widget;

class a$5 implements Runnable {
    final /* synthetic */ a oVT;

    a$5(a aVar) {
        this.oVT = aVar;
    }

    public final void run() {
        this.oVT.oRM.setVisibility(0);
        a.a(this.oVT).setVisibility(0);
        a.b(this.oVT).setVisibility(4);
    }
}
