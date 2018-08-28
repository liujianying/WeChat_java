package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.brandservice.ui.SearchOrRecommendBizUI.1;
import com.tencent.mm.sdk.platformtools.x;

class SearchOrRecommendBizUI$1$1 implements Runnable {
    final /* synthetic */ f hpY;
    final /* synthetic */ 1 hpZ;

    SearchOrRecommendBizUI$1$1(1 1, f fVar) {
        this.hpZ = 1;
        this.hpY = fVar;
    }

    public final void run() {
        x.i("MicroMsg.BrandService.SearchOrRecommendBizUI", "Has got recommend groups, so notifyDataSetChanged.");
        this.hpY.notifyDataSetChanged();
    }
}
