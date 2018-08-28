package com.tencent.mm.plugin.voip.widget;

class a$4 implements Runnable {
    final /* synthetic */ a oVT;

    a$4(a aVar) {
        this.oVT = aVar;
    }

    public final void run() {
        this.oVT.oRM.setVisibility(4);
        a.a(this.oVT).setVisibility(0);
        a.b(this.oVT).setVisibility(0);
    }
}
