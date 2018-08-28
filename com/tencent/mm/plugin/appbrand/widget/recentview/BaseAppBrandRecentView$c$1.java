package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;

class BaseAppBrandRecentView$c$1 implements Runnable {
    final /* synthetic */ c gPt;

    BaseAppBrandRecentView$c$1(c cVar) {
        this.gPt = cVar;
    }

    public final void run() {
        if (this.gPt.gPo.getRefreshListener() != null) {
            this.gPt.gPo.getRefreshListener().mq(this.gPt.gPo.getRecentItemList().size());
        }
        this.gPt.gPo.getAdapter().RR.notifyChanged();
    }
}
