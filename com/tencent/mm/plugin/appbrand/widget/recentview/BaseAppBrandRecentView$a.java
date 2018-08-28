package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.RecyclerView$a;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

protected class BaseAppBrandRecentView$a extends RecyclerView$a<b> {
    a gPn;
    final /* synthetic */ BaseAppBrandRecentView gPo;

    /* synthetic */ BaseAppBrandRecentView$a(BaseAppBrandRecentView baseAppBrandRecentView, byte b) {
        this(baseAppBrandRecentView);
    }

    private BaseAppBrandRecentView$a(BaseAppBrandRecentView baseAppBrandRecentView) {
        this.gPo = baseAppBrandRecentView;
        this.gPn = new a();
        this.gPn.dXN = d.default_avatar;
    }

    public final int getItemCount() {
        if (this.gPo.getRecentItemList().size() % 4 != 0) {
            return this.gPo.getRecentItemList().size() + (4 - (this.gPo.getRecentItemList().size() % 4));
        }
        return this.gPo.getRecentItemList().size();
    }
}
