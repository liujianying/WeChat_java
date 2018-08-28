package com.tencent.mm.plugin.appbrand.jsapi.coverview;

class d$2 implements Runnable {
    final /* synthetic */ d fPM;
    final /* synthetic */ WxaScrollView fPN;
    final /* synthetic */ int fPO;

    d$2(d dVar, WxaScrollView wxaScrollView, int i) {
        this.fPM = dVar;
        this.fPN = wxaScrollView;
        this.fPO = i;
    }

    public final void run() {
        this.fPN.scrollTo(this.fPN.getScrollX(), this.fPO);
    }
}
