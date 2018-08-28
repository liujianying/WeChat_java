package com.tencent.mm.plugin.brandservice.ui;

class SearchOrRecommendBizUI$2 implements Runnable {
    final /* synthetic */ SearchOrRecommendBizUI hpX;
    final /* synthetic */ String hqa;

    SearchOrRecommendBizUI$2(SearchOrRecommendBizUI searchOrRecommendBizUI, String str) {
        this.hpX = searchOrRecommendBizUI;
        this.hqa = str;
    }

    public final void run() {
        SearchOrRecommendBizUI.b(this.hpX).setSearchContent(this.hqa);
        SearchOrRecommendBizUI.b(this.hpX).uBI.performClick();
    }
}
