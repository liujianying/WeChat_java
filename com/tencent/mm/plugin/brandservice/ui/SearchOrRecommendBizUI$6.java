package com.tencent.mm.plugin.brandservice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class SearchOrRecommendBizUI$6 implements OnCancelListener {
    final /* synthetic */ SearchOrRecommendBizUI hpX;

    SearchOrRecommendBizUI$6(SearchOrRecommendBizUI searchOrRecommendBizUI) {
        this.hpX = searchOrRecommendBizUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        BizSearchResultItemContainer a = SearchOrRecommendBizUI.a(this.hpX);
        g.DF().c(a.hoL);
        a.hoJ.hoW = false;
    }
}
